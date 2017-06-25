package javabeat.net.struts2;

import java.util.ArrayList;
import java.util.List;

import com.vmecheverry.pojos.Partner;
public class Struts2UITagsAction{
	private String cityName;
	private ArrayList<String> cities;
	
	private Partner cityName2;
	private ArrayList<Partner> cities2;

	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public ArrayList<String> getCities() {
		return cities;
	}
	public void setCities(ArrayList<String> cities) {
		this.cities = cities;
	}
	
	
	
	
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
	public String execute(){
		System.out.println("cityName  "+cityName);
		System.out.println("cityName2  "+cityName2);
		/*if (cityName2 == null ){
			cities2=  new ArrayList<Partner>();
			Partner p1= new Partner();
			p1.setBranch("1");
			p1.setBranches(null);
			p1.setAcronym("CIAT");
			p1.setName("Elemento 1");
			p1.setType(null);
			p1.setCountry("Colombia");
			p1.setCity("Palmira");
			p1.setWebsite("http://ciat.cgiar.org");
			
			
			
			Partner p3= new Partner();
			p3.setBranch("2");
			p3.setBranches(null);
			p3.setAcronym("CIAT-Villavicencio");
			p3.setName("Elemento 2");
			p3.setType(null);
			p3.setCountry("Colombia");
			p3.setCity("Villavicencio");
			p3.setWebsite("http://ciat.cgiar.org");
			
			
			Partner p2= new Partner();
			List<Partner> branchesList= new ArrayList<Partner>();
			branchesList.add(p3);
			p2.setBranch("1");
			p2.setBranches(branchesList);
			p2.setAcronym("CIAT");
			p2.setName("Elemento 3");
			p2.setType(null);
			p2.setCountry("Colombia");
			p2.setCity("Palmira");
			p2.setWebsite("http://ciat.cgiar.org");
			
			cities2.add(p1);
			cities2.add(p2);
			cities2.add(p3);
			
			System.out.println("holaaaa");
			return "INDEX";
		}*/
		if (cityName == null || cityName.trim().length() == 0){
			cities = new ArrayList<String>();
			cities.add("London");
			cities.add("Newyork");
			cities.add("Tokyo");
			
			cities2=  new ArrayList<Partner>();
			Partner p1= new Partner();
			p1.setBranch("1");
			p1.setBranches(null);
			p1.setAcronym("CIAT");
			p1.setName("Elemento 1");
			p1.setType(null);
			p1.setCountry("Colombia");
			p1.setCity("Palmira");
			p1.setWebsite("http://ciat.cgiar.org");
			
			
			
			Partner p3= new Partner();
			p3.setBranch("2");
			p3.setBranches(null);
			p3.setAcronym("CIAT-Villavicencio");
			p3.setName("Elemento 2");
			p3.setType(null);
			p3.setCountry("Colombia");
			p3.setCity("Villavicencio");
			p3.setWebsite("http://ciat.cgiar.org");
			
			
			Partner p2= new Partner();
			List<Partner> branchesList= new ArrayList<Partner>();
			branchesList.add(p3);
			p2.setBranch("1");
			p2.setBranches(branchesList);
			p2.setAcronym("CIAT");
			p2.setName("Elemento 3");
			p2.setType(null);
			p2.setCountry("Colombia");
			p2.setCity("Palmira");
			p2.setWebsite("http://ciat.cgiar.org");
			
			cities2.add(p1);
			cities2.add(p2);
			cities2.add(p3);
			
			return "INDEX";
		}
		return "success";
	}
	
	

	
}