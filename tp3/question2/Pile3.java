package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {
    

	private Vector<Object> v;
        private int capacite;
	public Pile3() {
		this(CAPACITE_PAR_DEFAUT);
	}

	public Pile3(int taille) {
		if (taille <= 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT; 
    }
        capacite = taille;
            v = new Vector <Object>();
    
	}

	public void empiler(Object o) throws PilePleineException {
        if (o == null) throw new IllegalArgumentException("null inserted");
        if (estPleine())  throw new PilePleineException(); 
        v.addElement(o);
	}

	public Object depiler() throws PileVideException {
	     Object last = sommet();
             v.remove(last);
              return last;
	}

	public Object sommet() throws PileVideException {
           if (estVide()) throw new PileVideException();
           return v.lastElement() ;
	}

	public int taille() {
		// à compléter
		 return v.size();
	}

	public int capacite() {
		// à compléter
		return v.capacity();
	}

	public boolean estVide() {
		// à compléter
		 return v.isEmpty();
	}

	public boolean estPleine() {
		// à compléter
		return v.size() == v.capacity();
	}

	public String toString() {
		// à compléter
		StringBuffer string = new StringBuffer("[");
           for (int i = 0; i <v.size() - 1; i++) {
            Object element = v.elementAt(i);
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
             Pile3 p = (Pile3)o;
        if (o instanceof Pile3) {
            
            if( capacite() == p.capacite() && taille() == p.taille()){
            egale =true ;
        }
            if (egale) {
                for (int i = 0; i <v.size() - 1; i++) {
                    
                    Object elementpile1 = this.v.elementAt(i);
                    Object elementpile2 = p.v.elementAt(i);
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

}
