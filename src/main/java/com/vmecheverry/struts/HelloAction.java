package com.vmecheverry.struts;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String name;
	
	public String greet(){
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
