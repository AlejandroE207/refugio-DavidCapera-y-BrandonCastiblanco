
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@page import="modelo.*" %>
<%
         //paso 1 recuperar la lista
        ArrayList veterinaria = new ArrayList();
        veterinaria = (ArrayList) session.getAttribute("lista");
        
        CalculoPerroGato aux = new CalculoPerroGato();
        int prom = aux.promEdad(veterinaria);
        int nPerros = aux.nPerros(veterinaria);
        int nGatos = aux.nGatos(veterinaria);
      %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilo.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="titulo1">REFUGIO</h1>
        <table border="4">
            <thead class="cabezadoTabla">
                <th>Id</th>
                <th>Nombre</th>
                <th>Raza</th>
                <th>Color</th>
                <th>Edad</th>
                <th>Nivel Entrenamiento</th>
                <th>Toxoplasmosis</th>
                <th>Acciones</th>
            </thead>
           
            <tbody>
                <% 
                        Iterator it = veterinaria.iterator();
                        int indice=0;
                        while(it.hasNext()){
                            Mascota objeto = (Mascota)it.next();
                            indice = veterinaria.indexOf(objeto);%>
                            <tr>
                                <td><%= indice %></td>
                                <td><%= objeto.getNombre()%></td>
                                <td><%= objeto.getRaza()%></td>
                                <td><%= objeto.getColor()%></td>
                                <td><%= objeto.getEdad()%></td>
                                <% if(objeto instanceof Canino){ 
                                        int nivel=0;
                                        nivel=((Canino)objeto).getNivelE(); %>
                                        <td><%= nivel%></td>
                                <% }else{ %>
                                    <td>N/A</td>
                                <% } %>
                                <% if(objeto instanceof Felino){
                                        boolean toxo=((Felino)objeto).isToxo(); %>
                                        <td><%= toxo%></td>
                                <% }else{ %>
                                    <td>N/A</td>
                                <% } %>
                                
                                <td> 
                                    <form action="registro" method="get">
                                        <input type="hidden"  name="indice" value="<%= indice %>">
                                        <!--<input type="submit" class="boton enviar" value="Enviar">-->
                                        <input type="submit" value="Eliminar"> 
                                    </form>
                                </td>
                                
                            </tr>
                    <% } %>
            </tbody>
        </table>
            <div class="cont_agr">
                <a class="boton_agr" href="index.jsp">AGREGAR OTRO</a>
            </div>
            
                <h2>ESTADISTICA</h2>
                <div class="estad">
                    <div>
                        <p class="cont_est-dato">Promedio edad: <%= prom %> </p>
                        <p class="cont_est-dato">Cantidad perros: <%= nPerros %> </p>
                        <p class="cont_est-dato">Cantidad gatos: <%= nGatos %> </p>
                    </div>   
                </div>
    </body>
</html>
