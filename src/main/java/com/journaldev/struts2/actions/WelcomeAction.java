package com.journaldev.struts2.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vmecheverry.controller.PartnerController;
import com.vmecheverry.pojos.Partner;

public class WelcomeAction extends ActionSupport {

	
	private Partner cityName2;
	private ArrayList<Partner> cities2;
	
	
	public Partner getCityName2() {
		return cityName2;
	}
	public void setCityName2(Partner cityName2) {
		this.cityName2 = cityName2;
	}
	public ArrayList<Partner> getCities2() {
		return cities2;
	}
	public void setCities2(ArrayList<Partner> cities2) {
		this.cities2 = cities2;
	}
	
	 
	@Override
	public String execute(){
		return "success";
	}

	@Override
	public void validate() {
		System.out.println("Entre al metodo de validar");
		System.out.println(getUsername());
		System.out.println("1)getName "+partner.getName());
		System.out.println("2)is branch? "+partner.getBranch());
		System.out.println("3)getBranches "+partner.getBranches());
		System.out.println("4)getType "+partner.getType());
		System.out.println("5)getCountry "+partner.getCountry());
		System.out.println("6)getCity "+partner.getCity());
		System.out.println("7)getWebsite "+partner.getWebsite());
		
    	ServletContext context = ServletActionContext.getServletContext();
		String path = context.getRealPath("/partner.json");
    	PartnerController obj = new PartnerController();
    	List<Partner> list=obj.listPartner(path);
		list = new ArrayList<>(list);
		String responseValidation=validateData(list, getPartner());
		System.out.println(responseValidation);
		
		

		if(responseValidation.equals("SUCESS")){
			list.add(this.partner);
			obj.savePartner(list,path);
			System.out.println("**********************************************");
		}else{
			addActionError(responseValidation);
		}
		
		
		/*if("vmecheverry".equalsIgnoreCase(getUsername()) && "admin".equalsIgnoreCase(getPassword())){
			addActionMessage("Welcome Admin, do some work.");
		}else{
			if(!"pankaj".equalsIgnoreCase(getUsername())){
				addActionError("User name is not valid");
			}
			if(!"admin".equalsIgnoreCase(getPassword())){
				addActionError("Password is wrong");
			}
		}*/
	}
	
	
	
    private String validateData(List<Partner> list, Partner elemento){
    	
    	
    	String msg="SUCESS";
    	 HashMap<String, String> acronymMap = new HashMap<String, String>();
    	 HashMap<String, String> nameMap = new HashMap<String, String>();
    	 
    	 System.out.println(elemento.getName());
    	 
    	 for (Partner lista : list) {
    		 
    		 
    		/* if(acronymMap.get(lista.getAcronym())!=null && (!acronymMap.get(lista.getAcronym()).trim().equalsIgnoreCase(""))){
    			 if(acronymMap.get(lista.getAcronym())==null){
        			 acronymMap.put(lista.getAcronym(), lista.getAcronym());
        		 }
    		 }
    		 
    		 if(nameMap.get(lista.getName())!=null && (!nameMap.get(lista.getName()).trim().equalsIgnoreCase(""))){
    			 if(nameMap.get(lista.getName())==null ){
        			 nameMap.put(lista.getName(), lista.getName());
        		 }
    			 
    		 }*/
    		 
    			 if(acronymMap.get(lista.getAcronym())==null){
        			 acronymMap.put(lista.getAcronym(), lista.getAcronym());
        		 }
    			 if(nameMap.get(lista.getName())==null ){
        			 nameMap.put(lista.getName(), lista.getName());
        		 }
    		
		}
    	 
    	 if(acronymMap.get(elemento.getAcronym())!=null){
    		 msg="Acronym is duplicated";
    		 
    		 if(acronymMap.get(elemento.getAcronym())!=null){
        		 msg="Acronym and name are duplicated";
        	 }
    	 }else{
    		 if(acronymMap.get(elemento.getAcronym())!=null){
        		 msg="Name is duplicated";
        	 }
    	 }
    	 
    	 
    	 
    	 return msg;
    	 
    	
    }
	
	private Partner partner;

	// java bean properties
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}


	
	
	
	

}