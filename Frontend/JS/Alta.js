function getPatients() {
	var http = new XMLHttpRequest();

	let mail = sessionStorage.getItem("mail");
	let session = sessionStorage.getItem("session");

	http.open(
		"GET",
		"http://localhost:3000/DAWFarmacia/ServePatients?mail=" +
			mail +
			"&session=" +
			session,
		true
	);

	http.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			var data = JSON.parse(http.responseText);

			var patientList = document.getElementById("patient-list");

			for (let i = 0; i < data.length; i++) {
				const element = data[i];
				var option = document.createElement("option");
				option.value = element;
				option.text = element;

				patientList.add(option);
			}
		}
	};

	http.send();
}

function getMedicines() {
	var http = new XMLHttpRequest();

	let mail = sessionStorage.getItem("mail");
	let session = sessionStorage.getItem("session");

	http.open(
		"GET",
		"http://localhost:3000/DAWFarmacia/ServMedicines?mail=" +
			mail +
			"&session=" +
			session,
		true
	);

	http.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			var data = JSON.parse(http.responseText);

			var medicineSelect = document.getElementById("medicine-list");

			for (let i = 0; i < data.length; i++) {
				const medicine = data[i];
				var option = document.createElement("option");
				option.value = medicine.name;
				option.text = medicine.name;
				medicineSelect.add(option);
			}
		}
	};

	http.send();
}

function enviar() {
  var http = new XMLHttpRequest();

  let mail = sessionStorage.getItem("mail");
  let session = sessionStorage.getItem("session");
	
  var idXip = document.getElementById("xipId").value;
  var mailP = document.getElementById("patient-list").value;
  var idMed = document.getElementById("medicine-list").value;
  var date = document.getElementById("expiry-date").value;

  http.open("POST", "http://localhost:3000/DAWFarmacia/Release", true);
  http.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

  http.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var response = http.responseText;
      document.getElementById("estat").innerHTML = response;
    }
  };

  http.send(
    "mail=" +
    encodeURIComponent(mail) +
    "&session=" +
    encodeURIComponent(session) +
    "&idXip=" +
    encodeURIComponent(idXip) +
    "&mailP=" +
    encodeURIComponent(mailP) +
    "&idMed=" +
    encodeURIComponent(idMed) +
    "&date=" +
    encodeURIComponent(date)
  );
}


function goGestion() {
	window.location.href = "Gestio.html";
}

window.addEventListener("load", () => {
	getPatients();
	getMedicines();
});
