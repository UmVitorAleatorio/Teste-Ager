package br.com.soc.sistema.exception;

public class NaoPodeAdicionarException extends RuntimeException {
    public NaoPodeAdicionarException() {System.out.println("Você não pode adicionar novamente esse exame a este funcionário, para isso altere a data!");
    }
}
