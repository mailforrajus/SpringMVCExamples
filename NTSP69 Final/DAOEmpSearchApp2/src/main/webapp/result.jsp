<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Result page </h1>

<c:choose>
   <c:when test="${!empty empList }">
    <table>
      <tr><th>EmpNo</th><th>Ename</th><th>Job</th><th>salary</th></tr>
      <c:forEach var="map" items="${empList}">
         <tr>
           <td>${map.EMPNO} </td>
           <td>${map.ENAME} </td>
           <td>${map.JOB} </td>
           <td>${map.SAL} </td>
         </tr>
      </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
      <h1 style="color:red;text-align:center">Data not found </h1>
    </c:otherwise>
</c:choose>










