<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<table border="0" width="100%" height="100%">
 <!-- Header tile -->
   <tr height="30%">
      <td colspan="2"> <tiles:insertAttribute name="header"/></td>
   </tr>

<!-- Left content and body tiles -->
   <tr height="60%">
      <td width="30%"> <tiles:insertAttribute name="leftContent"/></td>
      <td width="70%"> <tiles:insertAttribute name="body"/></td>
   </tr>
   
    <!--footer tile -->
   <tr height="10%">
      <td colspan="2"> <tiles:insertAttribute name="footer"/></td>
   </tr>
   


</table>


