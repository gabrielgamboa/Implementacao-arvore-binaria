//HT3001385
//GABRIEL DE BARROS GAMBÔA

package Arvore;

import Models.Aluno;

public abstract class ABBPai {
    public No raiz;

    public void inserirRaiz(Aluno aluno) {
        this.raiz = new No(aluno);
    }

    public abstract void imprimirPreOrdem();
    public abstract void imprimirEmOrdem();
    public abstract void imprimirPosOrdem();

    


}
