package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;
     

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
         if(taille <= 0) 
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<T>();
        this.capacite = taille;
        
    }

    public Pile2(){
                this(CAPACITE_PAR_DEFAUT);

    }

    public void empiler(T o) throws PilePleineException{
        if(!estVide()){
            throw new PilePleineException();
        }
        this.stk.push(o);
      
    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return this.stk.peek();
    }

    public int capacite(){
         return capacite;
    }
     public int taille(){
         return this.stk.size();
         
    }
       public boolean estVide(){
        return this.stk.empty();
} // Pile2
}