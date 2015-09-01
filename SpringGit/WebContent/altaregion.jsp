<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">

var xmlHttp = new XMLHttpRequest();

function llamadaRest()
{
	var rid = document.getElementById("id").value;
	var nombre = document.getElementById("name").value;
	
	var region = {
		    id:rid,
		    name:nombre
		};
	
	xmlHttp.onreadystatechange = procesarEvento;
	xmlHttp.open('PUT', 'crearRegion', true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.send(JSON.stringify(region));
	
}

function procesarEvento()
{
   
  if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
  {
      if(xmlHttp.status==200)// y el código de la cabecera http es bueno
          {
    	  	muestraRegion(xmlHttp.responseText);
          }
      else
      {
          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
      }
  }

}

function muestraRegion(texto)
{
	alert("Resultado " + texto);
	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Bienvenido</title>
</head>
<body>

	<label for="id">Id Region</label><input type = "text" name = "id" id="id"/>
	<label for="name">Nombre</label><input type = "text" name = "name" id="name"/>
<input type="button" onclick="llamadaRest();" value="Add region"></input>
</body>
</html>