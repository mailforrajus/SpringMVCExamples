<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<h1 style="color:red;text-align:center"> <spring:message code="welcome.msg"/> </h1>
   <form action="login.htm" method="post">
      <spring:message code="un.label" /> <input type="text" name="un"><br>
      <spring:message code="pwd.label" /> <input type="text" name="pwd"><br>
      <input type="submit" value="<spring:message code="btn.cap"/>" />
   </form>
<br><br>
  <a href="?lang=en">english</a> &nbsp;&nbsp;
  <a href="?lang=de_DE">german</a> &nbsp;&nbsp;
   <a href="?lang=fr_FR">french</a> &nbsp;&nbsp;
   <a href="?lang=hi_IN">hindi</a> &nbsp;&nbsp;
      
