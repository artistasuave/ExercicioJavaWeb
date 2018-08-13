package br.com.practiceMicaJavaWeb.web.alunos;

import br.com.practiceMicaJavaWeb.bean.AlunoBean;
import br.com.practiceMicaJavaWeb.dao.AlunoDAO;
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
@WebServlet(urlPatterns = "/alunos/editar")
public class AlunoEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AlunoBean aluno = new AlunoDAO().obterPeloId(id);

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alunos - Editar</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='/Alunos/alunos/update' method='post'>");
        out.println("<input type='hidden' name='id' value='"
                + aluno.getId() + "'>");

        out.println("<div>");
        out.println("<lable for='campo-nome'>Nome</lable>");
        out.println("<input type='text' id='campo-nome'name='nome' value='"
                + aluno.getNome() + "'>");
        out.println("</div>");

        out.println("<div>");
        out.println("<label for='campo-codigoMatricula'>Código de Matrícula</label>");
        out.println("<input type='text' id='campo-codigoMatricula' name='codigoMatricula' value='"
                + aluno.getCodigoMatricula() + "'></div>");

        out.println("<div>");
        out.println("<label for='campo-nota1'>Nota 1</label>");
        out.println("<input type='text' id='campo-nota1' name='nota1' value'"
                + aluno.getNota1() + "'></div>");

        out.println("<div>");
        out.println("<label for='campo-nota2'>Nota 2</label>");
        out.println("<input type='text' id='campo-nota2' name='nota2' value'"
                + aluno.getNota2() + "'></div>");

        out.println("<div>");
        out.println("<label for='campo-nota3'>Nota 3</label>");
        out.println("<input type='text' id='campo-nota3' name='nota3' value'"
                + aluno.getNota3() + "'></div>");

        out.println("<div>");
        out.println("<label for='campo-frequencia'>Frequência</label>");
        out.println("<input type='text' id='campo-frequencia' name='frequencia' value'"
                + aluno.getFrequencia() + "'></div>");

        out.println("<input type='submit' value='Alterar'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

}
