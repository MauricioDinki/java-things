<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilos.css">
    <body>
    	<div class="container">
	        <h1>Calculadora JSP + Servlet</h1>
	        <form role="form" name="calculadora" action="Servlet" method="POST">
	          <div class="form-group">
	            <label for="primerTermino">Primer Termino</label>
	            <input class="form-control" type="number" name="primerTermino" id="primerTermino"  required>
	          </div>
	          <div class="form-group">
	            <label for="segundoTermino">Segundo Termino</label>
		        <input class=" col-md-8 form-control" type="number" name="segundoTermino" id="segundoTermino" required>
	          </div>
	          <div class="form-group">
	            <select class="form-control" name="operador" id="operador">
	        		<option value="suma">Sumar</option>
	        		<option value="resta">Restar</option>
	        		<option value="multiplicacion">Multiplicar</option>
	        		<option value="division">Dividir</option>
	        	</select>
	          </div>
	          <button type="submit" class="btn btn-default">Enviar</button>
	        </form>
        </div>
    </body>
</html>