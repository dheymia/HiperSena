package senac.hipersena.models;

public class Aposta {

    private String conteudo;

    public Aposta(String conteudo){
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    @Override
    public String toString() {
        return "Aposta{" +
                "conteudo='" + conteudo + '\'' +
                '}';
    }
}
