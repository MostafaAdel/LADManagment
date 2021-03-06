/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary.instructor;

import dto.InstructorDto;
import dto.instructor.CourseDto;
import dto.instructor.GroupDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.instructor.InstructorMianPageController;

/**
 *
 * @author azza
 */
public class InstructorMainPage extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    InstructorMianPageController controller=new InstructorMianPageController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session = request.getSession(false);
                InstructorDto instructorDto= (InstructorDto)session.getAttribute("instructorDto");
                System.out.println(instructorDto.getInstructorId());
                ArrayList<GroupDto> insGroups= controller.getInstructorGroups( instructorDto.getInstructorId());
                System.out.println(insGroups.get(0).getName());
                session.setAttribute("insGroups", insGroups);
                session.setAttribute("x", insGroups.size());
                session.setAttribute("insID", instructorDto.getInstructorId());
                response.sendRedirect("/LADManagment/welcomeIns.jsp");
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
