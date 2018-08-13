package br.com.practiceMicaJavaWeb.web.alunos;

import br.com.practiceMicaJavaWeb.bean.AlunoBean;
import br.com.practiceMicaJavaWeb.dao.AlunoDAO;
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
@WebServlet(urlPatterns = "/alunos")
public class AlunoIndex extends HttpServlet {

    private PrintWriter out;
    
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        
        List<AlunoBean> alunos = new AlunoDAO().obterTodos();
        out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alunos Cadastrados</title>");
        out.println("<link rel='stylesheet' type='text/css' href='bootstrap/css/bootstrap.css'/>");
        out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.2.0/css/all.css' "
                + "integrity='sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ' "
                + "crossorigin='anonymous'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container-fluid'>");
        out.println("<div class='row'>");
        out.println("<div class='col-md-12'>");

        out.println("<h3 class='text-center'>Alunos Cadastrados</h3>");
        out.println("</div>");
        out.println("</div>");

        out.println("<div class='row'>");
        out.println("<div class='col-md-2 offset-md-10'>");

        out.println("<a href='/Alunos/alunos/cadastro' "
                + "class='btn btn-primary float-right'><i class='fa fa-user'></i> Incluir Aluno</a>");
        out.println("</div>");
        out.println("</div>");

        gerarTabela(alunos);

        out.println("</body>");
        out.println("</html>");
    }

    private void gerarTabela(List<AlunoBean> alunos) {

        out.println("<div class='row mtx-3 justify-content-md-center'>");
        out.println("<div class='col-md-8'>");

        out.println("<table class='table table-striped table-hover'>");
        out.println("<thead>");
        out.println("<tr class='table-primary'>");
        out.println("<th>Código</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Código da Matrícula</th>");
        out.println("<th>Nota 1</th>");
        out.println("<th>Nota 2</th>");
        out.println("<th>Nota 3</th>");
        out.println("<th>Frequência</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for (AlunoBean aluno : alunos) {

            out.println("<tr>");
            out.println("<td>" + aluno.getId() + "</td>");
            out.println("<td>" + aluno.getNome() + "</td>");
            out.println("<td>" + aluno.getCodigoMatricula() + "</td>");
            out.println("<td>" + aluno.getNota1() + "</td>");
            out.println("<td>" + aluno.getNota2()+ "</td>");
            out.println("<td>" + aluno.getNota3()+ "</td>");
            out.println("<td>" + aluno.getFrequencia()+ "</td>");
            out.println("<td>");

            out.println("<a href='/Alunos/alunos/editar?id="
                    + aluno.getId() + "'class='btn btn-outline-success'><i class='fa fa-edit'></i>Editar</a>");
            out.println("<a href='/Alunos/alunos/excluir?id="
                    + aluno.getId() + "'class='btn btn-outline-danger'><i class='fa fa-trash'></i>Excluir</a>");

            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("<tfoot>");
        out.println("<tr>");
        out.println("<th>Código</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Código da Matrícula</th>");
        out.println("<th>Nota 1</th>");
        out.println("<th>Nota 2</th>");
        out.println("<th>Nota 3</th>");
        out.println("<th>Frequência</th>");
        out.println("</tr>");
        out.println("</tfoot>");
        out.println("</table>");

        out.println("</div>");
        out.println("</div>");
        
    }
}
