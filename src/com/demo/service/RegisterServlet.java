package com.demo.service;

import com.demo.bean.User;
import com.demo.dao.UserDAo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ForMe
 * ${PACKAGE_NAME}
 * 2019/2/10
 * 11:31
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username =  request.getParameter("username");
        String password = request.getParameter("password");
        String phonenumber = request.getParameter("phonenumber");
        String idnumber = request.getParameter("idnumber");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhonenumber(phonenumber);
        user.setIdnumber(idnumber);
        UserDAo userDAo = new UserDAo();
        boolean flag = userDAo.register(user);
        if(flag)
            request.getRequestDispatcher("/WEB-INF/registersuccess.jsp").forward(request,response);
        else
            request.getRequestDispatcher("/WEB-INT/register_defeat.jsp").forward(request,response);
    }
}
