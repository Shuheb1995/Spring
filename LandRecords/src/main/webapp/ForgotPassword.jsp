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
        button.btn-primary {
            width: 100%;
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
    <form action="forgot" method="post">
        <div class="form-group">
            <label for="email1">Email:</label>
            <input type="email1" id="email1" name="email1" class="form-control" required>
            <h4 style = "color:red">${emailfound}</h4>
        </div>
        <button type="submit" class="btn btn-primary">Send OTP</button>
        </form>
        
         <form action="otpValidate" method="post">
        <div class="form-group">
            <label for="password">OTP:</label>
            <input type="text" id="otp" name="otp" class="form-control" required>
            <h4 style = "color:red">${otpValidate}</h4>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<footer>
    &copy; shuheb.xworkz@gmail.com
</footer>

<!-- Link Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
