package tri;

import visualiser.ArrayVisualiser;

/* 
    On mélange aléatoirement les éléments dans le tableau jusqu'à obtenir un tableau trié.
*/
public class BogoSort extends Tri {
    public BogoSort () {
        this(null, 0); // executer l'algo sans visualisation (pour cmd ou les tests)
    }

	public BogoSort (ArrayVisualiser GUI) { // Visualisation sans délai
	    this(GUI, 0);
	}

	public BogoSort (ArrayVisualiser GUI, int sleepTime) { // Visualisation avec délai 
	    super(GUI, sleepTime);
	}
	   
    @Override   //fonction de tri
    public void sort(int[] tab) {  
        super.changedVector(tab);
        while (true) {
            boolean sorted = true;
            /* On vérifie si le tableau est trié. 
               On sort de la boucle si trié, sinon on mélange le tableau. */
            for (int i=1; i<tab.length; i++)
                if (compare (tab[i], tab[i-1])) {
                    sorted = false;
                    break;
                }
            if (sorted) break;
            // mélange aléatoire du tableau
            for (int i=0; i<2*tab.length; i++) {
                int rdm1 = (int) (Math.random() * tab.length);
                int rdm2 = (int) (Math.random() * tab.length);
                permute(tab, rdm1, rdm2);
            }
        }
    }
}
