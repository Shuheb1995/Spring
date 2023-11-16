<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Form</title>
    <!-- Link Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        header {
            background-color: #333;
            color: white;
            padding: 15px;
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
        /* Added styles for the form */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }
        form {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            width: 50%;
        }

    </style>
</head>
<body>

<header>
    <div>
        <a class="header-button" href="Index.jsp">Home</a>
    </div>
</header>

<div class="container">
    <form action="updatingPassword" method="post">
        <div class="form-group">
            <label for="email1">Email:</label>
            <input type="email1" id="email1" name="email1" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" class="form-control" required>
            <h4 style = "color:red">${psrd}</h4>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
            <h4 style = "color:red">${cpsrd}</h4>
        </div>
        <h4 style = "color:red">${psrdUpdate}</h4>
        <h4 style = "color:red">${updateFailed}</h4>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<footer>
    &copy; shuheb.xworkz@gmail.com
</footer>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
