
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="estilo.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="estilo.css"/>
    </head>
    <body>
        <h1>Registro mascota</h1>
        <div>
            <form action="registro" method="POST">
                <label for="tipo">tipo:</label>
                <select id="tipo"name="tipo">
                    <option value="na">Seleccione una opcion</option>
                    <option value="perro">perro</option>
                    <option value="gato">gato</option>
                </select>
                
                <label for="nombre">nombre:</label>
                <input type="text" id="nombre" name="nombre" required><br> <br>
                
                <label for="edad">edad:</label>
                <input type="int" id="edad" name="edad" required><br> <br>
                
                <label for="raza">raza:</label>
                <input type="text" id="raza" name="raza" required><br> <br>
                
                <label for="color">color:</label>
                <input type="text" id="color" name="color" required><br> <br> 
                <div id="optNivel">
                <label for="nivel">nivel entreno:</label>
                <input type="number" min="0" max="10" id="nivel" name="nivelentreno" required>
                </div>
                
                <div id="optToxo">
                <label for="toxo">toxoplasmosis:</label>
                <select id="toxo"name="toxos">
                    <option value="si">si</option>
                    <option value="no">no</option>
                </select>
                </div>
                
                <input type="submit" value="Enviar">
            </form>
        </div>
        
        <script src="miJs.js"></script>
    </body>
</html>
