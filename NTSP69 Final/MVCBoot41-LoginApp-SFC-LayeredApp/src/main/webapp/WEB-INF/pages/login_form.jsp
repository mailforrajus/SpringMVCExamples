<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form  method="POST" modelAttribute="userCmd">
   username :: <form:input path="user"/> <br>
   password :: <form:password path="pwd" /> <br>
  <input type="submit"  value="Login">
</form:form>
