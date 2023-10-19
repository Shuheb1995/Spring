<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
       *{
            margin: 0;
            padding: 0;
        }
        body {
            font-family: Arial, sans-serif;
        }
        header {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: right;
         }
         footer {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
            width: 100%;
            bottom: 0;
         }
            
</style>
</head>
<body>
<header>
        <button class="header-home">Home</button>
    </header>
<form action="delete" method="get">
<label for="survey-number">Survey Number:</label>
<input type="text" class="form-control" id="survey-number" name="surveyNumber" required>
<h4>${dlt}</h4>
<h4>${dlt}</h4>
<button type="submit" class="btn btn-danger">Delete</button>
</form>
 <footer>
        &copy;2023 shuheb.xworkz@gmail.com
    </footer>
</body>
</html>