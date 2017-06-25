package com.mkyong.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vmecheverry.controller.PartnerController;
import com.vmecheverry.pojos.Partner;

public class SelectAction extends ActionSupport{

	private List<Partner> searchEngine;

	private String yourSearchEngine;
	private String yourMonth;

	public String getYourMonth() {
		return yourMonth;
	}

	public void setYourMonth(String yourMonth) {
		this.yourMonth = yourMonth;
	}

	public List<Partner> getSearchEngine() {
		return searchEngine;
	}

	public void setSearchEngine(List<Partner> searchEngine) {
		this.searchEngine = searchEngine;
	}

	public String getYourSearchEngine() {
		return yourSearchEngine;
	}

	public void setYourSearchEngine(String yourSearchEngine) {
		this.yourSearchEngine = yourSearchEngine;
	}

	public String getDefaultSearchEngine() {
		return "yahoo.com";
	}

	
	@Override
	public void validate() {
		System.out.println("Entre al metodo de validar");
		
		if(partner!=null){
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
				
				if(partner.getBranch().equals("1")){
					System.out.println("Es Branch !!!!");
					System.out.println(yourSearchEngine);
					
					
				}
				
				//obj.savePartner(list,path);
				System.out.println("**********************************************");
			}else{
				addActionError(responseValidation);
			}
		}
		
		
	}
	
	public SelectAction(){
		
		searchEngine=  new ArrayList<Partner>();
		
		
		ServletContext context = ServletActionContext.getServletContext();
		String path = context.getRealPath("/partner.json");
    	PartnerController obj = new PartnerController();
    	List<Partner> list=obj.listPartner(path);
    	searchEngine = new ArrayList<>(list);
	}

	public String execute() {
		return SUCCESS;
	}

	public String display() {
		return NONE;
	}
	
	
    private String validateData(List<Partner> list, Partner elemento){
    	
    	System.out.println("-----------------------------"+yourSearchEngine);
    	
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
    		 
    		 if(nameMap.get(elemento.getName())!=null){
        		 msg="Acronym and name are duplicated";
        	 }
    	 }else{
    		 if(nameMap.get(elemento.getName())!=null){
        		 msg="Name is duplicated";
        	 }
    	 }
    	 
    	 
    	 
    	 return msg;
    	 
    	
    }
    
    private Partner partner;

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

    
    

}