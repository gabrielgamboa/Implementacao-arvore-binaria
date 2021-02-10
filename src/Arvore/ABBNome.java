//HT3001385
//GABRIEL DE BARROS GAMBÔA

package Arvore;

import Models.Aluno;

public class ABBNome extends ABBPai {

    public ABBNome() {
        this.raiz = null;
    }

    public Aluno remover(String nome) {
        if (this.raiz == null) {
            throw new IllegalArgumentException("Árvore vazia");
        }

        No noRemover = buscarAlunoNome(this.raiz, nome);

        this.raiz = removerNo(this.raiz, noRemover.getElemento().getNome());

        return noRemover.getElemento();

    }

    private No removerNo(No no, String nome) {
        if (no == null) {
            return null;
        }

        if (nome.compareTo(no.getElemento().getNome()) == 0) {
            if (no.folha()) {
                return null;
            } else if (no.apenasFilhoDireita()) {
                return no.getDireita();
            } else if (no.apenasFilhoEsquerda()) {
                return no.getEsquerda();
            } else {
                Aluno maiorNome = obtemMaiorValorNome(no.getEsquerda());
                no.setElemento(maiorNome);
                no.setEsquerda(removerNo(no.getEsquerda(), maiorNome.getNome()));
                return no;
            }
        }

        if (nome.compareTo(no.getElemento().getNome()) < 0) {
            no.setEsquerda(removerNo(no.getEsquerda(), nome));
        } else {
            no.setDireita(removerNo(no.getDireita(), nome));
        }

        return no;
    }

    private Aluno obtemMaiorValorNome(No no) {
        if (no.getDireita() == null) {
            return no.getElemento();
        }

        return obtemMaiorValorNome(no.getDireita());
    }

    public Aluno buscar(String nome) {
        if (this.raiz == null) {
            throw new IllegalArgumentException("Árvore está vazia.");
        } else {
            No no = buscarAlunoNome(this.raiz, nome);
            if (no == null) {
                return null;
            } else {
                return no.getElemento();
            }
        }
    }

    private No buscarAlunoNome(No no, String nome) {
        if (nome.compareTo(no.getElemento().getNome()) < 0) {

            if (no.getEsquerda() != null) {
                return buscarAlunoNome(no.getEsquerda(), nome); 
            } else {
                return null;
            }

        } else if (nome.compareTo(no.getElemento().getNome()) > 0) {
            if (no.getDireita() != null) {
                return buscarAlunoNome(no.getDireita(), nome);
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
        if (aluno.getNome().compareTo(no.getElemento().getNome()) < 0) {
            if (no.getEsquerda() == null) {
                No novoNo = new No(aluno);
                no.setEsquerda(novoNo);
            } else {
                insereNo(no.getEsquerda(), aluno);
            }

        } else if (aluno.getNome().compareTo(no.getElemento().getNome()) > 0) {
            if (no.getDireita() == null) {
                No novoNo = new No(aluno);
                no.setDireita(novoNo);
            } else {
                insereNo(no.getDireita(), aluno);
            }

        } else {
            throw new IllegalArgumentException("Já existe este nome cadastrado no sistema.");
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
            System.out.println(no.getElemento().getNome());
            percorrerPreOrdem(no.getEsquerda());
            percorrerPreOrdem(no.getDireita());
        }
    }

    private void percorrerEmOrdem(No no) {
        if (no != null) {
            percorrerEmOrdem(no.getEsquerda());
            System.out.println(no.getElemento().getNome());
            percorrerPreOrdem(no.getDireita());
        }
    }

    private void percorrerPosOrdem(No no) {
        if (no != null) {
            percorrerPosOrdem(no.getEsquerda());
            percorrerPosOrdem(no.getDireita());
            System.out.println(no.getElemento().getNome());
        }
    }


}
