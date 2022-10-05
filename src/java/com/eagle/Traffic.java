/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.eagle;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author varun
 */
public class Traffic extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
         String[] s= {null,"Bike","Auto","Car","Van","Bus","Truck","Tractor","Bycycle","Other" };
            out.println("<html>");
            out.println("<head>");
            out.println("<title>");
       out.println("Traffic Counter");
       out.println("</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='c' method='post'>");
            
            int n=10;
           
            for(int i=1;i<n;i++)
                {
                    out.println("Vehicle "+ i+" : <input type='text' name='tb"+i+"' placeholder='Enter vehicle Name..' value='"+s[i]+"'><br><br>");
                    }
            out.println("Enter Time : <input type='number' name='min' value='13' placeholder='Enter Time in min.....'><br><br>");
            out.println("<input type='submit' name='submit'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
    }

}