package br.com.practiceMicaJavaWeb.web.alunos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michelle de Jesus Rogério
 */
@WebServlet(urlPatterns = "/alunos/editar")
public class AlunoEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {

    }

}
