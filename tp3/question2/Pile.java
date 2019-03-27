package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if(taille <= 0) {
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;

    }

    public Pile() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
          if (estPleine()){
            throw new PilePleineException();
        }
           this.zone[this.ptr] = o;
            this.ptr++;    }

    public Object depiler() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        this.ptr--;
        return zone[ptr];
        
    }

    public Object sommet() throws PileVideException {
          if(estVide()){
            throw new PileVideException();
        }
        return zone[ptr-1];
       
    }

    public int capacite() {
        return zone.length;
        
    }

    public int taille() {
        return ptr;
    }

    public boolean estVide() {
        // a completer
        return ptr == 0;
    }

    public boolean estPleine() {
        // a completer
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        // a completer
        if(o == null){
            return false;
        }
        boolean egale = false;
        if (o instanceof Pile) {
            Pile p = (Pile)o;
            if( capacite() == p.capacite() && taille() == p.taille()){
            egale =true ;
        }
            if (egale) {
                for (int i = 0; i <ptr - 1; i++) {
                    
                    Object elementpile1 = zone[i];
                    Object elementpile2 = p.zone[i];
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

    public String toString() {
       StringBuffer string = new StringBuffer("[");
        for (int i = 0; i <ptr - 1; i++) {
            Object element = zone[i];
            if (element != null) {
                string.append(element.toString()); 
                    string.append(", ");

            }
        }
        string.append("]");
        return string.toString();
    }
    }
