//HT3001385
//GABRIEL DE BARROS GAMBÔA

package Arvore;

import Models.Aluno;

public class ABBProntuario extends ABBPai {

    public ABBProntuario() {
        this.raiz = null;
    }

    public Aluno remover(int prontuario) {
        if (this.raiz == null) {
            throw new IllegalArgumentException("Árvore vazia");
        }

        No noRemover = buscarAlunoProntuario(this.raiz, prontuario);

        this.raiz = removerNo(this.raiz, noRemover.getElemento().getProntuario());

        return noRemover.getElemento();

    }

    private No removerNo(No no, int prontuario) {
        if (no == null) {
            return null;
        }

        if (prontuario == no.getElemento().getProntuario()) {
            if (no.folha()) {
                return null;
            } else if (no.apenasFilhoDireita()) {
                return no.getDireita();
            } else if (no.apenasFilhoEsquerda()) {
                return no.getEsquerda();
            } else {
                Aluno maiorProntuario = obtemMaiorValorProntuario(no.getEsquerda());
                no.setElemento(maiorProntuario);
                no.setEsquerda(removerNo(no.getEsquerda(), maiorProntuario.getProntuario()));
                return no;
            }
        }

        if (prontuario < no.getElemento().getProntuario()) {
            no.setEsquerda(removerNo(no.getEsquerda(), prontuario));
        } else {
            no.setDireita(removerNo(no.getDireita(), prontuario));
        }

        return no;
    }

    private Aluno obtemMaiorValorProntuario(No no) {
        if (no.getDireita() == null) {
            return no.getElemento();
        }

        return obtemMaiorValorProntuario(no.getDireita());
    }


    public Aluno buscar(int prontuario) {
        if (this.raiz == null) {
            throw new IllegalArgumentException("Árvore está vazia.");
        } else {
            No no = buscarAlunoProntuario(this.raiz, prontuario);
            return no.getElemento();
        }
    }

    private No buscarAlunoProntuario(No no, int prontuario) {
        if (prontuario < no.getElemento().getProntuario()) {
            
            if (no.getEsquerda() != null) {
                return buscarAlunoProntuario(no.getEsquerda(), prontuario); 
            } else {
                return null;
            }

        } else if (prontuario > no.getElemento().getProntuario()) {
            if (no.getDireita() != null) {
                return buscarAlunoProntuario(no.getDireita(), prontuario);
            } else {
                return null;
            }
            
        } else {
            return no;
        }
    }

    public void inserir(Aluno aluno) {
        if (this.raiz == null) {
            inserirRaiz(aluno);
        } else {
            insereNo(this.raiz, aluno);
        }
    }

    private void insereNo(No no, Aluno aluno) {
        if (aluno.getProntuario() < no.getElemento().getProntuario()) {
            if (no.getEsquerda() == null) {
                No novoNo = new No(aluno);
                no.setEsquerda(novoNo);
            } else {
                insereNo(no.getEsquerda(), aluno);
            }

        } else if (aluno.getProntuario() > no.getElemento().getProntuario()) {
            if (no.getDireita() == null) {
                No novoNo = new No(aluno);
                no.setDireita(novoNo);
            } else {
                insereNo(no.getDireita(), aluno);
            }

        } else {
            throw new IllegalArgumentException("Este prontuário já existe, não é possível utilizá-lo.");
        }
    } 


    public void imprimirPreOrdem() {
        percorrerPreOrdem(this.raiz);
    }

    public void imprimirEmOrdem() {
        percorrerEmOrdem(this.raiz);
    }

    public void imprimirPosOrdem() {
        percorrerPosOrdem(this.raiz);
    }

    private void percorrerPreOrdem(No no) {
        if (no != null) {
            System.out.println(no.getElemento().getProntuario());
            percorrerPreOrdem(no.getEsquerda());
            percorrerPreOrdem(no.getDireita());
        }
    }

    private void percorrerEmOrdem(No no) {
        if (no != null) {
            percorrerEmOrdem(no.getEsquerda());
            System.out.println(no.getElemento().getProntuario());
            percorrerPreOrdem(no.getDireita());
        }
    }

    private void percorrerPosOrdem(No no) {
        if (no != null) {
            percorrerPosOrdem(no.getEsquerda());
            percorrerPosOrdem(no.getDireita());
            System.out.println(no.getElemento().getProntuario());
        }
    }
}
