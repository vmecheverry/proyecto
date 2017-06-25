<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<body>
	<h1>JavaBeat - Struts 2 Radio Button Tag Demo</h1>
	<s:form action="RadioDemo">
		<%-- <s:select name="cityName2" list="cities2" listValue="name" label="Partners" />
		<s:submit label="Submit" /> --%>
		
		<%-- <s:radio name="cityName2" list="cities2" listValue="name"/>
		<s:submit label="Submit" /> --%>
		
		<s:radio name="cityName" list="cities"/>
		<s:radio name="cityName2" list="cities2" label="Partners" />
		<s:submit label="Submit" />
	</s:form>
</body>
</html>