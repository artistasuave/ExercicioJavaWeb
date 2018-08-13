package br.com.practiceMicaJavaWeb.web.alunos;

import br.com.practiceMicaJavaWeb.bean.AlunoBean;
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
@WebServlet(urlPatterns = "/alunos/update")
public class AlunoUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {

        AlunoBean aluno = new AlunoBean();
        aluno.setNome(req.getParameter("nome"));
        aluno.setCodigoMatricula(req.getParameter("codigoMatricula"));
        aluno.setNota1(Double.parseDouble(req.getParameter("nota1")));
        aluno.setNota2(Double.parseDouble(req.getParameter("nota2")));
        aluno.setNota3(Double.parseDouble(req.getParameter("nota3")));
        aluno.setId(Integer.parseInt(req.getParameter("id")));
        aluno.setFrequencia(Byte.parseByte(req.getParameter("frequencia")));

        boolean alterou = new AlunoDAO().alterar(aluno);
    }

}
