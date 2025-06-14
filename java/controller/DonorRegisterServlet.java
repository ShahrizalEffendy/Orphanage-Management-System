package controller;

import bean.DonorRegisterBean;
import dao.DonorRegisterDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vaio
 */
public class DonorRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String contactno = request.getParameter("contactno");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DonorRegisterBean don = new DonorRegisterBean();
                
        don.setName(name);
        don.setAddress(address);
        don.setContactno(contactno);
        don.setUsername(username);
        don.setPassword(password);
        
        DonorRegisterDao.registerDonor(don);
        
        List<DonorRegisterBean> donor = DonorRegisterDao.getDonor();
        
        request.setAttribute("donor", donor);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);

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
