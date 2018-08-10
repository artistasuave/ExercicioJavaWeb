package br.com.practiceMicaJavaWeb.dao;

import br.com.practiceMicaJavaWeb.bean.AlunoBean;
import br.com.practiceMicaJavaWeb.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michelle de Jesus Rogério
 */
public class AlunoDAO {

    /*
     cadastrar/alterar/listar/excluir/calculo média
     */
    public List<AlunoBean> obterTodos() {
        List<AlunoBean> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try {
            Statement st = Conexao.
                    obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {
                AlunoBean aluno = new AlunoBean();
                aluno.setId(resultSet.getInt("id"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setCod_matricula(resultSet.getString("cod_matricula"));
                aluno.setNota1(resultSet.getDouble("nota1"));
                aluno.setNota2(resultSet.getDouble("nota2"));
                aluno.setNota3(resultSet.getDouble("nota3"));
                aluno.setFrequencia(resultSet.getByte("frequencia"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return alunos;
    }

    public AlunoBean obterPeloId(int id) {
        String sql = "SELECT * FROM alunos WHERE id=?";
        try {
            PreparedStatement ps = Conexao.obterConexao().
                    prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute(sql);
            ResultSet resultSet = ps.getResultSet();
            if (resultSet.next()) {
                AlunoBean aluno = new AlunoBean();
                aluno.setId(resultSet.getInt("id"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setCod_matricula(resultSet.getString("cod_matricula"));
                aluno.setNota1(resultSet.getDouble("nota1"));
                aluno.setNota2(resultSet.getDouble("nota2"));
                aluno.setNota3(resultSet.getDouble("nota3"));
                aluno.setFrequencia(resultSet.getByte("frequencia"));
                return aluno;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return null;
    }

    public int adicionar(AlunoBean aluno) {
        String sql = "INSERT INTO alunos (nome, cod_matricula, nota1, nota2, nota3, frequencia)+"
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++, aluno.getNome());
            ps.setString(quantidade++, aluno.getCod_matricula());
            ps.setDouble(quantidade++, aluno.getNota1());
            ps.setDouble(quantidade++, aluno.getNota1());
            ps.setDouble(quantidade++, aluno.getNota1());
            ps.setByte(quantidade++, aluno.getFrequencia());
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return -1;
    }

    public boolean alterar(AlunoBean aluno) {
        String sql = "UPDATE aluno set nome=?, cod_matricula=?, nota1=?, nota2=?, nota3=?,"
                + "frequencia=? WHERE id=?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCod_matricula());
            ps.setDouble(3, aluno.getNota1());
            ps.setDouble(4, aluno.getNota1());
            ps.setDouble(5, aluno.getNota1());
            ps.setByte(6, aluno.getFrequencia());
            ps.setInt(7, aluno.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return false;
    }

    
    
}
