package ArvoreBuscaBinaria;

/**
 *
 * @author Bruna Jodai
 */
public class ABB {

    NoArvore raiz;

    public ABB() {
        raiz = null;
    }

    //inserção do nó
    public void inserirNo(int d, String nom) {
        NoArvore novo = new NoArvore(d, nom);

        if (raiz == null) {
            raiz = novo;

        } else {
            NoArvore auxiliar = raiz;
            NoArvore pai;

            while (true) {
                pai = auxiliar;
                if (d < auxiliar.dado) {
                    auxiliar = auxiliar.FilhoEsquerdo;
                    if (auxiliar == null) {
                        pai.FilhoEsquerdo = novo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.FilhoDireito;
                    if (auxiliar == null) {
                        pai.FilhoDireito = novo;
                        return;
                    }
                }
            }
        }
    }

    //busca do nó
    public NoArvore buscarNo(int d) {
        NoArvore aux = raiz;

        while (aux.dado != d) {
            if (d < aux.dado) {
                aux = aux.FilhoEsquerdo;
            } else {
                aux = aux.FilhoDireito;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }

    //remoção de um elemento e re-organização da árvore
    public boolean remover(int d) {
        NoArvore aux = raiz;
        NoArvore pai = raiz;
        boolean F_esquerdo = true;
        while (aux.dado != d) {
            pai = aux;
            if (d < aux.dado) {
                F_esquerdo = true;
                aux = aux.FilhoEsquerdo;
            } else {
                F_esquerdo = true;
                aux = aux.FilhoDireito;
            }
            if (aux == null) {
                return false;
            }
        }//fim do while
        
        //remove nó folha
        if (aux.FilhoEsquerdo == null && aux.FilhoDireito == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (F_esquerdo) {
                pai.FilhoEsquerdo = null;
            } else {
                pai.FilhoDireito = null;
            }
            
        //remove nó com filho na esquerda
        } else if (aux.FilhoDireito == null) {
            if (aux == raiz) {
                raiz = aux.FilhoEsquerdo;
            } else if (F_esquerdo) {
                pai.FilhoEsquerdo = aux.FilhoEsquerdo;
            } else {
                pai.FilhoDireito = aux.FilhoDireito;
            }
            
        //remove nó com filho na direita  
        } else if (aux.FilhoEsquerdo == null) {
            if (aux == raiz) {
                raiz = aux.FilhoDireito;
            } else if (F_esquerdo) {
                pai.FilhoEsquerdo = aux.FilhoDireito;
            } else {
                pai.FilhoDireito = aux.FilhoEsquerdo;
            }

        //remove nó com 2 filhos
        } else {
            NoArvore rePlantar = ObterNoRePlantar(aux);

            if (aux == raiz) {
                raiz = rePlantar;
            } else if (F_esquerdo) {
                pai.FilhoEsquerdo = rePlantar;
            } else {
                pai.FilhoDireito = rePlantar;
            }
            rePlantar.FilhoEsquerdo = aux.FilhoEsquerdo;
            
        }
        return true;
    }

    //re-aloca a folha, quando um nó com dois filhos é removido
    public NoArvore ObterNoRePlantar(NoArvore NoRe) {
        NoArvore rePlantarPai = NoRe;
        NoArvore rePlantar = NoRe;
        NoArvore aux = NoRe.FilhoDireito;

        while (aux != null) {
            rePlantarPai = rePlantar;
            rePlantar = aux;
            aux = aux.FilhoEsquerdo;
        }
        if (rePlantar != NoRe.FilhoDireito) {
            rePlantarPai.FilhoEsquerdo = rePlantar.FilhoDireito;
            rePlantar.FilhoDireito = NoRe.FilhoDireito;
        }
        System.out.println("O nó replantado é " + rePlantar);
        return rePlantar;
    }

}
