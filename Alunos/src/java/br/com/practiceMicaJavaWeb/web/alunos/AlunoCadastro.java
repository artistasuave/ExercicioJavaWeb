package br.com.practiceMicaJavaWeb.web.alunos;

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
@WebServlet (urlPatterns = "/alunos/cadastro")
public class AlunoCadastro extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alunos - Cadastro</title>");
        out.println("<link rel='stylesheet' type='text/css' href='/Alunos/bootstrap/css/bootstrap.css'>");
        out.println("<script src='/Alunos/alunos-cadastro.js'></script>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='container-fluid'>");

        out.println("<form action='/Alunos/alunos/store' method='post' onsubmit='validarFormulario()'>");
        out.println("<div id='div-campo-nome' class='form-group'>");
        out.println("<label for='campo-nome'>Nome <span id='div-campo-nome' class='text-danger' font-weight-bold'>*</span></label>");
        out.println("<input type='text' class='form-control' id='campo-nome' name='nome' required='required'onfocusout='validarCampoNome()'>");
        out.println("</div>");
        
        
        out.println("<div id='div-campo-codigoMatricula' class='form-group'>");
        out.println("<label for='campo-codigoMatricula'>Código de Matrícula</label>");
        out.println("<input type='text' class='form-control' id='campo-codigoMatricula' name='codigoMatricula'onfocusout='validarCampoCodigoMatricula()'>");
        out.println("</div>");
        
        out.println("<div class='form-group'>");
        out.println("<label for='campo-nota1'>Nota 1</label>");
        out.println("<input type='text' class='form-control' id='campo-nota1' name='Nota 1'>");
        out.println("</div>");
        
        out.println("<div class='form-group'>");
        out.println("<label for='campo-nota2'>Nota 2</label>");
        out.println("<input type='text' class='form-control' id='campo-nota2' name='Nota 2'>");
        out.println("</div>");
        
        out.println("<div class='form-group'>");
        out.println("<label for='campo-nota3'>Nota 3</label>");
        out.println("<input type='text' class='form-control' id='campo-nota2' name='Nota 3'>");
        out.println("</div>");
        
        out.println("<div class='form-group'>");
        out.println("<label for='frequencia'>Frequência</label>");
        out.println("<input type='text' class='form-control' id='frequencia' name='Frequência'>");
        out.println("</div>");
        
        out.println("<input class='btn btn-success' type='submit'  value='Cadastrar'>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

}
