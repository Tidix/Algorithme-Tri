package tri;

import visualiser.ArrayVisualiser;

// algo qui permet l'échange d'éléments éloignés 
public class ShellSort extends Tri {
    // executer l'algo sans visualisation (pour cmd ou les tests)
    public ShellSort () {
        this(null, 0);
    }
	 // Visualisation sans délai
	 public ShellSort (ArrayVisualiser GUI) {
	        this(GUI, 0);
	    }

	    public ShellSort (ArrayVisualiser GUI, int sleepTime) { // Visualisation avec délai
	        super(GUI, sleepTime);
	    }

        @Override //Tri par comparaison, parcours du tableau de gauche à droite jusqu'a que tout sois trié
    public void sort(int[] tab) { //fonction de tri
        super.changedVector(tab);
        int lgth = tab.length;
        for (int gap = lgth; gap > 0; gap = Math.round(gap / 2)) {
            for (int i = gap; i < lgth; i++) {
                int k = tab[i];
                int j;
                for (j = i; compare(gap, j+1) && compare(k, tab[j - gap]); j -= gap) { // On permute 
                    tab[j] = tab[j - gap];
                    costPermute++;
                }
                tab[j] = k;
                costPermute++; // On force l'instantation
                super.refresh();
            }
        }
    }
}