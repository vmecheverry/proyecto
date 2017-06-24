package com.vmecheverry.struts;

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
import com.vmecheverry.controller.PartnerController;
import com.vmecheverry.pojos.Partner;
 
@org.apache.struts2.convention.annotation.Action("loginObject")
@Namespace("/")
@ResultPath("/")
@Results({ 
		@Result(name = "success", location = "homeObject.jsp"),
        @Result(name = "input", location = "loginObject.jsp") })
public class LoginObjectBackedAction implements Action, ServletRequestAware {
 
    private Partner partner;
    private HttpServletRequest servletRequest;
	
    @Override
    public String execute() throws Exception {
    	System.out.println("Entre al bean !!!");
    	
    	//Validacion
    	
       /* if("pankaj".equals(getUser().getUserID()) && "admin".equals(getUser().getPassword())){
            getUser().setUserName("Pankaj Kumar");
            return SUCCESS;
        }else{
            return INPUT;
        }*/
    	
    	PartnerController obj = new PartnerController();
		List<Partner> list=obj.listPartner();
		
	
		list.add(getPartner());
		
		ServletContext context = ServletActionContext.getServletContext();
		String path = context.getRealPath("/partner.json");
		obj.savePartner(list,path);
		System.out.println("**********************************************");

    	
    	return SUCCESS;
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