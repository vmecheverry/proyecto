package com.vmecheverry.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmecheverry.pojos.Partner;

public class PartnerController {

	
	public PartnerController() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		PartnerController obj = new PartnerController();
		List<Partner> list=obj.loadList();
		obj.savePartner(list,"D:\\partner.json");
		
		//obj.listPartner();
		
	}
	
	
	 
	
	
	private List<Partner> loadList(){

			List<Partner> list=  new ArrayList<>();
			Partner p1= new Partner();
			p1.setBranch(true);
			p1.setBranches(null);
			p1.setAcronym("CIAT");
			p1.setName("Centro Internacional de Agricultura Tropical");
			p1.setType(null);
			p1.setCountry("Colombia");
			p1.setCity("Palmira");
			p1.setWebsite("http://ciat.cgiar.org");
			
			
			
			Partner p3= new Partner();
			p3.setBranch(true);
			p3.setBranches(null);
			p3.setAcronym("CIAT-Villavicencio");
			p3.setName("Centro Internacional de Agricultura Tropical");
			p3.setType(null);
			p3.setCountry("Colombia");
			p3.setCity("Villavicencio");
			p3.setWebsite("http://ciat.cgiar.org");
			
			
			Partner p2= new Partner();
			List<Partner> branchesList= new ArrayList<Partner>();
			branchesList.add(p3);
			p2.setBranch(true);
			p2.setBranches(branchesList);
			p2.setAcronym("CIAT");
			p2.setName("Centro Internacional de Agricultura Tropical");
			p2.setType(null);
			p2.setCountry("Colombia");
			p2.setCity("Palmira");
			p2.setWebsite("http://ciat.cgiar.org");
			
			list.add(p1);
			list.add(p2);
			return list;
	}

	
	
	public void savePartner(List<Partner> partnerList,String path){
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Convert object to JSON string and save into a file directly
			//mapper.writeValue(new File("D:\\partner.json"), partnerList);
			
			
			File file=new File(path);
			
			System.out.println(file.getAbsolutePath());
			
			mapper.writeValue(file, partnerList);

			/*// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(partnerList);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(partnerList);
			System.out.println(jsonInString);*/

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Partner> listPartner() {
		ObjectMapper mapper = new ObjectMapper();
		List<Partner> partnerList = new ArrayList<Partner>();
		try {
			partnerList = (List<Partner>) mapper.readValue(new File("partner.json"), List.class);
			//partnerList = (List<Partner>) mapper.readValue(new File("D:\\partner.json"), List.class);
		} catch (JsonGenerationException e) {
			//e.printStackTrace();
		} catch (JsonMappingException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return partnerList;
	}
}
