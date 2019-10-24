 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form:form action="saveExam" commandName="exam" method="post" >
			<h1>New Exam Details Form : <%=request.getParameter("sname") %></h1>
			<table border="1">
				 <form:hidden path="id"/>
				 <form:hidden path="sid"/>
			
            <tr>
                <td>Subject</td>
                <td><form:select path="subname">
                	<form:option value="English">English</form:option>
                	<form:option value="CS">CS</form:option>
                	<form:option value="WC">WC</form:option>
                	<form:option value="Java">Java</form:option>
                	<form:option value="DIP">DIP</form:option>
                	<form:option value="Maths">Maths</form:option>
                </form:select></td>
            </tr>
            <tr>
                <td>Mark</td>
                <td><form:input path="marks" /></td>
            </tr>
           
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
			</table>
		</form:form>
		<h4><a href="all?sid=${exam.sid}&sname=<%=request.getParameter("sname") %>"></h4>
	</div>
		
</body>
</html>