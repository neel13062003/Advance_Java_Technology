/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.annotation.MultipartConfig;
import java.sql.*;
import javax.servlet.http.Part;
import java.io.*;


/**
 *
 * @author HP
 */
//Anotation is compulsory in image uploading part
//@MultipartConfig(maxFileSize = 16177215) 
public class Register extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            
            
            
            String name1= request.getParameter("user_name");
            String pass1= request.getParameter("user_password");
            String email1 =request.getParameter("user_email");
            
            /*Part part = request.getPart("image");;    //store image or file type content/
        
            String filename = part.getSubmittedFileName();*/  //This above line to active
            /* InputStream inputStream = null; 
             inputStream = part.getInputStream();*/
            //out.println(filename);  
            //Connection...
            try{
                //Thread.sleep(3000);
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/learn2","root",""); //jdbc:mysql://localhost:3307/
                
                //Query...
                //String  q= "INSERT INTO `details` (`name`, `password`, `email`,`imageName`) VALUES (?,?,?,?)";
                String  q= "INSERT INTO `details` (`name`, `password`, `email`) VALUES (?,?,?)";
                PreparedStatement pstmt= con.prepareStatement(q);
                pstmt.setString(1,name1);
                pstmt.setString(2,pass1);
                pstmt.setString(3,email1);
                //pstmt.setString(4,filename);
                
                //out.println("Execution Start but no complete");
                //This query not return data so 
                 pstmt.executeUpdate();
                
                //upload photo in folder = ? we are only saviing file name
                
                
                out.println("Done");
                
            }catch(Exception e){
                e.printStackTrace();
                out.println("Error");
            }
            //out.println(name1);
            
            
            
            out.println("</body>");
            out.println("</html>");
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

}
