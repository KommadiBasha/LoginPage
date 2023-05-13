<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Details of you</h1>


<%
String name= request.getParameter("name");
String age= request.getParameter("age");
String phone= request.getParameter("phone");

out.print("Your name is : "+ name);
out.print("Your age is : "+ age);
out.print("Your phone is : "+ phone);
%>






</body>
</html>