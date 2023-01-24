/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author HP
 */
public class Auth2 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Before Filter");
        //out.println("<h1> Before Filter </h1>");
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        
         StudentDB s = new StudentDB();
         if(s.validateLogin(uname,pass)){
        //if(uname.equals("abc") && pass.equals("abc")){
            try {
                PrintWriter out = response.getWriter();
                out.println("<h1> Success</h1>");
                chain.doFilter(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            PrintWriter out = response.getWriter();
            out.println("<h1> Wrong Username & Password </h1>");
        }
        chain.doFilter(request,response );
        
        
        
        
         System.out.println("After Filter");
    }

    @Override
    public void destroy() {
    
    }
    
}
