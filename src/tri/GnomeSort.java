package tri;

import visualiser.ArrayVisualiser;

//Variation du tri par Insertion
public class GnomeSort extends Tri{
	// executer l'algo sans visualisation (pour cmd ou les tests)
	public GnomeSort () {
        this(null, 0);
    }

	public GnomeSort (ArrayVisualiser GUI) { // Visualisation sans délai
		this(GUI, 0);
	}

	public GnomeSort (ArrayVisualiser GUI, int sleepTime) { // Visualisation avec délai
		super(GUI, sleepTime);
	}

	@Override //fonction de tri
	public void sort(int[] tab) {
		changedVector(tab);
		int tmp = 1;
		while(tmp < tab.length) { //On exécute jusqu'à ce qu'on ait traversé tout les élements du tableau
			if(compare(tab[tmp-1], tab[tmp])) { //Comparaison
				tmp++;
			}
			else {
				permute(tab,tmp,tmp-1); // Permutation
				if(tmp>1) {
					tmp--;
				}
			}	
		}
		
	}
}
