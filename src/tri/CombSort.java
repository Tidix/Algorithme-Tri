package tri;

import visualiser.ArrayVisualiser;

// Amélioration du tri à bulles
// Le but est de comparer un éléménent avec un autre plus lointain  
public class CombSort extends Tri{
    // executer l'algo sans visualisation (pour cmd ou les tests)
    public CombSort () {
        this(null, 0); 
    }

    public CombSort (ArrayVisualiser GUI) {  // Visualisation sans délai
		this(GUI, 0);
	}

	public CombSort (ArrayVisualiser GUI, int sleepTime) { // Visualisation avec délai
		super(GUI, sleepTime);
	}

    @Override //fonction de tri
    public void sort(int[] tab) {
        changedVector(tab);
        int length = tab.length;
        int gap = length; //Initialisation du gap

        float shrink = 1.3f;
        boolean sorted = false;

        while (gap > 1 || sorted){ // Tant que l'algo n'est pas trié

            gap = (int) Math.floor(gap/shrink);

            if (gap<1) {
                gap = 1;
            }

            sorted = false; // Tant qu'il n'est pas trié, on continue

            for (int i = 0; i< tab.length-gap;i++){ 
                if (tab[i]>tab[i+gap]){ // Compare entre les deux éléments 
                    permute(tab, i, i+gap); //Permutation
                    sorted = true;
                }
            } 
        }
    }
    
}
