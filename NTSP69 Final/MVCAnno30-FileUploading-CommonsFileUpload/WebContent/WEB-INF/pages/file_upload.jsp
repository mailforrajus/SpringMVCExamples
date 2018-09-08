<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">File Uploading  Page</h1>

<form:form method="POST" modelAttribute="uplCmd" enctype="multipart/form-data">
      Select file1:: <input type="file" name="file1"><br>
       Select file2:: <input type="file" name="file2"><br>
      <input type="submit"  value="Upload File">
</form:form>

