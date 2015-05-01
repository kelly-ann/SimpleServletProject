<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

<h3>Testing JSPs</h3>

<!-- This is a declaration script tag "<%! %>" used for Java method declaration. -->
<%!
public int add (int a, int b) {
	return a + b;
}
%>

<!-- This is a normal JSP script tag. "<% %>"  It will execute any Java code within it. -->
<%
int i = 1;
int j = 2;
int k;

k = i + j;
%>

<!-- The dynamic expression printing script tag. Ex: "<%=k %>" -->
The value of k is: <%=1 + 2 %>!!

<%
k = add(8888, 1112);
%>

<br/>

Now, the value of k is: <%=k %>.

<% for (i = 0; i < 5; i++) {
%>
	<br/> The new value of i = <%=i %>

 <%} %>

</body>
</html>