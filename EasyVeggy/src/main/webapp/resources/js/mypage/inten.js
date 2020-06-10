function vganExplain() {
	var table = document.querySelector('#vganTable');

	if (table.style.display != "table") {
		table.style.display = "table";
	} else {
		table.style.display = "none";
	}
}

function setVegan() {
	var form = document.querySelector('form');

	if (form.style.display != "block") {
		form.style.display = "block";
	} else {
		form.style.display = "none";
	}
}