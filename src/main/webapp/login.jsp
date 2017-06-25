<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/style.css" type="text/css"/>
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#formRegister').validate({
			rules:{
				'partner.acronym':{
					required:true,	
					 maxlength: 9
					 
				},
				'partner.name':{
					required:true,
					 minlength: 3,
					 maxlength: 8
					 
				}
			}
		});	
	});
</script>
<title>Login Page</title>
<!-- Adding CSS for Styling of error messages -->
<style type="text/css">
.errorDiv{
	background-color:gray;
	border:1px solid black;
	width:400px;
	margin-bottom:8px;
}
</style>
</head>
<body>
<h3>Struts2 ActionError Example</h3>

<%-- hasActionErrors() method is defined in ActionSupport --%>
<s:if test="hasActionErrors()">
	<div class="errorDiv">
		<s:actionerror/>
	</div>
</s:if>

<s:form action="Welcome" id="formRegister">


<h2>
	<%-- <s:select label="What's your favor search engine"
		headerKey="-1" headerValue="Select Search Engines"
		list="searchEngine"
		name="yourSearchEngine"
		value="defaultSearchEngine" /> --%>
</h2>

<h2>
	<s:select label="Select a month"
		headerKey="-1" headerValue="Select Month"
		list="#{'1':'Jan', '2':'Feb', '3':'Mar', '4':'Apr'}"
		name="yourMonth"
		value="2" />
</h2>



<s:textfield name="partner.name" 		label="name(*)"></s:textfield>
<s:radio label="Is this institution a branch?(*)" name="partner.branch" list="#{'1':'Yes','2':'No'}" value="2"  />
<s:textfield label="Select institution headquarter" disabled="true"></s:textfield>
<s:textfield name="partner.acronym"  label="Acronym(*)"></s:textfield>
	<s:select label="Type"
       name="partner.type"
       headerKey="-1" headerValue="Type"
       list="
       #{
       '01':'Academic Institution', 
       '02':'Donor',
       '03':'Non-Governammental Organization',
       '04':'Research Institution'}"
       value="2"
       required="true"
/>
<s:textfield name="partner.country"	label="Country"></s:textfield>
<s:textfield name="partner.city"	label="City"></s:textfield>
<s:textfield name="partner.website"	label="If you know the partner website please paste the link below"></s:textfield>
<s:submit key="label.submit.login" align="center" name="submit"></s:submit>
</s:form>
</body>
</html>