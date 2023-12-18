<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Signup Form</title>
    <!-- Link Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body{
            background-color: rgb(105, 162, 167);
        }
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

        /* Additional CSS for form border */
        .form-border {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            margin: 20px;
            align-content: center;
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
    <div class="form-border">
        <form action="userSave" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="userName" name="userName" class="form-control" required>
                
            </div>
            <div class="form-group">
                <label for="email1">Email:</label>
                <input type="email" id="email1" name="email1" class="form-control" required>
                <h4 style = "color:red">${userEmail}</h4>
                 <h4 style = "color:red">${emailCheck}</h4>
            </div>
            <div class="form-group">
                <label for="mobile">Mobile Number:</label>
                <input type="text" id="mobileNumber" name="mobileNumber" pattern="[0-9]{10}" title="Please enter a 10-digit mobile number" class="form-control" required>
                <h4 style = "color:red">${mobileNumber}</h4>
            </div>
            <div class="form-group">
                <label for="adhaar">Aadhaar Number:</label>
                <input type="text" id="aadhaarNumber" name="aadhaarNumber" pattern="[0-9]{12}" title="Please enter a 12-digit Aadhaar number" class="form-control" required>
                <h4 style = "color:red">${aadhaarNumber}</h4>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
                <h4 style = "color:red">${password}</h4>
                <h4 style = "color:red">${pswrd}</h4>
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
                <h4 style = "color:red">${confirmPassword}</h4>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="agree_terms" required>
                <label class="form-check-label" for="agree_terms">I agree to the terms and conditions</label>
            </div>
            <button type="submit" class="btn btn-primary">Sign Up</button>
        </form>
    </div>
</div>

<footer>
    &copy; shuheb.xworkz@gmail.com
</footer>

<!-- Link Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
