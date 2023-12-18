<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Record</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
        padding: 10px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .adminName {
        color: white;
    }

    .header-home {
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
        width: 100%;
        bottom: 0;
    }
</style>
</head>
<body>

    <header>
        <img alt="image" src="${names.adminImagePath}">
        <h1 class="adminName">${names.adminName}</h1>
        <button class="header-home" href="Index.jsp">Home</button>
    </header>

    <form action="editing" method="post">
        <label for="owner-name">Owner Name:</label>
        <input type="text" class="form-control" id="owner-name" name="ownerName" value="${param.ownerName}" required>

        <label for="mobile-number">Mobile Number:</label>
        <input type="text" class="form-control" id="mobile-number" name="mobileNumber" value="${param.mobileNumber}" required>

        <label for="aadhaar-number">Aadhaar Number:</label>
        <input type="text" class="form-control" id="aadhaar-number" name="aadhaarNumber" value="${param.aadhaarNumber}" required>

        <label for="year">Year:</label>
        <input type="text" class="form-control" id="year" name="year" value="${param.year}" required>

        <label for="hissa-number">Hissa Number:</label>
        <input type="text" class="form-control" id="hissa-number" name="hissaNumber" readonly  value="${param.hissaNumber}">

        <label for="survey-number">Survey Number:</label>
        <input type="text" class="form-control" id="survey-number" name="surveyNumber" readonly  value="${param.surveyNumber}">

        ${edit}
        ${edits}
        <div>
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form>

    <footer>
        &copy;2023 shuheb.xworkz@gmail.com
    </footer>

</body>
</html>
