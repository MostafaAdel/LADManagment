/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.instructor;

import dao.instructor.LabDaoImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Assignment;

/**
 *
 * @author azza
 */
public class DownloadAssignment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        int labID = Integer.parseInt(request.getParameter("labid"));
        int stuID = Integer.parseInt(request.getParameter("stuId"));
        
        ArrayList<Assignment> assignments = getAssignment(labID, stuID);
        
        for(Assignment a:assignments){
        String fileName=a.getName();
        String fileUrl=a.getUrl();
        if(fileName == null || fileName.equals("")){
            throw new ServletException("File Name can't be null or empty");
        }
        ServletContext ctx=getServletContext();
        File file=new File(fileUrl);
        InputStream fis=new FileInputStream(file);
        String mimeType=ctx.getMimeType(file.getAbsolutePath());
        response.setContentType(mimeType!=null?mimeType:"application/octet-stream");
        response.setContentLength((int) file.length());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
        response.setHeader(headerKey, headerValue);
         
        //response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        ServletOutputStream os=response.getOutputStream();
        byte[] bufferData=new byte[4096];
        int read=0;
        while((read=fis.read(bufferData))!=-1){
        os.write(bufferData,0,read);
        }
        os.flush();
        os.close();
        fis.close();
        System.out.println("File downloaded at client successfully");
        }
        
    }

    private ArrayList<Assignment> getAssignment(int labId, int stuId) {
        LabDaoImpl lab = new LabDaoImpl();
        return lab.getAssingnemt(labId, stuId);
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
