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
	<dir class="form-group">
	<h1>partners</h1>
	</dir>
	
   
 	
 	<table class="table table-hover"">
 		<tr>
 			<td>name</td>
			<td>acronym</td>
			<td>name</td>
			<td>type</td>
			<td>country</td>
			<td>city</td>
 		</tr>
 		
 		<s:iterator value="partnerList" status="listStatus" var="parent">
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
    <td ><s:property value="%{city}"/> </td>
      </s:elseif>
       <s:else>
         <td><s:property value="%{name}"/></td>
    <td ><s:property value="%{acronym}"/></td>
    <td ><s:property value="%{name}"/></td>
    <td ><s:property value="%{type}"/></td>
    <td ><s:property value="%{country}"/></td>
    <td ><s:property value="%{city}"/> </td>
      </s:else>
    </tr>
    <s:if test="%{branches.size>0}">
     <tr>
      <td colspan="6" style="background-color: #99CCFF"><b>Branch of <s:property value="%{name}"/>  </b> </td>
     </tr>
     <s:iterator value="%{branches}" status="subPartnerlistStatus" var="child">
      <tr>      
       <td><b> <s:property value="#parent.name"/> - <s:property value="%{name}"/></b>  </td>
     <td ><s:property value="%{acronym}"/></td>
     <td ><s:property value="%{name}"/></td>
     <td ><s:property value="%{type}"/></td>
     <td ><s:property value="%{country}"/></td>
     <td ><s:property value="%{city}"/>      
      </tr>     
     </s:iterator>    
    </s:if>    
</s:iterator>
 	</table>
 	<s:form action="selectAction" > 
 	<s:submit  class="btn btn-default" key="Come back" align="center" name="submit" action="selectAction"></s:submit>
 	</s:form>
 	
</body>
</html>