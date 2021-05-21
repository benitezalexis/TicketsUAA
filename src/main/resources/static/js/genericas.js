$(document).ready(function() {
	/**
	 * ====================================
	 * 				LOGIN
	 * ====================================
	 * Se valida que se ingrese un usuario 
	 */
	$("#username").focusout(function(){
		var username = document.forms["loginForm"]["username"].value;
		if (username == "") {
			toastr.warning('Ingrese un usuario.');
			return false;
		}else if(username.length < 3){
			toastr.warning('Ingrese un usuario valido con al menos 3 caracteres.');
			return false;
		}
	});

	/**
	 * Validacion de contraseña
	 */
	$("#password").focusout(function(){
		var password = document.forms["loginForm"]["password"].value;
		if (password == "") {
			toastr.warning('Ingrese una contraseña.');
			return false;
		}else if(password.length < 8){
			toastr.warning('Ingrese una con al menos 8 caracteres.');
			return false;
		}
	});
});
