<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Regiones</title>
    </head>
    <body>
        <div align="center">
            <h1>Lista Regiones</h1>
            <table border="1">
                <th>Nombre</th>
                <th>ID</th>
                 
                <c:forEach items="${lista_regiones}" var="region" varStatus="i">
                <tr>
					<td><c:out value="${region.name}"></c:out></td>
				<td><c:out value="${region.id}"></c:out></td></tr>
		</c:forEach>            
            </table>
        </div>
    </body>
</html>
