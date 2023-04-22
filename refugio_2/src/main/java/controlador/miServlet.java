/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import modelo.Canino;
import modelo.Felino;

/**
 *
 * @author USUARIO
 */
public class miServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList  veterinaria = new ArrayList();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // paso 1 recibir formulario
        String tipo = request.getParameter("tipo");
        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String raza = request.getParameter("raza");
        String color = request.getParameter("color");
        int nivel = Integer.parseInt(request.getParameter("nivelentreno"));
        String toxo = request.getParameter("toxo");
        
        boolean toxoplasmosis = false;
        if (toxo == "si") {
            toxoplasmosis = true;
        }

        if (tipo.equals("perro")) {
            Canino objeto = new Canino(nivel, nombre, color, edad, raza);
            veterinaria.add(objeto);
        } else {
            if (tipo.equals("gato")) {
                Felino objeto = new Felino(nombre, color, edad, raza, toxoplasmosis);
                veterinaria.add(objeto);
            }
        }
        request.getSession().setAttribute("lista",veterinaria);
        // se carga la lista
        request.getSession().setAttribute("veterinaria", veterinaria);
        // redirecciona al usuario
        request.getRequestDispatcher("mostrarDatos.jsp").forward(request, response);

  
        
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
