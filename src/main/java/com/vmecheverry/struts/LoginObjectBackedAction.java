package com.vmecheverry.struts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vmecheverry.controller.PartnerController;
import com.vmecheverry.pojos.Partner;
 
@org.apache.struts2.convention.annotation.Action("loginObject")
@Namespace("/")
@ResultPath("/")
@Results({ 
		@Result(name = "success", location = "homeObject.jsp"),
        @Result(name = "input", location = "loginObject.jsp") })
public class LoginObjectBackedAction extends ActionSupport implements Action, ServletRequestAware, Serializable {
 
    private Partner partner;
    private HttpServletRequest servletRequest;
    
    private List<Partner> partnersListaaaa ;
	
    @Override
    public String execute() throws Exception {
    	System.out.println("Entre al bean !!!");
    	ServletContext context = ServletActionContext.getServletContext();
		String path = context.getRealPath("/partner.json");
    		
    	PartnerController obj = new PartnerController();
    	
    	
    	
    	
		List<Partner> list=obj.listPartner(path);
		
		list = new ArrayList<>(list);
		String responseValidation=validate(list, getPartner());
		
		System.out.println(responseValidation);
		
		if(responseValidation.equals("SUCESS")){
			list.add(this.partner);
			
			
			obj.savePartner(list,path);
			System.out.println("**********************************************");
	    	return SUCCESS;
		}else{
			return "input";
		}
		
		
    	

    }
    

    
    
    private String validate(List<Partner> list, Partner elemento){
    	
    	
    	String msg="SUCESS";
    	 HashMap<String, String> acronymMap = new HashMap<String, String>();
    	 
 
    	 
    	 for (Partner lista : list) {
    		 
    		 System.out.println(lista.getAcronym()+"!!!!!!!!!!!!!!!");
    		 if(acronymMap.get(partner.getAcronym())==null){
    			 acronymMap.put(lista.getAcronym(), lista.getAcronym());
    		 }
    		 
    		 
		}
    	 
    	 if(acronymMap.get(partner.getAcronym())!=null){
    		 System.out.println("Repetido");
    		 msg="Acronym is duplicated";
    		 
    		 addActionMessage("You are valid user!");
    		 
    	 }else{
    		 System.out.println("No enconttrado");
    	 }
    	 
    	 return msg;
    	 
    	
    }
 
    
	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
 
}