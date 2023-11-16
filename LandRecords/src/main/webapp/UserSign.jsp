<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Web Page</title>
<style>
    * {
        margin: 0;
        padding: 0;
    }
    body {
        font-family: Arial, sans-serif;
    }
    header {
        background-color: #333;
        color: white;
        padding: 20px;
        text-align: right;
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
    h4{
    color: white;
    }
</style>
</head>
<body>
    <header>
    <div>
        <a class="header-button" href="Index.jsp">Home</a>
    </div>
    </header>

    <div class="RecordButtons">
        <a href="UserRegister.jsp">Sign Up</a>
        <a href="UserLogIn.jsp">Sign In</a>
    </div>

    <footer>
        &copy; shuheb.xworkz@gmail.com
    </footer>
</body>
</html>
