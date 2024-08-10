package br.com.soc.sistema.exception;

public class NaoPodeExcluirException extends RuntimeException {
    public NaoPodeExcluirException() { System.out.println("Você não pode excluir esse exame por que tem funcionarios ligados a ele!");
    }
}

