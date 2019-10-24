<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Student</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Student</h1>
        <form:form action="saveStudent" method="post" modelAttribute="student">
        <table>
        <form:hidden path="id"/>
            <tr><tr>
                <td>Roll Num:</td>
                <td><form:input path="rollNum" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><form:radiobutton path="gender" value="male"/>Male
                <form:radiobutton path="gender" value="female"/>Female</td>
            </tr>
            <tr>
            	<td>Country</td>
            	<td><form:select path="country">
            		<form:option value="India">India</form:option>
            		<form:option value="USA">USA</form:option>
            		<form:option value="London">London</form:option>
            	</form:select></td>
            </tr>
            <tr>
   				<td>DateOfJoin</td>
   				<td><form:input type="date" path="doj"/></td>
   			</tr>
   			<tr>
   				<td>FinalScore</td>
   				<td><form:input path="finalscore"/></td>
   			</tr>
   			<tr>
   				<td>Grade </td>
   				<td><form:input path="grade"/></td>
   			</tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>