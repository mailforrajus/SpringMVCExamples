<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

    <h1 style="color:red;text-align:center">Faculty Page</h1>
     <h3> Faculties info is avaiable here......</h3> <br>
     
 <a href="../index.jsp">home</a>     <br><br>
 
 <%-- <a href="<c:url value="/perform_logout"/>">logout</a> --%>
 <%-- <a href="<c:url value="/j_spring_security_logout"/>">logout</a> --%>
 <form  action="../performLogout" method="POST">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   <input type="submit"  value="Logout">
</form>

   
   
   