<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
<font color="red">${error }</font>
	<form:form method="post" modelAttribute="student">
			<fieldset class="form-group">
				<form:label path="id">ID</form:label>
				<form:input type="text" path="id" class="form-control" onfocus="this.select();" onmouseup="return false;" placeholer="Student ID" autofocus="autofocus"/>
				
			</fieldset>
			<fieldset class="form-group">
				<form:label path="name">Name</form:label>
				<form:input type="text" path="name" class="form-control" onfocus="this.select();" onmouseup="return false;" placeholer="Student Name"/>
				
			</fieldset>
			<fieldset class="form-group">
				<form:label path="marks">Marks</form:label>
				<form:input type="text" path="marks" class="form-control" onfocus="this.select();" onmouseup="return false;" placeholer="Student Marks"/>
			</fieldset>
			<fieldset class="form-group">
			<input class="btn btn-success" type="submit" value="Save">
			<input class="btn btn-danger" type="reset" value="Reset">
			
			</fieldset>
	</form:form>
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</div>
</body>
</html>