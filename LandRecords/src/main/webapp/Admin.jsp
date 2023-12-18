<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<style>
    * {
        margin: 0;
        padding: 0;
    }
    body {
        background-color: rgb(105, 162, 167);
        font-family: Arial, sans-serif;
    }
    header {
        background-color: #333;
        color: white;
        padding: 15px;
        text-align: center; /* Center align the content in the header */
    }
    .header-content {
        display: flex;
        justify-content: space-between; /* Arrange items parallelly */
        align-items: center;
    }
    .header-button {
        padding: 10px;
        background-color: #007BFF;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    .RecordButtons {
        text-align: center;
        padding-top: 200px;
    }
    .RecordButtons button, a {
        margin: 10px;
        padding: 10px;
        background-color: #007BFF;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: small;       
    }
    footer {
        background-color: #333;
        color: white;
        padding: 10px;
        text-align: center;
        position: fixed;
        width: 100%;
        bottom: 0;
    }
    
    h4{
        color: white;
    }
    
</style>
</head>
<body>
    <header>
        <div class="header-content">
            <img alt="image" src="${names.adminImagePath}">
            <h1 class="adminName" style="color:white">${names.adminName}</h1>
            <a class="header-button" href="Home.jsp">Logout</a>
        </div>
    </header>
    
   

    <div class="RecordButtons">
        <a href="Add.jsp">Add Records</a>
        <a href="Read.jsp">View Records</a>
    </div>

    <footer>
        &copy; shuheb.xworkz@gmail.com
    </footer>
</body>
</html>
