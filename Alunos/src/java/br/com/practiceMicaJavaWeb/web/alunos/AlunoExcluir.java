package br.com.practiceMicaJavaWeb.web.alunos;

import br.com.practiceMicaJavaWeb.dao.AlunoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michelle de Jesus Rogério
 */
@WebServlet(urlPatterns = "/alunos/excluir")
public class AlunoExcluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean apagou = new AlunoDAO().excluir(id);

        if (apagou) {
            resp.getWriter().print("Apagado com sucesso");
        } else {
            resp.getWriter().print("O registro não foi apagado");
        }
    }

}
