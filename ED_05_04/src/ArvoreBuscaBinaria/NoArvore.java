package ArvoreBuscaBinaria;

/**
 *
 * @author Bruna Jodai
 */
public class NoArvore {

    int dado;
    String nome;
    NoArvore FilhoEsquerdo, FilhoDireito;

    public NoArvore(int d, String nom) {
        this.dado = d;
        this.nome = nom;
        this.FilhoDireito = null;
        this.FilhoEsquerdo = null;
    }
}
