<<<<<<< HEAD
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
import logic.instructor.LabController;
import pojo.Lab;

/**
 *
 * @author Al-Jazayeerly
 */
public class SignIn extends HttpServlet {

    SignInController signInController = new SignInController();
    LabController labController = new LabController();

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
        System.out.println("in servelt Signin");
        String name = request.getParameter("user");
        String namePrefix = name.substring(0, 4);
        String namePostfix = name.substring(4);
        String password = request.getParameter("pass");
        if (namePrefix.equals("std_")) {
            System.out.println("Entered Student Sign in");
            StudentDto studentDto = signInController.SigninStudent(namePostfix, password);
            
            if (studentDto != null) {
                System.out.println("User name exist");
                HttpSession session = request.getSession(true);
                Lab lab = labController.getActiveLab(studentDto.getUserName());
                session.setAttribute("studentDto", studentDto);
                session.setAttribute("labDto", lab);
                response.sendRedirect("/LADManagment/welcomeStudent.jsp");
            }
        } else if (namePrefix.equals("ins_")) {
            InstructorDto instructorDto = signInController.SigninInstructor(namePostfix, password);
            System.out.println(namePostfix);
            if (instructorDto != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("instructorDto", instructorDto);
                System.out.println(instructorDto.getInstructorId());
                response.sendRedirect("/LADManagment/InstructorMainPage");
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
=======
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
import logic.instructor.LabController;
import pojo.Lab;

/**
 *
 * @author Al-Jazayeerly
 */
public class SignIn extends HttpServlet {

    SignInController signInController = new SignInController();
    LabController labController = new LabController();

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
        System.out.println("in servelt Signin");
        String name = request.getParameter("user");
        String namePrefix = name.substring(0, 4);
        String namePostfix = name.substring(4);
        String password = request.getParameter("pass");
        if (namePrefix.equals("std_")) {
            System.out.println("Entered Student Sign in");
            StudentDto studentDto = signInController.SigninStudent(namePostfix, password);
            
            if (studentDto != null) {
                System.out.println("User name exist");
                HttpSession session = request.getSession(true);
                Lab lab = labController.getActiveLab(studentDto.getUserName());
                session.setAttribute("studentDto", studentDto);
                session.setAttribute("labDto", lab);
                response.sendRedirect("/LADManagment/welcomeStudent.jsp");
            }
        } else if (namePrefix.equals("ins_")) {
            InstructorDto instructorDto = signInController.SigninInstructor(namePostfix, password);
            System.out.println(namePostfix);
            if (instructorDto != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("instructorDto", instructorDto);
                System.out.println(instructorDto.getInstructorId());
                response.sendRedirect("/LADManagment/InstructorMainPage");
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
>>>>>>> 47d89df5014cd689881c6673ab374229c08df3d6
