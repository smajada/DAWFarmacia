function logOut() {
	sessionStorage.removeItem("email");
	sessionStorage.removeItem("session");

	window.location.replace("Login.html");
}

function getTable() {
	var http = new XMLHttpRequest();

	let mail = sessionStorage.getItem("mail");
	let session = sessionStorage.getItem("session")

	http.open(
		"GET",
		"http://localhost:3000/DAWFarmacia/ServeXips?mail="+mail+"&session="+session,
		true
	);
	http.send();

	http.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
      document.getElementById("table").innerHTML = http.responseText;

		} else {

			document.getElementById("table").innerHTML = "<p>Error while loading.</p>";
		}
	};
}

function goAlta(){
  window.location.href = "Alta.html";
}

function showName() {
  var nameField = document.getElementById("name");
  var mail = sessionStorage.getItem("mail");
  nameField.innerHTML = `<h1>${mail}</h1>`;
}