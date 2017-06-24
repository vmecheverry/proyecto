<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>Insert title here</title>
</head>
<body>
	<center>
	<div class="content">
		<s:form action="hello" id="formRegister">
			<h3>Request a new institution or branch</h3>
			
			<table>
			<tr>
			<td colspan="2"><s:textfield label="Is this institution a branch?"></s:textfield></td>
			</tr>
			
			<tr>
			<td><s:textfield label="Select institution headquarter"></s:textfield></td>
			</tr>
			
			<tr>
			<td><s:textfield name="acronym"  label="Acronym"></s:textfield></td>
			<td><s:textfield label="Name"></s:textfield></td>
			</tr>
			
			<tr>
			<td><s:textfield label="Type"></s:textfield></td>
			<td><s:textfield label="Country"></s:textfield></td>
			</tr>
			
			<tr>
			<td><s:textfield label="City"></s:textfield></td>
			<td></td>
			</tr>
			
			<s:date name="fecha"  />
			
			<tr>
			<td colspan="2"><s:textfield label="If you know the partner website please paste the link below:"></s:textfield></td>
			</tr>
			
			</table>
			
			
			
			<h2><s:property value="%{saludo}"/></h2>
			
			
			<s:textfield name="name" label="User Name" value="%{saludo}"></s:textfield>
			<s:submit label="Request add new partner" value="Greet"></s:submit>
		</s:form>
	</div>
	</center>
</body>
</html>