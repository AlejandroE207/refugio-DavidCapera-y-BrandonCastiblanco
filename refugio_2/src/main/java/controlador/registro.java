/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import modelo.CalculoPerroGato;
import modelo.Canino;
import modelo.Felino;
import modelo.Mascota;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "registro", urlPatterns = {"/registro"})
public class registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("indice"));
        veterinaria.remove(id);
        response.sendRedirect("muestraDatos.jsp");
        
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
        String toxo = request.getParameter("toxos");
        boolean toxoplasmosis = true;
        if (toxo.equals("si")) {
            toxoplasmosis = true;
        } else {
            toxoplasmosis = false;
        }
        System.out.println("TOXOPLASMOSIS: "+toxoplasmosis);
        if (tipo.equals("perro")) {
            Canino objeto = new Canino(nivel, nombre, color, edad, raza);
            veterinaria.add(objeto);
        } else {
            if (tipo.equals("gato")) {
                Felino objeto = new Felino(nombre, color, edad, raza, toxoplasmosis);
                veterinaria.add(objeto);
            }
        }
        
        // se carga la lista
        request.getSession().setAttribute("lista", veterinaria);
        // redirecciona al usuario
        response.sendRedirect("muestraDatos.jsp");

  
        
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
