<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Sign In</title>
</head>
<body>
<form action="addAdmin" method = "post" enctype="multipart/form-data">
<input type="text" name="adminName" placeholder="Name">
<input type="email" name="email" placeholder="Email">
<input type="text" name="otp" placeholder="otp">
<input type="file" name="file" />
<button type="submit" value="Submit">Save</button>
</form>
</body>
</html>