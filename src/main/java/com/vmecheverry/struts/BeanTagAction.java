package com.vmecheverry.struts;

import java.util.List;
import com.vmecheverry.pojos.*;
import com.opensymphony.xwork2.ActionSupport;

public class BeanTagAction extends ActionSupport{

	
	private List<Partner> partnerList;
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String execute() {
		return SUCCESS;
	}

}