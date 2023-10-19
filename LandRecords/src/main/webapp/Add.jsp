<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Land Records</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
        .container {
            max-width: 600px; /* Adjust max-width as needed */
            margin: 0 auto;
            padding: 20px;
        }
        footer {
            background-color: #333;
            color: white;
            padding: 10px;
            text-align: center;
           
            width: 100%;
            bottom: 0;
        }
        .header-home {
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        h6{
        color: red;
        }
        
    </style>
    
    
</head>
<body>
<header>
        <button class="header-home">Home</button>
    </header>

    <div class="container mt-5">
        <form id="land-records-form" action="saving" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="state">State:</label>
                        <select class="form-control" id="state" name="state" onchange="populateDistrict(this.id,'district')" required>
                            <option value="">Select State</option>
                            <option value="karnataka">Karnataka</option>
                            <option value="kerala">Kerala</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="district">District:</label>
                        <select class="form-control" id="district" name="district" onchange="populateTaluk(this.id,'taluk')" required></select>
                    </div>

                    <div class="form-group">
                        <label for="taluk">Taluk:</label>
                        <select class="form-control" id="taluk" name="taluk" onchange="populateHobli(this.id,'hobli')" required></select>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="hobli">Hobli:</label>
                        <select class="form-control" id="hobli" name="hobli" onchange="populateVillage(this.id,'village')" required></select>
                    </div>

                    <div class="form-group">
                        <label for="village">Village:</label>
                        <select class="form-control" id="village" name="village" required></select>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="owner-name">Owner Name:</label>
                        <input type="text" class="form-control" id="owner-name" name="ownerName" value="<%=(request.getParameter("ownerName") !=null) ? request.getParameter("ownerName"):"" %>" required>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="mobile-number">Mobile Number:</label>
                        <input type="tel" class="form-control" id="mobile-number" name="mobileNumber" value="<%=(request.getParameter("mobileNumber") !=null) ? request.getParameter("mobileNumber"):"" %>"  required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="aadhaar-number">Aadhaar Number:</label>
                        <input type="text" class="form-control" id="aadhaar-number" name="aadhaarNumber" value="<%=(request.getParameter("aadhaarNumber") !=null) ? request.getParameter("aadhaarNumber"):"" %>" required>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="survey-number">Survey Number:</label>
                        <input type="text" class="form-control" id="survey-number" name="surveyNumber" value="<%=(request.getParameter("surveyNumber") !=null) ? request.getParameter("surveyNumber"):"" %>" required>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="hissa-number">Hissa Number:</label>
                        <input type="text" class="form-control" id="hissa-number" name="hissaNumber"  value="<%=(request.getParameter("hissaNumber") !=null) ? request.getParameter("hissaNumber"):"" %>" required>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="year">Year:</label>
                        <input type="text" class="form-control" id="year" name="year" value="<%=(request.getParameter("year") !=null) ? request.getParameter("year"):"" %>" required>
                    </div>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <footer>
        &copy;2023 shuheb.xworkz@gmail.com
    </footer>

    
    
    
    <script type="text/javascript">
        function populateDistrict(state, district) {
            var s1 = document.getElementById(state);
            var s2 = document.getElementById(district);
    
            s2.innerHTML = "";  // Clear previous options
    
            var districtArray = [];
            if (s1.value == "karnataka") {
                districtArray = ['--selectDistrict|--Select District--', 'Hassan|Hassan', 'Mysore|Mysore', 'Bangalore|Bangalore'];
            } else if (s1.value == "kerala") {
                districtArray = ['selectDistrict|--Select District--', 'Kasaragod|Kasaragod', 'Wayanad|Wayanad', 'Cochin|Cochin'];
            }
    
            for (var i = 0; i < districtArray.length; i++) {
                var option = districtArray[i].split("|");
                var newOption = document.createElement("option");
                newOption.value = option[0];
                newOption.text = option[1];
                s2.appendChild(newOption);
            }
        }
    
        function populateTaluk(district, taluk) {
            var s1 = document.getElementById(district);
            var s2 = document.getElementById(taluk);
    
            s2.innerHTML = "";  // Clear previous options
    
            var talukArray = [];
            if (s1.value == "Hassan") {
                talukArray = ['--selectTaluk|--Select Taluk--', 'Sakaleshpur|Sakaleshpur', 'Holenarsipur|Holenarsipur', 'Chennarayapattana|Chennarayapattana', 'Arasikere|Arasikere', 'Alur|Alur', 'Belur|Belur'];
            } else if (s1.value == "Mysore") {
                talukArray = ['selectTaluk|--Select Taluk--', 'Piriyapatna|Piriyapatna', 'Hunsur|Hunsur', 'Krishnarajanagara|Krishnarajanagara', 'Heggadadevanakote|Heggadadevanakote', 'Nanjangud|Nanjangud', 'Saragur|Saragur', 'Tirumakudalu Narasipura|Tirumakudalu Narasipura'];
            } else if (s1.value == "Bangalore") {
                talukArray = ['selectTaluk|--Select Taluk--', 'Hebbala|Hebbala', 'Yelahanka|Yelahanka', 'Kengeri|Kengeri', 'Krishnarajapura|Krishnarajapura', 'Anekal|Anekal'];
            }
    
            for (var i = 0; i < talukArray.length; i++) {
                var option = talukArray[i].split("|");
                var newOption = document.createElement("option");
                newOption.value = option[0];
                newOption.text = option[1];
                s2.appendChild(newOption);
            }
        }
        function populateHobli(taluk, hobli) {
            var s1 = document.getElementById(taluk);
            var s2 = document.getElementById(hobli);
    
            s2.innerHTML = "";
    
            var hobliArray = [];
            if (s1.value == "Sakaleshpur") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Belagodu|Belagodu', 'Hanubal|Hanubal', 'Hethur|Hethur', 'Kasaba|Kasaba', 'Yeslur|Yeslur'];
            } else if (s1.value == "Holenarsipur") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Halekote|HaleKote', 'HalliMysore|HalliMysore', 'Kasaba|Kasaba'];
            } else if (s1.value == "Chennarayapattana") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Bagur|Bagur', 'Dandiganahalli|Dandiganahalli', 'Hirisave|Hirisave', 'Kasaba|Kasaba', 'Nuggehalli|Nuggehalli' , 'Shravanabelagola|Shravanabelagola'];
            }
    
            for (var i = 0; i < hobliArray.length; i++) {
                var option = hobliArray[i].split("|");
                var newOption = document.createElement("option");
                newOption.value = option[0];
                newOption.text = option[1];
                s2.appendChild(newOption);
            }
        }
        function populateVillage(hobli, village) {
            var s1 = document.getElementById(hobli);
            var s2 = document.getElementById(village);
    
            s2.innerHTML = "";
    
            var villageArray = [];
            if (s1.value == "Belagodu") {
                villageArray = ['--selectVillage|--Select Village--', 'Achangi|Achangi', 'Balagaddhe|Balagaddhe', 'Baage|Baage', 'Balupete|Balupete', 'Kadagaravalli|Kadagaravalli'];
            } else if (s1.value == "Hanubal") {
                villageArray = ['--selectVillage|--Select Village--', 'Anemahal|Anemahal', 'Arekere|Arekere', 'Bachanahalli|Bachanahalli' , 'Baikere|Baikere'];
            } else if (s1.value == "Hethur") {
                villageArray = ['--selectVillage|--Select Village--', 'Goddhu|Goddhu', 'Acharadi|Acharadi', 'Basavanahalli|Basavanahalli', 'BandiHalli|BandiHalli', 'Chikkanayakanahalli|Chikkanayakanahalli' , 'Hosakote|Hosakote'];
            }
    
            for (var i = 0; i < villageArray.length; i++) {
                var option = villageArray[i].split("|");
                var newOption = document.createElement("option");
                newOption.value = option[0];
                newOption.text = option[1];
                s2.appendChild(newOption);
            }
        }

    </script>
    
    
</body>
</html>
