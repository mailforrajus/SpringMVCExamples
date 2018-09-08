<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Login Page</h1>

<form:form method="POST" modelAttribute="userCmd">
  <p style="color:red">
     <form:errors path="*"/>
     </p> <br>
      Enter username :: <form:input path="username"/> <br>
      Enter Password ::<form:input path="password"/> <br>
      Countries :: <form:select path="countries">
                                <form:options items="${countriesList}"/>
                            </form:select> <br>
      Hobies ::   <form:checkboxes items="${hobiesList }" path="hobies"/> <br>
      Date of registration :: <form:input path="dor"/> (dd-MM-yyyy)<br> 
      <input type="submit"  value="Login">
</form:form>
<br>
      
<br>
 <c:if test="${!empty resMsg}">
    <b>   ${resMsg} </b>
 </c:if>
 <br><br>
<c:if test="${!empty userCmd}">
    <b>   ${userCmd} </b>
 </c:if>