package br.com.practiceMicaJavaWeb.dao;

import br.com.practiceMicaJavaWeb.bean.AlunoBean;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 * @author Michelle de Jesus Rogério
 */
public class AlunoDAO {

    public List<AlunoBean> obterTodos() {
        List<AlunoBean> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try {

        }
    }
}
