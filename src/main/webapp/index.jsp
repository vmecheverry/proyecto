<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/style.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<center>
	<div class="content">
		<s:form action="hello">
			<h3>Request a new institution or branch</h3>
			
			<table>
			<tr>
			<td colspan="2"><s:textfield label="Is this institution a branch?"></s:textfield></td>
			</tr>
			
			<tr>
			<td><s:textfield label="Select institution headquarter"></s:textfield></td>
			</tr>
			
			<tr>
			<td><s:textfield label="Acronym"></s:textfield></td>
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
			
			
			
			
			
			
			<s:textfield name="name" label="User Name"></s:textfield>
			<s:submit label="Request add new partner" value="Greet"></s:submit>
		</s:form>
	</div>
	</center>
</body>
</html>