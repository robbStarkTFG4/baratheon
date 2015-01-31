/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.server.beans.staless.TblMaterialFacade;
import com.server.beans.staless.TblPrestariosFacade;
import com.server.entity.beans.Subfamilias;
import com.server.entity.beans.TblArea;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPrestarios;
import com.server.entity.beans.TblTipomaterial;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NORE
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    
    @EJB
    TblPrestariosFacade pres;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String param = request.getParameter("akkcveren");
        
        PrintWriter out = response.getWriter();
        
        String prestario = decode(param);
        //  out.println("EL PARAMETRO DECODIFICADO ES : " + prestario);
        TblPrestarios res = pres.getPresForActivation(prestario);

        // out.println("el estado es: " + res.getActivo());
        if (res.getActivo() == 0) {
            res.setActivo(1);
            pres.edit(res);
            out.println("TU CUENTA HA SIDO ACTIVADA " + res.getNombre() + " " + res.getApaterno() + " " + res.getAmaterno());
            out.println("INGRESA USANDO TU USUARIO: " + res.getUsuario());
            out.print("En el menu PRESTAMOS");
        } else {
            out.println("link no valido");
        }
        
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

    private String decode(String param) {
        String decoded;
        
        StringBuilder sb = new StringBuilder(20);
        char[] array = param.toCharArray();
//a=0, b=1,c=2,d=3,e=4,f=5,g=6,h=7, i=8,n=9
        for (char c : array) {
            System.out.println(c);
            if (c == 'a') {
                sb.append("0");
            }
            
            if (c == 'b') {
                sb.append("1");
            }
            
            if (c == 'c') {
                sb.append("2");
            }
            
            if (c == 'd') {
                sb.append("3");
            }
            if (c == 'e') {
                sb.append("4");
            }
            if (c == 'f') {
                sb.append("5");
            }
            if (c == 'g') {
                sb.append("6");
            }
            if (c == 'h') {
                sb.append("7");
            }
            if (c == 'i') {
                sb.append("8");
            }
            if (c == 'n') {
                sb.append("9");
            }
        }
        System.out.println("la string construida es : " + sb.toString());
        return sb.toString();
    }
    
    private String encode(String param2) {
        char[] array = param2.toCharArray();
        StringBuilder sb = new StringBuilder(20);
        //a=0, b=1,c=2,d=3,e=4,f=5,g=6,h=7, i=8,n=9
        for (char c : array) {
            if (c == '0') {
                sb.append("a");
            }
            
            if (c == '1') {
                sb.append("b");
            }
            if (c == '2') {
                sb.append("c");
            }
            if (c == '3') {
                sb.append("d");
            }
            if (c == '4') {
                sb.append("e");
            }
            if (c == '5') {
                sb.append("f");
            }
            if (c == '6') {
                sb.append("g");
            }
            if (c == '7') {
                sb.append("h");
            }
            if (c == '8') {
                sb.append("i");
            }
            if (c == '9') {
                sb.append("n");
            }
            
        }
        
        System.out.println("ENCODED STRRING: " + sb.toString());
        return sb.toString();
    }
    
}
