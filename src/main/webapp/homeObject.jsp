<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome Page</title>
</head>
<body>
     <h3>acronym: <s:property value="partner.acronym"></s:property> </h3>
 	<h3>name: <s:property value="partner.name"></s:property> </h3>
 	<h3>type: <s:property value="partner.type"></s:property> </h3>
 	<h3>country: <s:property value="partner.country"></s:property> </h3>
 	<h3>city: <s:property value="partner.city"></s:property> </h3>
 	<h3>website: <s:property value="partner.website"></s:property> </h3>
 	
 	
 	
 	<table>
 	<s:iterator value="holaaa" status="listStatus">
  <tr>
    <s:if test="#listStatus.even == true">
      <td style="background: #CCCCCC"><s:property/></td>
    </s:if>
    <s:elseif test="#listStatus.first == true">
      <td><s:property/> (This is first value) </td>
    </s:elseif>
    <s:else>
      <td><s:property/></td>
    </s:else>
  </tr>
</s:iterator>
 	</table>
 	
 	<table>
 	<s:iterator value="partnerList" status="listStatus">
  <tr>
    <s:if test="#listStatus.even == true">
      <td style="background: #CCCCCC"><s:property/></td>
    </s:if>
    <s:elseif test="#listStatus.first == true">
      <td><s:property/> (This is first value) </td>
    </s:elseif>
    <s:else>
      <td><s:property/></td>
    </s:else>
  </tr>
</s:iterator>
 	</table>
 	
 	
</body>
</html>