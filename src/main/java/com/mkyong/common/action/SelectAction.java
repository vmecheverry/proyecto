package com.mkyong.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vmecheverry.controller.PartnerController;
import com.vmecheverry.pojos.Country;
import com.vmecheverry.pojos.Partner;

public class SelectAction extends ActionSupport{

	private List<Partner> searchEngine;
	private List<Country> countries;

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
	
	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
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
				if(partner.getBranch().equals("1")){
					System.out.println("Es Branch !!!!");
					System.out.println(yourSearchEngine);
					for (Partner currentPartner : list) {
						if(currentPartner.getName().equals(yourSearchEngine)){
							System.out.println("Encontrado");
							currentPartner.getBranches().add(this.partner);
							currentPartner.setBranches(currentPartner.getBranches());
						}
					}
				}else{
					list.add(this.partner);
				}
				
				obj.savePartner(list,path);
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
    	
    	
    	countries= new ArrayList<Country>();
    	Country obj1;
    	obj1= new Country("AD","Andorra"); countries.add(obj1);
    	obj1= new Country("AE","United Arab Emirates"); countries.add(obj1);
    	obj1= new Country("AF","Afghanistan"); countries.add(obj1);
    	obj1= new Country("AG","Antigua and Barbuda"); countries.add(obj1);
    	obj1= new Country("AI","Anguilla"); countries.add(obj1);
    	obj1= new Country("AL","Albania"); countries.add(obj1);
    	obj1= new Country("AM","Armenia"); countries.add(obj1);
    	obj1= new Country("AN","Netherlands Antilles"); countries.add(obj1);
    	obj1= new Country("AO","Angola"); countries.add(obj1);
    	obj1= new Country("AQ","Antarctica"); countries.add(obj1);
    	obj1= new Country("AR","Argentina"); countries.add(obj1);
    	obj1= new Country("ARPA","Old style Arpanet"); countries.add(obj1);
    	obj1= new Country("AS","American Samoa"); countries.add(obj1);
    	obj1= new Country("AT","Austria"); countries.add(obj1);
    	obj1= new Country("AU","Australia"); countries.add(obj1);
    	obj1= new Country("AW","Aruba"); countries.add(obj1);
    	obj1= new Country("AZ","Azerbaidjan"); countries.add(obj1);
    	obj1= new Country("BA","Bosnia-Herzegovina"); countries.add(obj1);
    	obj1= new Country("BB","Barbados"); countries.add(obj1);
    	obj1= new Country("BD","Bangladesh"); countries.add(obj1);
    	obj1= new Country("BE","Belgium"); countries.add(obj1);
    	obj1= new Country("BF","Burkina Faso"); countries.add(obj1);
    	obj1= new Country("BG","Bulgaria"); countries.add(obj1);
    	obj1= new Country("BH","Bahrain"); countries.add(obj1);
    	obj1= new Country("BI","Burundi"); countries.add(obj1);
    	obj1= new Country("BJ","Benin"); countries.add(obj1);
    	obj1= new Country("BM","Bermuda"); countries.add(obj1);
    	obj1= new Country("BN","Brunei Darussalam"); countries.add(obj1);
    	obj1= new Country("BO","Bolivia"); countries.add(obj1);
    	obj1= new Country("BR","Brazil"); countries.add(obj1);
    	obj1= new Country("BS","Bahamas"); countries.add(obj1);
    	obj1= new Country("BT","Bhutan"); countries.add(obj1);
    	obj1= new Country("BV","Bouvet Island"); countries.add(obj1);
    	obj1= new Country("BW","Botswana"); countries.add(obj1);
    	obj1= new Country("BY","Belarus"); countries.add(obj1);
    	obj1= new Country("BZ","Belize"); countries.add(obj1);
    	obj1= new Country("CA","Canada"); countries.add(obj1);
    	obj1= new Country("CC","Cocos (Keeling) Islands"); countries.add(obj1);
    	obj1= new Country("CF","Central African Republic"); countries.add(obj1);
    	obj1= new Country("CG","Congo"); countries.add(obj1);
    	obj1= new Country("CH","Switzerland"); countries.add(obj1);
    	obj1= new Country("CI","Ivory Coast (Cote D'Ivoire)"); countries.add(obj1);
    	obj1= new Country("CK","Cook Islands"); countries.add(obj1);
    	obj1= new Country("CL","Chile"); countries.add(obj1);
    	obj1= new Country("CM","Cameroon"); countries.add(obj1);
    	obj1= new Country("CN","China"); countries.add(obj1);
    	obj1= new Country("CO","Colombia"); countries.add(obj1);
    	obj1= new Country("COM","Commercial"); countries.add(obj1);
    	obj1= new Country("CR","Costa Rica"); countries.add(obj1);
    	obj1= new Country("CS","Former Czechoslovakia"); countries.add(obj1);
    	obj1= new Country("CU","Cuba"); countries.add(obj1);
    	obj1= new Country("CV","Cape Verde"); countries.add(obj1);
    	obj1= new Country("CX","Christmas Island"); countries.add(obj1);
    	obj1= new Country("CY","Cyprus"); countries.add(obj1);
    	obj1= new Country("CZ","Czech Republic"); countries.add(obj1);
    	obj1= new Country("DE","Germany"); countries.add(obj1);
    	obj1= new Country("DJ","Djibouti"); countries.add(obj1);
    	obj1= new Country("DK","Denmark"); countries.add(obj1);
    	obj1= new Country("DM","Dominica"); countries.add(obj1);
    	obj1= new Country("DO","Dominican Republic"); countries.add(obj1);
    	obj1= new Country("DZ","Algeria"); countries.add(obj1);
    	obj1= new Country("EC","Ecuador"); countries.add(obj1);
    	obj1= new Country("EDU","USA Educational"); countries.add(obj1);
    	obj1= new Country("EE","Estonia"); countries.add(obj1);
    	obj1= new Country("EG","Egypt"); countries.add(obj1);
    	obj1= new Country("EH","Western Sahara"); countries.add(obj1);
    	obj1= new Country("ER","Eritrea"); countries.add(obj1);
    	obj1= new Country("ES","Spain"); countries.add(obj1);
    	obj1= new Country("ET","Ethiopia"); countries.add(obj1);
    	obj1= new Country("FI","Finland"); countries.add(obj1);
    	obj1= new Country("FJ","Fiji"); countries.add(obj1);
    	obj1= new Country("FK","Falkland Islands"); countries.add(obj1);
    	obj1= new Country("FM","Micronesia"); countries.add(obj1);
    	obj1= new Country("FO","Faroe Islands"); countries.add(obj1);
    	obj1= new Country("FR","France"); countries.add(obj1);
    	obj1= new Country("FX","France (European Territory)"); countries.add(obj1);
    	obj1= new Country("GA","Gabon"); countries.add(obj1);
    	obj1= new Country("GB","Great Britain"); countries.add(obj1);
    	obj1= new Country("GD","Grenada"); countries.add(obj1);
    	obj1= new Country("GE","Georgia"); countries.add(obj1);
    	obj1= new Country("GF","French Guyana"); countries.add(obj1);
    	obj1= new Country("GH","Ghana"); countries.add(obj1);
    	obj1= new Country("GI","Gibraltar"); countries.add(obj1);
    	obj1= new Country("GL","Greenland"); countries.add(obj1);
    	obj1= new Country("GM","Gambia"); countries.add(obj1);
    	obj1= new Country("GN","Guinea"); countries.add(obj1);
    	obj1= new Country("GOV","USA Government"); countries.add(obj1);
    	obj1= new Country("GP","Guadeloupe (French)"); countries.add(obj1);
    	obj1= new Country("GQ","Equatorial Guinea"); countries.add(obj1);
    	obj1= new Country("GR","Greece"); countries.add(obj1);
    	obj1= new Country("GS","S. Georgia & S. Sandwich Isls."); countries.add(obj1);
    	obj1= new Country("GT","Guatemala"); countries.add(obj1);
    	obj1= new Country("GU","Guam (USA)"); countries.add(obj1);
    	obj1= new Country("GW","Guinea Bissau"); countries.add(obj1);
    	obj1= new Country("GY","Guyana"); countries.add(obj1);
    	obj1= new Country("HK","Hong Kong"); countries.add(obj1);
    	obj1= new Country("HM","Heard and McDonald Islands"); countries.add(obj1);
    	obj1= new Country("HN","Honduras"); countries.add(obj1);
    	obj1= new Country("HR","Croatia"); countries.add(obj1);
    	obj1= new Country("HT","Haiti"); countries.add(obj1);
    	obj1= new Country("HU","Hungary"); countries.add(obj1);
    	obj1= new Country("ID","Indonesia"); countries.add(obj1);
    	obj1= new Country("IE","Ireland"); countries.add(obj1);
    	obj1= new Country("IL","Israel"); countries.add(obj1);
    	obj1= new Country("IN","India"); countries.add(obj1);
    	obj1= new Country("INT","International"); countries.add(obj1);
    	obj1= new Country("IO","British Indian Ocean Territory"); countries.add(obj1);
    	obj1= new Country("IQ","Iraq"); countries.add(obj1);
    	obj1= new Country("IR","Iran"); countries.add(obj1);
    	obj1= new Country("IS","Iceland"); countries.add(obj1);
    	obj1= new Country("IT","Italy"); countries.add(obj1);
    	obj1= new Country("JM","Jamaica"); countries.add(obj1);
    	obj1= new Country("JO","Jordan"); countries.add(obj1);
    	obj1= new Country("JP","Japan"); countries.add(obj1);
    	obj1= new Country("KE","Kenya"); countries.add(obj1);
    	obj1= new Country("KG","Kyrgyzstan"); countries.add(obj1);
    	obj1= new Country("KH","Cambodia"); countries.add(obj1);
    	obj1= new Country("KI","Kiribati"); countries.add(obj1);
    	obj1= new Country("KM","Comoros"); countries.add(obj1);
    	obj1= new Country("KN","Saint Kitts & Nevis Anguilla"); countries.add(obj1);
    	obj1= new Country("KP","North Korea"); countries.add(obj1);
    	obj1= new Country("KR","South Korea"); countries.add(obj1);
    	obj1= new Country("KW","Kuwait"); countries.add(obj1);
    	obj1= new Country("KY","Cayman Islands"); countries.add(obj1);
    	obj1= new Country("KZ","Kazakhstan"); countries.add(obj1);
    	obj1= new Country("LA","Laos"); countries.add(obj1);
    	obj1= new Country("LB","Lebanon"); countries.add(obj1);
    	obj1= new Country("LC","Saint Lucia"); countries.add(obj1);
    	obj1= new Country("LI","Liechtenstein"); countries.add(obj1);
    	obj1= new Country("LK","Sri Lanka"); countries.add(obj1);
    	obj1= new Country("LR","Liberia"); countries.add(obj1);
    	obj1= new Country("LS","Lesotho"); countries.add(obj1);
    	obj1= new Country("LT","Lithuania"); countries.add(obj1);
    	obj1= new Country("LU","Luxembourg"); countries.add(obj1);
    	obj1= new Country("LV","Latvia"); countries.add(obj1);
    	obj1= new Country("LY","Libya"); countries.add(obj1);
    	obj1= new Country("MA","Morocco"); countries.add(obj1);
    	obj1= new Country("MC","Monaco"); countries.add(obj1);
    	obj1= new Country("MD","Moldavia"); countries.add(obj1);
    	obj1= new Country("MG","Madagascar"); countries.add(obj1);
    	obj1= new Country("MH","Marshall Islands"); countries.add(obj1);
    	obj1= new Country("MIL","USA Military"); countries.add(obj1);
    	obj1= new Country("MK","Macedonia"); countries.add(obj1);
    	obj1= new Country("ML","Mali"); countries.add(obj1);
    	obj1= new Country("MM","Myanmar"); countries.add(obj1);
    	obj1= new Country("MN","Mongolia"); countries.add(obj1);
    	obj1= new Country("MO","Macau"); countries.add(obj1);
    	obj1= new Country("MP","Northern Mariana Islands"); countries.add(obj1);
    	obj1= new Country("MQ","Martinique (French)"); countries.add(obj1);
    	obj1= new Country("MR","Mauritania"); countries.add(obj1);
    	obj1= new Country("MS","Montserrat"); countries.add(obj1);
    	obj1= new Country("MT","Malta"); countries.add(obj1);
    	obj1= new Country("MU","Mauritius"); countries.add(obj1);
    	obj1= new Country("MV","Maldives"); countries.add(obj1);
    	obj1= new Country("MW","Malawi"); countries.add(obj1);
    	obj1= new Country("MX","Mexico"); countries.add(obj1);
    	obj1= new Country("MY","Malaysia"); countries.add(obj1);
    	obj1= new Country("MZ","Mozambique"); countries.add(obj1);
    	obj1= new Country("NA","Namibia"); countries.add(obj1);
    	obj1= new Country("NATO","NATO (this was purged in 1996 - see hq.nato.int)"); countries.add(obj1);
    	obj1= new Country("NC","New Caledonia (French)"); countries.add(obj1);
    	obj1= new Country("NE","Niger"); countries.add(obj1);
    	obj1= new Country("NET","Network"); countries.add(obj1);
    	obj1= new Country("NF","Norfolk Island"); countries.add(obj1);
    	obj1= new Country("NG","Nigeria"); countries.add(obj1);
    	obj1= new Country("NI","Nicaragua"); countries.add(obj1);
    	obj1= new Country("NL","Netherlands"); countries.add(obj1);
    	obj1= new Country("NO","Norway"); countries.add(obj1);
    	obj1= new Country("NP","Nepal"); countries.add(obj1);
    	obj1= new Country("NR","Nauru"); countries.add(obj1);
    	obj1= new Country("NT","Neutral Zone"); countries.add(obj1);
    	obj1= new Country("NU","Niue"); countries.add(obj1);
    	obj1= new Country("NZ","New Zealand"); countries.add(obj1);
    	obj1= new Country("OM","Oman"); countries.add(obj1);
    	obj1= new Country("ORG","Non-Profit Making Organisations (sic)"); countries.add(obj1);
    	obj1= new Country("PA","Panama"); countries.add(obj1);
    	obj1= new Country("PE","Peru"); countries.add(obj1);
    	obj1= new Country("PF","Polynesia (French)"); countries.add(obj1);
    	obj1= new Country("PG","Papua New Guinea"); countries.add(obj1);
    	obj1= new Country("PH","Philippines"); countries.add(obj1);
    	obj1= new Country("PK","Pakistan"); countries.add(obj1);
    	obj1= new Country("PL","Poland"); countries.add(obj1);
    	obj1= new Country("PM","Saint Pierre and Miquelon"); countries.add(obj1);
    	obj1= new Country("PN","Pitcairn Island"); countries.add(obj1);
    	obj1= new Country("PR","Puerto Rico"); countries.add(obj1);
    	obj1= new Country("PT","Portugal"); countries.add(obj1);
    	obj1= new Country("PW","Palau"); countries.add(obj1);
    	obj1= new Country("PY","Paraguay"); countries.add(obj1);
    	obj1= new Country("QA","Qatar"); countries.add(obj1);
    	obj1= new Country("RE","Reunion (French)"); countries.add(obj1);
    	obj1= new Country("RO","Romania"); countries.add(obj1);
    	obj1= new Country("RU","Russian Federation"); countries.add(obj1);
    	obj1= new Country("RW","Rwanda"); countries.add(obj1);
    	obj1= new Country("SA","Saudi Arabia"); countries.add(obj1);
    	obj1= new Country("SB","Solomon Islands"); countries.add(obj1);
    	obj1= new Country("SC","Seychelles"); countries.add(obj1);
    	obj1= new Country("SD","Sudan"); countries.add(obj1);
    	obj1= new Country("SE","Sweden"); countries.add(obj1);
    	obj1= new Country("SG","Singapore"); countries.add(obj1);
    	obj1= new Country("SH","Saint Helena"); countries.add(obj1);
    	obj1= new Country("SI","Slovenia"); countries.add(obj1);
    	obj1= new Country("SJ","Svalbard and Jan Mayen Islands"); countries.add(obj1);
    	obj1= new Country("SK","Slovak Republic"); countries.add(obj1);
    	obj1= new Country("SL","Sierra Leone"); countries.add(obj1);
    	obj1= new Country("SM","San Marino"); countries.add(obj1);
    	obj1= new Country("SN","Senegal"); countries.add(obj1);
    	obj1= new Country("SO","Somalia"); countries.add(obj1);
    	obj1= new Country("SR","Suriname"); countries.add(obj1);
    	obj1= new Country("ST","Saint Tome (Sao Tome) and Principe"); countries.add(obj1);
    	obj1= new Country("SU","Former USSR"); countries.add(obj1);
    	obj1= new Country("SV","El Salvador"); countries.add(obj1);
    	obj1= new Country("SY","Syria"); countries.add(obj1);
    	obj1= new Country("SZ","Swaziland"); countries.add(obj1);
    	obj1= new Country("TC","Turks and Caicos Islands"); countries.add(obj1);
    	obj1= new Country("TD","Chad"); countries.add(obj1);
    	obj1= new Country("TF","French Southern Territories"); countries.add(obj1);
    	obj1= new Country("TG","Togo"); countries.add(obj1);
    	obj1= new Country("TH","Thailand"); countries.add(obj1);
    	obj1= new Country("TJ","Tadjikistan"); countries.add(obj1);
    	obj1= new Country("TK","Tokelau"); countries.add(obj1);
    	obj1= new Country("TM","Turkmenistan"); countries.add(obj1);
    	obj1= new Country("TN","Tunisia"); countries.add(obj1);
    	obj1= new Country("TO","Tonga"); countries.add(obj1);
    	obj1= new Country("TP","East Timor"); countries.add(obj1);
    	obj1= new Country("TR","Turkey"); countries.add(obj1);
    	obj1= new Country("TT","Trinidad and Tobago"); countries.add(obj1);
    	obj1= new Country("TV","Tuvalu"); countries.add(obj1);
    	obj1= new Country("TW","Taiwan"); countries.add(obj1);
    	obj1= new Country("TZ","Tanzania"); countries.add(obj1);
    	obj1= new Country("UA","Ukraine"); countries.add(obj1);
    	obj1= new Country("UG","Uganda"); countries.add(obj1);
    	obj1= new Country("UK","United Kingdom"); countries.add(obj1);
    	obj1= new Country("UM","USA Minor Outlying Islands"); countries.add(obj1);
    	obj1= new Country("US","United States"); countries.add(obj1);
    	obj1= new Country("UY","Uruguay"); countries.add(obj1);
    	obj1= new Country("UZ","Uzbekistan"); countries.add(obj1);
    	obj1= new Country("VA","Vatican City State"); countries.add(obj1);
    	obj1= new Country("VC","Saint Vincent & Grenadines"); countries.add(obj1);
    	obj1= new Country("VE","Venezuela"); countries.add(obj1);
    	obj1= new Country("VG","Virgin Islands (British)"); countries.add(obj1);
    	obj1= new Country("VI","Virgin Islands (USA)"); countries.add(obj1);
    	obj1= new Country("VN","Vietnam"); countries.add(obj1);
    	obj1= new Country("VU","Vanuatu"); countries.add(obj1);
    	obj1= new Country("WF","Wallis and Futuna Islands"); countries.add(obj1);
    	obj1= new Country("WS","Samoa"); countries.add(obj1);
    	obj1= new Country("YE","Yemen"); countries.add(obj1);
    	obj1= new Country("YT","Mayotte"); countries.add(obj1);
    	obj1= new Country("YU","Yugoslavia"); countries.add(obj1);
    	obj1= new Country("ZA","South Africa"); countries.add(obj1);
    	obj1= new Country("ZM","Zambia"); countries.add(obj1);
    	obj1= new Country("ZR","Zaire"); countries.add(obj1);
    	obj1= new Country("ZW","Zimbabwe"); countries.add(obj1);
    	
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
    	 
    	 if(elemento.getBranch().equals("1")){
    		 
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