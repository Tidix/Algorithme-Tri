package tri;

import visualiser.ArrayVisualiser;

/* On parcourt le tableau n fois (taille du tableau) et on place l'élément le plus petit au début à chaque passage */ 
public class BubbleSort extends Tri {
    public BubbleSort () { // executer l'algo sans visualisation (pour cmd ou les tests)
        this(null, 0); 
    }

    public BubbleSort (ArrayVisualiser GUI) {  // Visualisation sans délai
        this(GUI, 0);
    }

    public BubbleSort (ArrayVisualiser GUI, int sleepTime) { // Visualisation avec délai
        super(GUI, sleepTime);
    }

    @Override //fonction de tri
    public void sort(int[] tab) {
        super.changedVector(tab);
        //Parcours du tableau n fois
        for (int i=tab.length; i>0; i--)
            for (int j=1; j<i; j++) {
                if (compare(tab[j], tab[j-1])) {  // Si la valeur est plus petite que l'élément précédent
                    permute(tab, j, j-1); // Permute les deux 
                }
            }
    }
}
