function respuesta (response)
{
	var objetoJson = response;
	if (!objetoJson.ok) //si hay fallos
		{
			var myNewElement = $("<p>").html (objetoJson.mensaje);
			myNewElement.insertAfter($("#boton_ir"));
		}
	else 
		{
			$("p").remove();
		}
}

function enviarLogin (user, pass)
{
	
	var datos_usuario = {
		    nombre:user,
		    pwd:pass 
		};
	
//	xmlHttp.onreadystatechange = procesarEvento;
//	xmlHttp.open('PUT', 'personaJSONPUT', true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
//	xmlHttp.setRequestHeader('Accept', 'application/json');
//	xmlHttp.setRequestHeader('Content-Type', 'application/json');
//	xmlHttp.send(JSON.stringify(persona));
	//EJEMPLO DE PETICIÓN CON POST

	/*var datos_str = JSON.stringify(datos_usuario);
	
	$.ajax({
        data:  datos_str,
        url:   '../login',
        contentType: 'application/json',
        type:  'post',
        success:  function (response) {
                        respuesta (response);
                }
});*/
	
	//EJEMPLO DE PETICIÓN CON GET
	//var datos_str = JSON.stringify(datos_usuario);
	$.ajax({
        data:  datos_usuario,
        url:   '../loginget',
        contentType: 'application/json',
        type:  'get',
        success:  function (response) {
                        respuesta (response);
                }
	});
}

function validarFormLogin ()
{
	//alert (jQuery("#usuario").val());
	//jQuery("#usuario").val();
	
	var usuario = $("#usuario").val();
	var pwd = $("#contrasenia").val();
	
	var patron = new RegExp(/^\w{6,}$/);//al menos 6 números o letras o guiones
	var usuario_val = patron.test(usuario);
	var contrasenia_val = patron.test(pwd);
	
	if ((usuario_val))
		{
		console.log ("USUARIO OK");
		if (!contrasenia_val)
			{
			console.log ("PASSWORD KO");
			$("p").remove();
			var myNewElement = $( "<p>Clave de al menos 6 caracteres (entre letras, numeros y guiones) </p>" );
			myNewElement.insertAfter($("#boton_ir"));
			
			
			} else 
					{ 
						$("p").remove(); 
						console.log ("USER Y PASSWORD OK");
						enviarLogin(usuario, pwd);
					}
		}
	else 
		{
		
		console.log ("USUARIO KO");
		$("p").remove();
		var myNewElement = $( "<p>Nombre de al menos 6 caracteres. (entre letras, numeros y/o guiones) </p>" );
		myNewElement.insertAfter($("#boton_ir"));
		
		}
}