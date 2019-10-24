
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align = center>
   <h1>Exam List for the Student : <%=request.getParameter("sname")%></h1>
		
		<table border="1">

			<tr>
			<th>Subject Name</th>
			<th>Marks</th>
			<th>Action</th>
			</tr>
			<c:set var="sid" value="0"/>
			<c:forEach var="exam" items="${listExam}">
			<c:set var="sid" value="${exam.sid}"/>
				<tr>

					<td>${exam.subname}</td>
					<td>${exam.marks}</td>
					<td><a href="editExam?id=${exam.id}&sname=<%=request.getParameter("sname")%>">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="deleteExam?id=${exam.id}&sid=${exam.sid}">Delete</a></td>

				</tr>
			</c:forEach>
		</table><br>
	
	<a href="newExam?sid=<%=request.getParameter("sid")%>&sname=<%=request.getParameter("sname")%>" >Add Exam Results</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="/SpringMVCHibernateCRUD/">Go To Home Page</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	</div>	
</body>
</html>