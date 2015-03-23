/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import dao.StudentDao;
import dao.StudentDaoImpl;
import dto.InstructorDto;
import dto.StudentDto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.SignInController;

/**
 *
 * @author Al-Jazayeerly
 */
public class SignIn extends HttpServlet {

    SignInController signInController = new SignInController();

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

        response.setContentType("text/html;charset=UTF-8");
        //get parameters

        String name = request.getParameter("user");
        String namePrefix = name.substring(0, 4);
        String namePostfix = name.substring(4);
        String password = request.getParameter("pass");
        if (namePrefix.equals("std_")) {
            StudentDto studentDto = signInController.SigninStudent(name, password);
            if (studentDto != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("studentDto", studentDto);
                response.sendRedirect("/LADManagment/welcomeStudent.html");
            }
        } else if (namePrefix.equals("ins_")) {
            InstructorDto instructorDto = signInController.SigninInstructor(name, password);
            if (instructorDto != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("instructorDto", instructorDto);
                response.sendRedirect("/LADManagment/welcomeIns.html");
            }else{
                System.out.println("boundary.SignIn  --> no instructor with those username and password");
            }
        } else {
            //////////////////////////////////////////
            ///////To be removed/////////////////
            //////////////////////////////////////////
            System.out.println("boundary.SignIn --> user dont specify a prefix");
        }
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
