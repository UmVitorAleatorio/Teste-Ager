package br.com.soc.sistema.dao.funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioDao extends Dao {

    public void insertFuncionario(FuncionarioVo funcionarioVo) {
        StringBuilder query = new StringBuilder("INSERT INTO funcionario (nm_funcionario) VALUES (?)");
        try(
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString())){

            int i=1;
            ps.setString(i++, funcionarioVo.getNome());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<FuncionarioVo> findAllFuncionarios() {
        System.out.println("To no find all funcionarios");
        StringBuilder query = new StringBuilder("SELECT rowid id, nm_funcionario nome FROM funcionario");
        try (
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString());
            ResultSet rs = ps.executeQuery()){

            FuncionarioVo vo = null;
            List<FuncionarioVo> funcionarios = new ArrayList<>();
            while(rs.next()){
                vo = new FuncionarioVo();
                vo.setRowid(rs.getString("id"));
                vo.setNome(rs.getString("nome"));

                funcionarios.add(vo);
            }
            return funcionarios;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<FuncionarioVo> findAllByNome(String nome) {
        StringBuilder query = new StringBuilder("SELECT rowid id, nm_funcionario nome FROM funcionario ")
                                .append("WHERE lower(nm_funcionario) like lower(?)");

        try(Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString())){
            int i = 1;

            ps.setString(i, "%"+nome+"%");

            try(ResultSet rs = ps.executeQuery()){
                FuncionarioVo vo = null;
                List<FuncionarioVo> funcionarios = new ArrayList<>();

                while (rs.next()){
                    vo = new FuncionarioVo();
                    vo.setRowid(rs.getString("id"));
                    vo.setNome(rs.getString("nome"));

                    funcionarios.add(vo);
                }
                return funcionarios;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public FuncionarioVo findByCodigo(Integer codigo){
        StringBuilder query = new StringBuilder("SELECT rowid id, nm_funcionario nome FROM funcionario ")
                .append("WHERE rowid = ?");

        try(Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString())){
            int i = 1;

            ps.setInt(i, codigo);

            try(ResultSet rs = ps.executeQuery()){
                FuncionarioVo vo =  null;

                while (rs.next()) {
                    vo = new FuncionarioVo();
                    vo.setRowid(rs.getString("id"));
                    vo.setNome(rs.getString("nome"));
                }
                return vo;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void excluirPorId(Integer cod) {
        StringBuilder query = new StringBuilder("DELETE FROM funcionario ")
                .append(" WHERE rowid = ?");

        try (Connection con = getConexao();
             PreparedStatement ps = con.prepareStatement(query.toString())) {

            int i = 1;
            ps.setInt(i, cod);
            int aff = ps.executeUpdate();

            System.out.println("Número de linhas afetadas: " + aff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFuncionario(FuncionarioVo funcionarioVo) {
        System.out.println("entrou o update");
        StringBuilder query = new StringBuilder("UPDATE funcionario SET nm_funcionario = ? where rowid = ?");

        try(Connection con = getConexao();
            PreparedStatement  ps = con.prepareStatement(query.toString())){

            int i = 1;
            ps.setString(i++, funcionarioVo.getNome());
            ps.setInt(i, Integer.parseInt(funcionarioVo.getRowid()));
            int erw = ps.executeUpdate();

            System.out.println("Número de linhas editadas: " + erw);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
