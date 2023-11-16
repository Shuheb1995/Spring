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
        h4{
        color: red;
        }
        
    </style>
    
    
</head>
<body>
<header>
        <h4 style = "color:red">${Adminee.adminName}</h4>
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
             <h4>${exist}</h4>
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
                districtArray = ['--selectDistrict|--Select District--', 'Hassan|Hassan', 'Mysore|Mysore', 'Chikkamagaluru|Chikkamagaluru','Shivamogga|Shivamogga','Tumkur|Tumkur'];
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
                talukArray = ['--selectTaluk|--Select Taluk--', 'Sakaleshpur|Sakaleshpur', 'Holenarsipur|Holenarsipur', 'Chennarayapattana|Chennarayapattana', 'Arasikere|Arasikere'];
            } else if (s1.value == "Mysore") {
                talukArray = ['selectTaluk|--Select Taluk--', 'Piriyapatna|Piriyapatna', 'Hunsur|Hunsur', 'Krishnarajanagara|Krishnarajanagara', 'Nanjangud|Nanjangud'];
            } else if (s1.value == "Chikkamagaluru") {
                talukArray = ['selectTaluk|--Select Taluk--', 'Kadur|Kadur', 'Koppa|Koppa', 'Mudigere|Mudigere', 'Tarikere|Tarikere'];
            }else if (s1.value == "Shivamogga") {
                talukArray = ['selectTaluk|--Select Taluk--', 'Bhadravathi|Bhadravathi', 'Tirthahalli|Tirthahalli', 'Sagara|Sagara', 'Shikaripura|Shikaripura'];
            }else if (s1.value == "Tumkur") {
                talukArray = ['selectTaluk|--Select Taluk--', 'Turuvakere|Turuvakere', 'Kunigal|Kunigal', 'Tiptur|Tiptur', 'Madhugiri|Madhugiri'];
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
                hobliArray = ['--selectHobli|--Select Hobli--', 'Belagodu|Belagodu', 'Hanubal|Hanubal'];
            } else if (s1.value == "Holenarsipur") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Halekote|HaleKote', 'HalliMysore|HalliMysore',];
            } else if (s1.value == "Chennarayapattana") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Hirisave|Hirisave', 'Shravanabelagola|Shravanabelagola'];
            }else if (s1.value == "Arasikere") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Banavara|Banavara','Javagal|Javagal'];
            }else if (s1.value == "Piriyapatna") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Bettadapura|Bettadapura','Haranahalli|Haranahalli'];
            }else if (s1.value == "Hunsur") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Bilikere|Bilikere','Hanagodu|Hanagodu'];
            }else if (s1.value == "Krishnarajanagara") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Hebbalu|Hebbalu','Hosagrahara|Hosagrahara'];
            }else if (s1.value == "Nanjangud") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Biligere|Biligere','Hullahalli|Hullahalli'];
            }else if (s1.value == "Kadur") {
                hobliArray = ['--selectHobli|--Select Hobli--','Beeruru|Beeruru', 'Yagati|Yagati'];
            }else if (s1.value == "Koppa") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Hariharapura|Hariharapura','Megunda|Megunda'];
            }else if (s1.value == "Mudigere") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Baluru|Baluru','Banakal|Banakal'];
            }else if (s1.value == "Tarikere") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Lakkavalli|Lakkavalli','Lingadahalli|Lingadahalli'];
            }else if (s1.value == "Bhadravathi") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Holehonnuru AI|Holehonnuru AI','Kudligere|Kudligere'];
            }else if (s1.value == "Tirthahalli") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Agrahara|Agrahara','Agumbe|Agumbe'];
            }else if (s1.value == "Sagara") {
                hobliArray = ['--selectHobli|--Select Hobli--', 'Anandapura|Anandapura','Talaguppa|Talaguppa'];
            }else if (s1.value == "Shikaripura") {
                hobliArray = ['--selectHobli|--Select Hobli--', '1|1','2|2'];
            }else if (s1.value == "Turuvakere") {
                hobliArray = ['--selectHobli|--Select Hobli--', '1|1','2|2'];
            }else if (s1.value == "Kunigal") {
                hobliArray = ['--selectHobli|--Select Hobli--', '1|1','2|2'];
            }else if (s1.value == "Tiptur") {
                hobliArray = ['--selectHobli|--Select Hobli--', '1|1','2|2'];
            }else if (s1.value == "Madhugiri") {
                hobliArray = ['--selectHobli|--Select Hobli--', '1|1','2|2'];
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
                villageArray = ['--selectVillage|--Select Village--', 'Adaravalli|Adaravalli', 'Balagodu|Balagodu', 'Bhage|Bhage', 'Halekere|Halekere'];
            } else if (s1.value == "Hanubal") {
                villageArray = ['--selectVillage|--Select Village--', 'Agani|Agani', 'Bachanahalli|Bachanahalli', 'Dabbegadde|Dabbegadde' , 'Heggadde|Heggadde'];
            } else if (s1.value == "Halekote") {
                villageArray = ['--selectVillage|--Select Village--', 'Ankanahalli|Ankanahalli', 'Banukuppe|Banukuppe', 'Chandapura|Chandapura', 'Hosahalli|Hosahalli'];
            }else if (s1.value == "HalliMysore") {
                villageArray = ['--selectVillage|--Select Village--', 'Arehalli|Arehalli', 'Bachanahalli|Bachanahalli', 'Cholenahalli|Cholenahalli', 'Kodihalli|Kodihalli'];
            }else if (s1.value == "Hirisave") {
                villageArray = ['--selectVillage|--Select Village--', 'Arakere|Arakere', 'Buka|Buka', 'Channahalli|Channahalli', 'Dasarahalli|Dasarahalli'];
            }else if (s1.value == "Shravanabelagola") {
                villageArray = ['--selectVillage|--Select Village--', 'Aladahalli|Aladahalli', 'Basavanahalli|Basavanahalli', 'Chikkabilati|Chikkabilati', 'Gullenahalli|Gullenahalli'];
            }else if (s1.value == "Banavara") {
                villageArray = ['--selectVillage|--Select Village--', 'Agrahara|Agrahara', 'Bairambudi|Bairambudi', 'Chikkabanavara|Chikkabanavara', 'Ganjigere|Ganjigere'];
            }else if (s1.value == "Javagal") {
                villageArray = ['--selectVillage|--Select Village--', 'Attiguddakaval|Attiguddakaval', 'Beluvalli|Beluvalli', 'Deshani|Deshani', 'Devihalli|Devihalli'];
            }else if (s1.value == "Bettadapura") {
                villageArray = ['--selectVillage|--Select Village--', 'Attiguda|Attiguda', 'Bekkare|Bekkare', 'Billahalli|Billahalli', 'Depura|Depura'];
            }else if (s1.value == "Haranahalli") {
                villageArray = ['--selectVillage|--Select Village--', 'Adaguru|Adaguru', 'Avarti|Avarti', 'Bailakuppe|Bailakuppe', 'Dindugadu|Dindugadu'];
            }else if (s1.value == "Bilikere") {
                villageArray = ['--selectVillage|--Select Village--', 'Ankanahalli|Ankanahalli', 'Bettaduru|Bettaduru', 'Challahalli|Challahalli', 'Devagalli|Devagalli'];
            }else if (s1.value == "Hanagodu") {
                villageArray = ['--selectVillage|--Select Village--', 'Abburu|Abburu', 'Beeranahalli|Beeranahalli', 'Chennasoge|Chennasoge', 'Dasanapura|Dasanapura'];
            }else if (s1.value == "Hebbalu") {
                villageArray = ['--selectVillage|--Select Village--', 'Adaganahalli|Adaganahalli', 'Bhuvanahalli|Bhuvanahalli', 'Bydarahalli|Bydarahalli', 'Katnalu|Katnalu'];
            }else if (s1.value == "Hosagrahara") {
                villageArray = ['--selectVillage|--Select Village--', 'Arjunahalli|Arjunahalli', 'Beeranahalli|Beeranahalli', 'Changa|Changa', 'Hampapura|Hampapura'];
            }else if (s1.value == "Biligere") {
                villageArray = ['--selectVillage|--Select Village--', 'Alamburu|Alamburu', 'Bilugali|Bilugali', 'Gonahalli|Gonahalli', 'Kahalli|Kahalli'];
            }else if (s1.value == "Hullahalli") {
                villageArray = ['--selectVillage|--Select Village--', 'Akala|Akala', 'Belale|Belale', 'Chennapattana|Chennapattana', 'Hadya|Hadya'];
            }else if (s1.value == "Beeruru") {
                villageArray = ['--selectVillage|--Select Village--', 'Bagaytu|Bagaytu', 'Chikkangala|Chikkangala', 'Galeehalli|Galeehalli', 'Hullehalli|Hullehalli'];
            }else if (s1.value == "Yagati") {
                villageArray = ['--selectVillage|--Select Village--', 'Anneegere|Anneegere', 'Bhukanagonndi|Bhukanagonndi', 'Chatnahalli|Chatnahalli', 'Garje|Garje'];
            }else if (s1.value == "Hariharapura") {
                villageArray = ['--selectVillage|--Select Village--', 'Asagodu|Asagodu', 'Bilagadde|Bilagadde', 'Heggaru|Heggaru', 'Hosuru|Hosuru'];
            }else if (s1.value == "Megunda") {
                villageArray = ['--selectVillage|--Select Village--', 'Adigebailu|Adigebailu', 'Attikodige|Attikodige', 'Guddetota|Guddetota', 'Heruru|Heruru'];
            }else if (s1.value == "Baluru") {
                villageArray = ['--selectVillage|--Select Village--', 'Balige|Balige', 'Hadioni|Hadioni', 'Javali|Javali', 'Kuve|Kuve'];
            }else if (s1.value == "Banakal") {
                villageArray = ['--selectVillage|--Select Village--', 'Attigere|Attigere', 'Bakki|Bakki', 'Falguni|Falguni', 'Gutti|Gutti'];
            }else if (s1.value == "Lakkavalli") {
                villageArray = ['--selectVillage|--Select Village--', 'Bhavikere|Bhavikere', 'Gopala|Gopala', 'Halasuru|Halasuru', 'Sompura|Sompura'];
            }else if (s1.value == "Lingadahalli") {
                villageArray = ['--selectVillage|--Select Village--', 'Ballavara|Ballavara', 'Gonguru|Gonguru', 'Kallalu|Kallalu', 'Nandi|Nandi'];
            }else if (s1.value == "Holehonnuru AI") {
                villageArray = ['--selectVillage|--Select Village--', 'Agasanahalli|Agasanahalli', 'Aradotlu|Aradotlu', 'Koppa|Koppa', 'Sidleepura|Sidleepura'];
            }else if (s1.value == "Kudligere") {
                villageArray = ['--selectVillage|--Select Village--', 'Aralihalli|Aralihalli', 'Balekatte|Balekatte', 'Dodderi|Dodderi', 'Ganguru|Ganguru'];
            }else if (s1.value == "Agrahara") {
                villageArray = ['--selectVillage|--Select Village--', 'Agasadi|Agasadi', 'Bandya|Bandya', 'Beede|Beede', 'Hadigallu|Hadigallu'];
            }else if (s1.value == "Agumbe") {
                villageArray = ['--selectVillage|--Select Village--', 'Balehalli|Balehalli', 'Changara|Changara', 'Huruli|Huruli', 'Kunda|Kunda'];
            }else if (s1.value == "Anandapura") {
                villageArray = ['--selectVillage|--Select Village--', 'Achapura|Achapura', 'Aduru|Aduru', 'Bilagodi|Bilagodi', 'Chipli|Chipli'];
            }else if (s1.value == "Talaguppa") {
                villageArray = ['--selectVillage|--Select Village--', 'Arehada|Arehada', 'Bellenne|Bellenne', 'Kanase|Kanase', 'Kelavi|Kelavi'];
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
