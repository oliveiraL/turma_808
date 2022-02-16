package br.com.letscode.contacts;

import java.io.*;

import br.com.letscode.contacts.beans.ListContact;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/contacts")
public class ContatosServlet extends HttpServlet {

    @Inject
    private ListContact listContactBean;

    public void init() {
        listContactBean = new ListContact();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-contacts.jsp");
        request.setAttribute("contatos", listContactBean.getContacts());
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
    }
}