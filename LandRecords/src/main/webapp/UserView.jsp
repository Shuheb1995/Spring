<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

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
	padding: 10px;
	text-align: right;
}

footer {
	background-color: #333;
	color: white;
	padding: 10px;
	text-align: center;
    position: Absolute; 
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
</style>
</head>
<body>

<header>
		<button class="header-home">Home</button>
	</header>


	<div class="container mt-5">
		<form id="land-records-form" action="viewUser" method="post">
			<div class="row">
				<div class="col-md-2">

					<label for="state">State:</label> <select class="form-control"
						id="state" name="state"
						onchange="populateDistrict(this.id,'district')" required>
						<option value="">Select State</option>
						<option value="karnataka">Karnataka</option>
					</select>
				</div>


				<div class="col-md-2">
					<label for="district">District:</label> <select
						class="form-control" id="district" name="district"
						onchange="populateTaluk(this.id,'taluk')" required></select>
				</div>

				<div class="col-md-2">
					<label for="taluk">Taluk:</label> <select class="form-control"
						id="taluk" name="taluk" onchange="populateHobli(this.id,'hobli')"
						required></select>
				</div>



				<div class="col-md-2">
					<label for="hobli">Hobli:</label> <select class="form-control"
						id="hobli" name="hobli"
						onchange="populateVillage(this.id,'village')" required></select>
				</div>

				<div class="col-md-2">
					<label for="village">Village:</label> <select class="form-control"
						id="village" name="village" required></select>
				</div>

				<div class="col-md-2">
					<button type="submit" class="btn btn-primary">Records</button>
				</div>

			</div>
		</form>
	</div>
	
	<div class="container mt-5">
		<form id="land-records-form" action="userCard" method="post">
			<div class="row">
				
				<div class="col-md-3">
					<label for="surveyNumber">Survey Number:</label> 
					<select class="form-control" id="surveyNumber" name="surveyNumber">
						<option value="">Select Survey Number</option>
	                    <c:forEach var="list" items="${view}">
	                    <option value="${list.surveyNumber}">${list.surveyNumber}</option>
	                    </c:forEach>
					</select>
				</div>

                <div class="col-md-3">
				<label for="hissaNumber">Hissa Number:</label> 
				<select class="form-control" id="hissaNumber" name="hissaNumber">
						<option value="">Select Hissa Number</option>
	                    <c:forEach var="list" items="${view}">
	                    <option value="${list.hissaNumber}">${list.hissaNumber}</option>
	                    </c:forEach>
					</select>
				</div>
				
				<div class="col-md-3">
					<button type="submit" class="btn btn-primary">Records</button>
				</div>
				
			</div>
		</form>
	</div>

	
	<footer> &copy;2023 shuheb.xworkz@gmail.com </footer>
	
	<script type="text/javascript">
		function populateDistrict(state, district) {
			var s1 = document.getElementById(state);
			var s2 = document.getElementById(district);

			s2.innerHTML = ""; // Clear previous options

			var districtArray = [];
			if (s1.value == "karnataka") {
				districtArray = [ '--selectDistrict|--Select District--',
						'Hassan|Hassan', 'Mysore|Mysore', 'Bangalore|Bangalore' ];
			} else if (s1.value == "kerala") {
				districtArray = [ 'selectDistrict|--Select District--',
						'Kasaragod|Kasaragod', 'Wayanad|Wayanad',
						'Cochin|Cochin' ];
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

			s2.innerHTML = ""; // Clear previous options

			var talukArray = [];
			if (s1.value == "Hassan") {
				talukArray = [ '--selectTaluk|--Select Taluk--',
						'Sakaleshpur|Sakaleshpur', 'Holenarsipur|Holenarsipur',
						'Chennarayapattana|Chennarayapattana',
						'Arasikere|Arasikere', 'Alur|Alur', 'Belur|Belur' ];
			} else if (s1.value == "Mysore") {
				talukArray = [ 'selectTaluk|--Select Taluk--',
						'Piriyapatna|Piriyapatna', 'Hunsur|Hunsur',
						'Krishnarajanagara|Krishnarajanagara',
						'Heggadadevanakote|Heggadadevanakote',
						'Nanjangud|Nanjangud', 'Saragur|Saragur',
						'Tirumakudalu Narasipura|Tirumakudalu Narasipura' ];
			} else if (s1.value == "Bangalore") {
				talukArray = [ 'selectTaluk|--Select Taluk--',
						'Hebbala|Hebbala', 'Yelahanka|Yelahanka',
						'Kengeri|Kengeri', 'Krishnarajapura|Krishnarajapura',
						'Anekal|Anekal' ];
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
				hobliArray = [ '--selectHobli|--Select Hobli--',
						'Belagodu|Belagodu', 'Hanubal|Hanubal',
						'Hethur|Hethur', 'Kasaba|Kasaba', 'Yeslur|Yeslur' ];
			} else if (s1.value == "Holenarsipur") {
				hobliArray = [ '--selectHobli|--Select Hobli--',
						'Halekote|HaleKote', 'HalliMysore|HalliMysore',
						'Kasaba|Kasaba' ];
			} else if (s1.value == "Chennarayapattana") {
				hobliArray = [ '--selectHobli|--Select Hobli--', 'Bagur|Bagur',
						'Dandiganahalli|Dandiganahalli', 'Hirisave|Hirisave',
						'Kasaba|Kasaba', 'Nuggehalli|Nuggehalli',
						'Shravanabelagola|Shravanabelagola' ];
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
				villageArray = [ '--selectVillage|--Select Village--',
						'Achangi|Achangi', 'Balagaddhe|Balagaddhe',
						'Baage|Baage', 'Balupete|Balupete',
						'Kadagaravalli|Kadagaravalli' ];
			} else if (s1.value == "Hanubal") {
				villageArray = [ '--selectVillage|--Select Village--',
						'Anemahal|Anemahal', 'Arekere|Arekere',
						'Bachanahalli|Bachanahalli', 'Baikere|Baikere' ];
			} else if (s1.value == "Hethur") {
				villageArray = [ '--selectVillage|--Select Village--',
						'Goddhu|Goddhu', 'Acharadi|Acharadi',
						'Basavanahalli|Basavanahalli', 'BandiHalli|BandiHalli',
						'Chikkanayakanahalli|Chikkanayakanahalli',
						'Hosakote|Hosakote' ];
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