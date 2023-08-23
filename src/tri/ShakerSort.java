package tri;

import visualiser.ArrayVisualiser;

/* Variante du tri BubbleSort 
  permute les éléments en parcourant dans l'ordre croissant puis décroissant. */ 

public class ShakerSort extends Tri{
	// executer l'algo sans visualisation (pour cmd ou les tests)
	public ShakerSort () {
        this(null, 0);
    }

	// Visualisation sans délai
	public ShakerSort (ArrayVisualiser GUI) {
		this(GUI, 0);
	}

	// Visualisation avec délai
	public ShakerSort (ArrayVisualiser GUI, int sleepTime) {
		super(GUI, sleepTime);
	}
	@Override
	public void sort(int[] tab) {
		//Init variables
		changedVector(tab);
		boolean changed = true;
		int debut = 0;
		int fin = tab.length-1;
		while(changed == true) {
			//Aucun changement pour le moment
			changed = false;
			//passage croissant
			for(int i=debut; i<fin-1; i++) {
				// on permute les éléments si x > y
				if(compare(tab[i+1], tab[i])){
					permute(tab, i, i+1);
					// Il y a eu une permutation donc on recommence
					changed = true;
				}
			}
			
			//passage décroissant
			for(int i = fin; i>debut; i+=-1) {
				//On permute les éléments si x < y
				if(compare(tab[i], tab[i-1])){
					permute(tab, i, i-1);
					// Il y a eu une permutation donc on recommence
					changed = true;
				}
			}
			// On actualise les bornes de passage
			debut+=1;
			fin+=-1;
		}
	}

}
