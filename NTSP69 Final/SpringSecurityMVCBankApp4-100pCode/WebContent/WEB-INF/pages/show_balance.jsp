<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html>

<h1 style="color:red;text-aling:center">Show Balance Page</h1>
Account Balance::<b>${bal} </b>
<br>

<!-- <a href="performLogout">logout</a> <br> -->
<form action="/SpringSecurityMVCBankApp4-100pCode/performLogout" method="post">
  <input type="submit"  value="logout"/>
</form>
<a href="home.htm">home</a>
