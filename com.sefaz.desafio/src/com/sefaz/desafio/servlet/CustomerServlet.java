package com.sefaz.desafio.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sefaz.desafio.dao.CustomerDao;
import com.sefaz.desafio.model.Customer;

@WebServlet("/login")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                         throws ServletException, IOException{
 
        HttpSession session = request.getSession(); //obtem a sessao do usuario
 
        Customer customer = null;
        String login_form = request.getParameter("login"); // Pega o Login vindo do formulario
        String pass_form = request.getParameter("pass"); //Pega a senha vinda do formulario
 
        try {
            CustomerDao dao = new CustomerDao(); //cria uma instancia do DAO usuario
            customer = dao.getLogin(login_form, pass_form);
        }
        catch ( Exception e ){
 
        }
 
        //se nao encontrou usuario no banco, redireciona para a pagina de erro!
        if ( customer == null ) {
            session.invalidate();
            request.getRequestDispatcher("error.jsp" ).forward(request, response);
        }
        else{
            //se o dao retornar um usuario, coloca o mesmo na sessao
            session.setAttribute("Customer", customer);
            request.getRequestDispatcher("log.jsp" ).forward(request, response);
        }
 
    }
}
