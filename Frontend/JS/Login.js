

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

const eyeIcons = document.querySelectorAll(".show-hide");

eyeIcons.forEach((eyeIcon) => {
	eyeIcon.addEventListener("click", () => {
		const pInput = eyeIcon.parentElement.querySelector("input");

		if (pInput.type === "password") {
			eyeIcon.classList.replace("bx-hide", "bx-show");
			pInput.type = "text";
		} else {
			eyeIcon.classList.replace("bx-show", "bx-hide");
			pInput.type = "password";
		}
	});
});


