<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">List files</h1>
<c:choose>
   <c:when test="${!empty filesList}">
       <table border="1" align="center">
          <c:forEach var="file" items="${filesList }">
            <tr>
               <td>${file}</td>
               <td><a href="download.htm?fname=${file}">download file</a>
            </tr>
          </c:forEach>
       </table>
   </c:when>
   <c:otherwise>
     <h1>files are not found</h1>
</c:otherwise>
</c:choose>




