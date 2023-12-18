<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin LogIn</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<style>
        body {
            background-color: rgb(105, 162, 167);
            font-family: Arial, sans-serif;
        }
        header {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: right;
        }
        .header-home{
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
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
        .container {
        padding-top: 130px;
        }
        h6{
        color: red;
        }
    </style>

</head>
<body>

 <header>
        <button class="header-home" href="Index.jsp">Home</button>
    </header>
    
    <div class="container">
  <div class="row justify-content-center">
    <div class="col-lg-6">
    
  

<form action="getOtp" method="get">  
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input type="email" class="form-control" name="email" id="emailform" aria-describedby="emailHelp" value="<%=(request.getParameter("email") !=null) ? request.getParameter("email"):"" %>"  required>
        <h6>${emailNotValidated}</h6>
        <h6>${AccountNotExist}</h6>
        <button type="submit" class="btn btn-primary">Get OTP</button>
      </form>
      <form action="checkOtp" method="post">
      <input type="hidden" name="email" value="${mail}">
        <label for="exampleInputPassword1" class="form-label">OTP</label>
        <input type="text" name="otp" class="form-control" id="otpform">
       
        <h6>${otpWrong}</h6>
        
        <button type="submit" class="btn btn-primary">Submit</button>
        <input type="hidden" name="email" value="<%=(request.getParameter("email") !=null) ? request.getParameter("email"):"" %>">
      </form>
      
      </div>
  </div>
</div>


<footer>
        &copy; shuheb.xworkz@gmail.com
    </footer>




</body>
</html>