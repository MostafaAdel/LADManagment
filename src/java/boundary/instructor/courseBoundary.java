/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.instructor;

import dto.instructor.CourseDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.instructor.InstructorMianPageController;

/**
 *
 * @author Hossam
 */
public class courseBoundary extends HttpServlet {

    InstructorMianPageController controller=new InstructorMianPageController();
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
        response.setContentType("text/xml");
        String groupName = request.getParameter("group");
        
        String responseXmlText="";
        ArrayList<CourseDto> courses = controller.getCoursesOfGroup(Integer.parseInt(groupName));
        
        if(courses.size() != 0){
            responseXmlText += "<courses>";
            for(int i=0 ; i<courses.size() ;i++){
                responseXmlText += "<course>";
                responseXmlText += "<name>";
                responseXmlText += courses.get(i).getName();
                responseXmlText += "</name>";
                responseXmlText += "</course>";
            }
            responseXmlText += "</courses>";
        }
        response.getWriter().println(responseXmlText);
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
