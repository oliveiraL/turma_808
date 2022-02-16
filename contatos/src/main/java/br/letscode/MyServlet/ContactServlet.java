package br.letscode.MyServlet;

import java.io.*;
import java.util.ArrayList;

import br.letscode.MyServlet.model.Contact;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "contactServlet", value = "/contacts/*")
public class ContactServlet extends HttpServlet {
    private ArrayList<Contact> contacts;
    ObjectMapper objectMapper = new ObjectMapper();

    public void init() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Lucio", "lucio@lets.com.br"));
        contacts.add(new Contact("Gabriela", "gabriela@lets.com.br"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendAsJson(response);
    }

    private void sendAsJson(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        String json = objectMapper.writeValueAsString(contacts);
        printWriter.print(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null){
            buffer.append(line);
        }
        Contact contact = objectMapper.readValue(buffer.toString(), Contact.class);
        contacts.add(contact);
        sendAsJson(resp);
    }

    public void destroy() {
    }
}