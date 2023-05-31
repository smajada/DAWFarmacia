// function enviarPOST() {
// 	var http = new XMLHttpRequest();

// 	let email = document.getElementById('mail').value;
// 	let pass = document.getElementById('pass').value;

// 	http.open("POST", "http://localhost:3000/Tomcat/Login", true);
// 	http.setRequestHeader("Content-type", "application-x-www-form-urlencoded");
// 	http.send("mail="+email+"&pass="+pass);

// 	http.onreadystatechange = function () {
// 		if (this.readyState == 4 && this.status == 200) {
// 			if (http.responseText == "ok") {
// 				document.getElementById("resultat").innerHTML = "Estás logeado."
// 			}
// 		}
// 	}
// }

function enviar() {
	var http = new XMLHttpRequest();

	let mail = document.getElementById('mail').value;
	let pass = document.getElementById('pass').value;

	http.open("GET", "http://localhost:3000/DAWFarmacia/Login?mail="+mail+"&pass="+pass, true);
	http.send();

	http.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {

			let session = this.responseText;
			if (session != "0") {
				window.sessionStorage.setItem("mail", mail);
				window.sessionStorage.setItem("session", session);
				window.location.replace("Gestio.html");
			}
		} else {
			document.getElementById("resultat").innerHTML = "Login incorrecte."
		}
	}
}
