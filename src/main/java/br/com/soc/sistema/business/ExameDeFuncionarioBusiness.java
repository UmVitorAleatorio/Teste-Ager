package br.com.soc.sistema.business;

import br.com.soc.sistema.dao.exames_funcionarios.ExameDeFuncionarioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.exception.NaoPodeAdicionarException;
import br.com.soc.sistema.exception.NaoPodeExcluirException;
import br.com.soc.sistema.filter.ExameDeFuncionarioFilter;
import br.com.soc.sistema.vo.ExameDeFuncionarioVo;
import br.com.soc.sistema.vo.ExamesDeFuncionarioVo;
import br.com.soc.sistema.vo.FuncionarioVo;

import java.time.LocalDate;
import java.util.List;

public class ExameDeFuncionarioBusiness {

    private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
    private ExameDeFuncionarioDao dao;

    public ExameDeFuncionarioBusiness() {
        this.dao = new ExameDeFuncionarioDao();
    }

    public ExamesDeFuncionarioVo trazerTodosOsExamesDeFuncionario(ExameDeFuncionarioFilter examesDeFuncionarioFiltro){
        return dao.listarExamesDeFuncionario(examesDeFuncionarioFiltro.getFuncionario().getId());
    }

    public void verificarData(ExameDeFuncionarioVo exameDeFuncionarioVo, FuncionarioVo funcionarioVo) {
        try {
            dao.selectParaAdicionar(exameDeFuncionarioVo, funcionarioVo);
        }catch (NaoPodeAdicionarException e){
            throw new NaoPodeExcluirException();
        }
    }

    public void salvarExame(ExameDeFuncionarioVo exameDeFuncionarioVo, FuncionarioVo funcionarioVo) {
        try {
            if(funcionarioVo.getNome().isEmpty())
                throw new IllegalArgumentException("Nome nao pode ser em branco");

            dao.insertExame(exameDeFuncionarioVo, funcionarioVo);
        } catch (Exception e) {
            throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
        }
    }

    public void editarExame(ExameDeFuncionarioVo exameDeFuncionarioVo, String idIntenoExameEditar) {
        try {
            if(idIntenoExameEditar == null || idIntenoExameEditar.isEmpty())
                throw new IllegalArgumentException("Nome nao pode ser em branco");

            dao.editarExame(exameDeFuncionarioVo, idIntenoExameEditar);
        }catch (Exception e) {
            throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
        }
    }

    public void excluirExame(String idIntenoExameExcluir) {
        try {
            if(idIntenoExameExcluir == null || idIntenoExameExcluir.isEmpty())
                throw new IllegalArgumentException("Nome nao pode ser em branco");

            dao.excluirExame(idIntenoExameExcluir);
        }catch (Exception e) {
            throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
        }
    }

    public List<ExameDeFuncionarioVo> listarTodos() {
        return dao.listarTodos();
    }

    public List<ExameDeFuncionarioVo> buscarTodosEntreDatas(LocalDate de, LocalDate ate) {
        return dao.buscarTodosEntreDatas(de,ate);
    }

}
