<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Results</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css"/>
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
</head>
<body>

	<h1>partners</h1>
    <%--  <h3>acronym: <s:property value="partner.acronym"></s:property> </h3>
 	<h3>name: <s:property value="partner.name"></s:property> </h3>
 	<h3>type: <s:property value="partner.type"></s:property> </h3>
 	<h3>country: <s:property value="partner.country"></s:property> </h3>
 	<h3>city: <s:property value="partner.city"></s:property> </h3>
 	<h3>website: <s:property value="partner.website"></s:property> </h3> --%>
 	
 	<table class="table table-hover"">
 		<tr>
 			<td>name</td>
			<td>acronym</td>
			<td>name</td>
			<td>type</td>
			<td>country</td>
			<td>city</td>
 		</tr>
 		
 		<s:iterator value="partnerList" status="listStatus">
  		<tr>
 		   	<s:if test="#listStatus.even == true">
 		   		<td><s:property value="%{name}"/></td>
				<td><s:property value="%{acronym}"/></td>
				<td><s:property value="%{name}"/></td>
				<td><s:property value="%{type}"/></td>
				<td><s:property value="%{country}"/></td>
				<td><s:property value="%{city}"/></td>
    		</s:if>
    		<s:elseif test="#listStatus.first == true">
      			<td><s:property value="%{name}"/></td>
				<td ><s:property value="%{acronym}"/></td>
				<td ><s:property value="%{name}"/></td>
				<td ><s:property value="%{type}"/></td>
				<td ><s:property value="%{country}"/></td>
				<td >"><s:property value="%{city}"/></td>
    		</s:elseif>
   	 		<s:else>
      			<td><s:property value="%{name}"/></td>
				<td ><s:property value="%{acronym}"/></td>
				<td ><s:property value="%{name}"/></td>
				<td ><s:property value="%{type}"/></td>
				<td ><s:property value="%{country}"/></td>
				<td >"><s:property value="%{city}"/></td>
    		</s:else>
  		</tr>
  		
</s:iterator>
 	</table>
 	
 	
</body>
</html>