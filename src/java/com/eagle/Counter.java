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
import java.util.ArrayList;

/**
 *
 * @author varun
 */
public class Counter extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
       PrintWriter out = response.getWriter();
       out.println("<html>");
       out.println("<head >");
       out.println("<title>");
       out.println("Traffic Counter");
       out.println("</title>");
       out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
       out.println("<style >");
       out.println("body{background-color:white;}");
       out.println("p{ color:black; }");
       
       out.println(".button_style,.button_style1,.button_style2{");
       out.println(" border-radius: 20%; border:none; font-size:7vw; color:white; background-color:cyan; }");
       out.println(".button_style{width:32%;height:20%;}");
       out.println(".button_style1{width:99%;height:20%;}");
       out.println(".button_style2{width:49.5%;height:20%;}");
       out.println(".button_align{ text-align: center;}");
       out.println(".timer{");
       out.println(" border-radius: 20%; border:none; font-size:6vw; color:white; background-color:red; }");
       
       
       out.println("</style >");
       out.println("</head >");
       out.println("<body >");
       
       ArrayList <String> ar1= new ArrayList();
        
       //geting parameters
        for(int i=1;i<10;i++){                                                      
            if(!request.getParameter("tb"+i).isEmpty())
            {
            ar1.add("tb"+i);
        }   }
        ArrayList <String> ar2= new ArrayList();
        
        //adding parameters into another String
        for(int i=0;i<ar1.size();i++)
        { ar2.add(request.getParameter(ar1.get(i))); }
        
        int size=ar2.size();
       
        // paragraph
        out.println("<p id=\"para_Sec\"></p>");
        out.println("<p id=\"para_Total\"> Total :  </p>");
        out.println("<p id=\"para_Vol\"> Volume :  </p>");
        
        //buttons
        out.println("<div class='button_align'>");
        for(int a=1;a<=size;a++)                                             
        {      
            if((3*(size/3))<a)
            {
            if(size%3==1)
                out.println("<input class='button_style1' type='button' name='"+ar2.get(a-1)+"' id='"+ar2.get(a-1)+"' value='"+ar2.get(a-1)+"'  onclick=\"click"+(a)+"();\">");
            
            if(size%3==2)
                out.println("<input class='button_style2' type='button' name='"+ar2.get(a-1)+"' id='"+ar2.get(a-1)+"' value='"+ar2.get(a-1)+"'  onclick=\"click"+(a)+"();\">");
           
            if(a==size)
            out.println("<br><br>");
            }
            
            else
            {
        out.println("<input class='button_style' type='button' name='"+ar2.get(a-1)+"' id='"+ar2.get(a-1)+"' value='"+ar2.get(a-1)+"'  onclick=\"click"+(a)+"();\">");
        if(a%3==0) 
        out.println("<br><br>");
        } 
        }

        out.println("<br>");
        out.println("<input type='button' class='timer' id='start' name='start' value='Start' onclick=\"fn_letStart();\">");
        out.println("<input type='button' class='timer' id='reset' name='reset' value='Reset' onclick=\"fn_reset();\">");
        out.println("<input type='button'  class='timer' id='dem1' name='dem1' value='dem1' onclick=\"fn_reset();\">");
        out.println("</div>");
        
        out.println("<script>");     //form Started
        
        //variables
        out.println("sec=0;");
        out.println("total=0;");
        out.println("pause=false;");
        out.println("restriction='"+ request.getParameter("min")+"';");
        
         for(int i=0;i<size;i++)  
             {
                 out.println("var_"+ar2.get(i)+"=0;");
                 }
         out.println("run=false;");
     
         //lteStart function
         out.println("function fn_letStart()");                                          
         out.println("{");
         out.println("document.getElementById(\"start\").style.width = \"99%\";");
         out.println("if(document.getElementById(\"start\").value=='Resume'){ ");
         out.println("document.getElementById('reset').style.visibility ='hidden';");
         out.println("fn_resume(); document.getElementById(\"start\").value='Pause'; ");
         out.println("}");
         
         out.println("else if(document.getElementById(\"start\").value=='Pause'){ ");
         out.println("document.getElementById(\"start\").style.width = \"49%\";");
         out.println("document.getElementById(\"reset\").style.width = \"49%\";");
         
         out.println("document.getElementById('reset').style.visibility ='visible';");
         out.println("fn_pause(); document.getElementById(\"start\").value='Resume'; ");
         
         out.println("}");
         out.println("else if(document.getElementById(\"start\").value=='Start'){ ");
         out.println("pause=false;  fn_start(); document.getElementById(\"start\").value='Pause'; ");
         out.println("}");
         out.println("}");
         
         //start function
         out.println("function fn_start()");                                          
         out.println("{");
         out.println("run=true;sec=0;fn_loop();");
         out.println("}");
       
         //resume function
         out.println("function fn_resume()");                                                      
         out.println("{");
         out.println("run=true; pause=false; fn_loop();");
         out.println("}");
     
         //Loop Function
         out.println("function fn_loop()");
         out.println("{");
         out.println("if(!pause){");
         out.println("document.getElementById(\"para_Sec\").innerHTML=time(sec);");           
         out.println("document.getElementById(\"para_Vol\").innerHTML='Volume : '+fn_coeff((total*60),sec)+'  Veheicle per Min';");
         out.println("sec++; ");
         out.println("setTimeout(fn_loop, 1000);");
         out.println("}");
         out.println("}");
        
         //visibility function
         out.println("function fn_vis(a,b)");         
         out.println("{");
         out.println("document.getElementById('start').style.visibility = a;");
         out.println("document.getElementById('reset').style.visibility = b;");
         out.println("}");
        
         //pause function
         out.println("function fn_pause()");                            
         out.println("{");
         out.println("run=false;pause=true;");
         out.println("}");
        
         //reset function
         out.println("function fn_reset()");            
         out.println("{");
         out.println("document.getElementById(\"start\").style.width = \"99%\";");
         out.println("total=0;");
         out.println("sec=0;");
         for(int i=0;i<size;i++)  
             {
                 out.println("var_"+ar2.get(i)+"=0;");
                 out.println("document.getElementById(\""+ar2.get(i)+"\").value=\""+ar2.get(i)+"\"+'\\n  ';");
                 }
         out.println("document.getElementById('dem1').style.visibility ='hidden';");
         out.println("document.getElementById('reset').style.visibility ='hidden';");
         out.println("document.getElementById('start').value ='Start';");
         out.println("document.getElementById(\"para_Total\").innerHTML='Total : '+total;");
         out.println("document.getElementById(\"para_Vol\").innerHTML='Volume : '+fn_coeff((total*60),sec)+'  Veheicle per Min';");
         out.println("document.getElementById(\"para_Sec\").innerHTML='00 : 00 : 00';"); 
         out.println("}");
        
     
        //  functions
        for(int i=0;i<size;i++)      
        {    
        out.println("function click"+(i+1)+"()");
        out.println("{");
        out.println("if(run==true)");
        out.println("{");
        out.println("var_"+ar2.get(i)+"++;");
        out.println("total++;");
        out.println("click();");
        out.println("document.getElementById(\""+ar2.get(i)+"\").value=\""+ar2.get(i)+"\\n \"+"+"var_"+ar2.get(i)+";");
        out.println("}");
        out.println("}");
        }
        
        //click functions
            
        out.println("function click()");
        out.println("{");
        out.println("document.getElementById(\"para_Total\").innerHTML='Total : '+total;");
        out.println("document.getElementById(\"para_Vol\").innerHTML='Volume : '+fn_coeff((total*60),sec)+'  Veheicle per Min';");
        out.println("}");
        
        
        out.println("</script>");

        out.println("<script>"); 
        out.println("function fn_coeff(x,y)"); 
        out.println("{");
        out.println("return (x-(x%y))/y;");
        out.println("}");
         
          //time function
        out.println("function time(sec)");                   
        out.println("{");
        //out.println("if(restriction*60<sec){ fn_pause(); return h+' : '+m1+' : '+s1;}");
        out.println("m=0;  m1=0;  s1=0;  h=0;  h1=0;");
        out.println("s=sec;");
        out.println("s1=s%60;");
        out.println("m=fn_coeff(s,60);");
        out.println("m1=m%60;");
        out.println("h=fn_coeff(m,60);");
        out.println("if(h>=24){fn_pause();}");
        out.println("if(m1<10){m1='0'+m1;}");
        out.println("if(h<10){h='0'+h;}");
        out.println("if(s1<10){s1='0'+s1;}");
        out.println("return h+' : '+m1+' : '+s1;");
        out.println("}");
        
        out.println("</script>"); 
        out.println("<script>");
        
        out.println("fn_reset();");
        out.println("</script>");
        
        out.println(" </body>");
        out.println("</html>");
       
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    response.sendRedirect("Tc");
    }

}