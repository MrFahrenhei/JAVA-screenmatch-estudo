package br.com.alura.screenmatch.excecao;

public class ErroConvertionYear extends RuntimeException {
    private String message;
    public ErroConvertionYear(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
