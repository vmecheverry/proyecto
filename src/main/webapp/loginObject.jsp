<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="resources/css/style.css" type="text/css"/>
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#formRegister').validate({
			rules:{
				'acronym':{
					 maxlength: 9
					 
				},
				'name':{
					required:true,
					 minlength: 3,
					 maxlength: 8
					 
				}
			}
		});	
	});
</script>

</head>
<body>
    <center>
	<div class="content">
		<s:form action="loginObject" id="formRegister">
		
		
		<s:if test="hasActionErrors()">
		   <div class="errors">
		      <s:actionerror/>
		      holaaaaaaa
		   </div>
		</s:if>
		
			<h3>Request a new institution or branch</h3>
			<table>
			<tr>
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
			<td><s:textfield  name="partner.acronym" 	label="acronym"></s:textfield></td>
			<td><s:textfield  name="partner.name" 		label="name"></s:textfield></td>
			<td><s:textfield  name="partner.type" 		label="type"></s:textfield></td>
			<td><s:textfield  name="partner.country" 	label="country"></s:textfield></td>
			<td><s:textfield  name="partner.city" 		label="city"></s:textfield></td>
			<td><s:textfield  name="partner.website" 	label="website"></s:textfield></td>
			</tr>
			
			<s:submit value="Login"></s:submit>
			</table>
		</s:form>
	</div>
	</center>
</body>
</html>