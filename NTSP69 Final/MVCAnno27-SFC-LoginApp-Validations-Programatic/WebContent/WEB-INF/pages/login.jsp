<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Login Page</h1>

<form:form method="POST" modelAttribute="userCmd"  onsubmit="return validate(this)">
   <p style="color:red">
   <form:errors path="*">
   </form:errors>
    </p>
    <br>
      Enter username :: <form:input path="username"/><span id="nameErr"></span> <br>
      Enter Password ::<form:input path="password"/><span id="passErr"> </span><br>
      <form:hidden path="vflag" value="no"/>
      <input type="submit"  value="Login">
</form:form>
<br>
 <c:if test="${!empty resMsg}">
    <b>   ${resMsg} </b>
 </c:if>
 
 <script language="JavaScript">
   function  validate(frm){
      //empty the messages
      document.getElementById("nameErr").innerHTML="";
      document.getElementById("passErr").innerHTML="";
      //set  vflag to true indicating client form validations are perfomed
      frm.vflag.value="yes";
      if(frm.username.value==""){
        document.getElementById("nameErr").innerHTML="username is required";
         frm.username.focus();
         return false;
      }
      
       if(frm.password.value==""){
          document.getElementById("passErr").innerHTML="password is required";
         frm.password.focus();
         return false;
      }
     return true;
   }
 
 </script>

