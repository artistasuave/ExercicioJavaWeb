package br.com.practiceMicaJavaWeb.web.alunos;

import br.com.practiceMicaJavaWeb.bean.AlunoBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michelle de Jesus Rogério
 */
@WebServlet(urlPatterns = "/alunos/store")
public class AlunoStore extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        AlunoBean aluno = new AlunoBean();
        aluno.setNome(req.getParameter("nome"));
        aluno.setCodigoMatricula(req.getParameter("codigoMatricula"));
        aluno.setNota1(Double.parseDouble(req.getParameter("nota1")));
        aluno.setNota2(Double.parseDouble(req.getParameter("nota2")));
        aluno.setNota3(Double.parseDouble(req.getParameter("nota3")));
        aluno.setFrequencia(Byte.parseByte(req.getParameter("frequencia")));

        int codigo new AlunoDAO().adicionar(aluno);

        PrintWriter out = resp.getWriter();
        out.print("Cadastrado com sucesso");

    }

}
