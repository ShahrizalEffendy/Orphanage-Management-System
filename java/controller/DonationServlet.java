/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.DonationBean;
import dao.DonationDao;
import java.io.IOException;
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
public class DonationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String item = request.getParameter("item");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        DonationBean dBean = new DonationBean();
                
        dBean.setItem(item);
        dBean.setQuantity(quantity);
        
        DonationDao.Donation(dBean);
        
        List<DonationBean> donate = DonationDao.getDonation();
        
        request.setAttribute("donate", donate);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("DonateSuccess.html");
        dispatcher.forward(request, response);
    }

}
