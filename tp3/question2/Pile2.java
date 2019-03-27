package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille <= 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT; 
    }
     capacite = taille;
        stk = new Stack <Object>();
    
    }

    // constructeur fourni
    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
       if (o == null) throw new IllegalArgumentException("null inserted");
      
        if (estPleine())  throw new PilePleineException();
        
        stk.push(o);
    }

    public Object depiler() throws PileVideException {
          if (estVide()) throw new PileVideException();
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide()) throw new PileVideException();
        return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
        return stk.isEmpty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
         return stk.size() == capacite;   
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
     StringBuffer string = new StringBuffer("[");
        for (int i = 0; i <stk.size() - 1; i++) {
            Object element = stk.elementAt(i);
            if (element != null) {
                string.append(element.toString());
                    string.append(", ");
                }
            }
        
        string.append("]");
        return string.toString();
    }

    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
            boolean egale = false;
             Pile2 p = (Pile2)o;
        if (o instanceof Pile) {
            
            if( capacite() == p.capacite() && taille() == p.taille()){
            egale =true ;
        }
            if (egale) {
                for (int i = 0; i <stk.size() - 1; i++) {
                    
                    Object elementpile1 = this.stk.elementAt(i);
                    Object elementpile2 = p.stk.elementAt(i);
                    if (elementpile1 != null) {
                        egale &= elementpile1.equals(elementpile2);
                    } else {
                        egale = false;
                    }                   
                    if (!egale) {
                       
                        break;
                    }
                }
            }
        }
        return egale;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
      return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
         return capacite; 
    }

} // Pile2.java
