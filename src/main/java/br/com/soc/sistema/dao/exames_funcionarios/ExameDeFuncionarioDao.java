package br.com.soc.sistema.dao.exames_funcionarios;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.filter.ExameDeFuncionarioFilter;
import br.com.soc.sistema.vo.ExameDeFuncionarioVo;
import br.com.soc.sistema.vo.ExamesDeFuncionarioVo;
import br.com.soc.sistema.vo.FuncionarioVo;

import java.sql.*;
import java.time.LocalDate;

public class ExameDeFuncionarioDao extends Dao {

    public ExamesDeFuncionarioVo listarExamesDeFuncionario(Integer funcionarioId) {
        StringBuilder query = new StringBuilder("SELECT * FROM v_exames_do_funcionario")
                .append(" WHERE funcionario_id = ?");
        try (
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())) {

            int i = 1;
            System.out.println("SQL param id func: " + funcionarioId);
            ps.setInt(i++, funcionarioId);
//            ps.setString(i, "%" + examesDeFuncionarioFiltro.getValorBusca() + "%"); // depois verificar filtragem se necessario

            try (ResultSet rs = ps.executeQuery()) {
                ExamesDeFuncionarioVo vo = new ExamesDeFuncionarioVo();

                while (rs.next()) {
                    if (vo.getFuncionarioVo() == null) {
                        FuncionarioVo funcionarioVo = new FuncionarioVo();
                        funcionarioVo.setNome(rs.getString("funcionario_nome"));
                        funcionarioVo.setRowid(rs.getString("funcionario_id"));
                        vo.setFuncionarioVo(funcionarioVo);
                    }


                    ExameDeFuncionarioVo exameDeFuncionarioVo = new ExameDeFuncionarioVo();
                    exameDeFuncionarioVo.setInternoId(rs.getString("interno_id"));
                    exameDeFuncionarioVo.setNome(rs.getString("exame_nome"));
                    exameDeFuncionarioVo.setRowid(rs.getString("exame_id"));
                    exameDeFuncionarioVo.setData(rs.getString("data"));

                    vo.getExamesVo().add(exameDeFuncionarioVo);
                }

                System.out.println("Consulta realizada com dados: " + vo);
                return vo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Sem exames do funcionario");
        return new ExamesDeFuncionarioVo();
    }

    public void insertExame(ExameDeFuncionarioVo exameDeFuncionarioVo, FuncionarioVo funcionarioVo) {
        System.out.println(funcionarioVo);
        StringBuilder query = new StringBuilder("INSERT INTO exame_funcionario (exame_id, funcionario_id, data) VALUES (?, ?, ?)");
        try(
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())){

            int i = 1;
                ps.setInt(i++, Integer.parseInt(exameDeFuncionarioVo.getRowid()));
                ps.setInt(i++, Integer.parseInt(funcionarioVo.getRowid()));
                ps.setDate(i, Date.valueOf(exameDeFuncionarioVo.getData()));

            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarExame(ExameDeFuncionarioVo exameDeFuncionarioVo,String idIntenoExameEditar) {
        StringBuilder query = new StringBuilder("UPDATE exame_funcionario SET data = ? where rowid = ?");
        try (
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())){

            int i = 1;
            ps.setDate(i++, Date.valueOf(exameDeFuncionarioVo.getData()));
            ps.setInt(i, Integer.parseInt(idIntenoExameEditar));
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void excluirExame(String idIntenoExameExcluir) {
        StringBuilder query = new StringBuilder("DELETE FROM exame_funcionario WHERE rowid = ?");
        try (
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())){

            ps.setInt(1, Integer.parseInt(idIntenoExameExcluir));
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
