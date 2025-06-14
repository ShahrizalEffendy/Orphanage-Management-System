/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AdoptionBean;
import dao.AdoptionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class AdoptionRegistrationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String name = request.getParameter("name");
        String p_name = request.getParameter("p_name");
        int age = Integer.parseInt(request.getParameter("age"));
        int p_age = Integer.parseInt(request.getParameter("p_age"));
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        String p_contact = request.getParameter("p_contact");
        String occupation = request.getParameter("occupation");
        String child_name = request.getParameter("child_name");
        int child_age = Integer.parseInt(request.getParameter("child_age"));
        String gender = request.getParameter("gender");

        // Create a ChildBean object
        AdoptionBean adm = new AdoptionBean();
        adm.setName(name); 
        adm.setP_name(p_name);
        adm.setAge(age);
        adm.setP_age(p_age);
        adm.setAddress(address);
        adm.setContact(contact); 
        adm.setP_contact(p_contact);
        adm.setOccupation(occupation);
        adm.setChild_name(child_name);
        adm.setChild_age(child_age);
        adm.setGender(gender);

        // Save the child details to the database using DAO
        AdoptionDAO.saveAdm(adm);

       // List<AdminBean> admin = AdminDAO.getAdmin();

        // Pass the child data to the JSP
        request.setAttribute("name", name);
        request.setAttribute("p_name", p_name);
        request.setAttribute("age", age);
        request.setAttribute("p_age", p_age);
        request.setAttribute("address", address);
        request.setAttribute("contact", contact);
        request.setAttribute("p_contact", p_contact);
        request.setAttribute("occupation", occupation);
        request.setAttribute("child_name", child_name);
        request.setAttribute("child_age", child_age);
        request.setAttribute("gender", gender);
        

        // Forward to registration_success.jsp
        request.getRequestDispatcher("congrate.jsp").forward(request, response);
        
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
