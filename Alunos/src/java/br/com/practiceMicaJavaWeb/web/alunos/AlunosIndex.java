package br.com.practiceMicaJavaWeb.web.alunos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michelle de Jesus Rogério
 */
@WebServlet (urlPatterns = "/alunos")
public class AlunosIndex extends HttpServlet{
    
    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    out = resp.getWriter();
    }
    
    
            
    
}
