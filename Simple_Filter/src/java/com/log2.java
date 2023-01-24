/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
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
public class log2 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Before Filter");
        
        
        chain.doFilter(request,response );
        
        
         System.out.println("After Filter");
    }

    @Override
    public void destroy() {
    
    }
    
}
