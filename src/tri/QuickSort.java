package tri;

import visualiser.ArrayVisualiser;

public class QuickSort extends Tri{
	// executer l'algo sans visualisation (pour cmd ou les tests)
	public QuickSort () {
        this(null, 0);
    }
	// Visualisation sans délai
	 public QuickSort (ArrayVisualiser GUI) {
	    this(GUI, 0);
	}
	// Visualisation avec délai
	public QuickSort (ArrayVisualiser GUI, int sleepTime) {
	    super(GUI, sleepTime);
	}

	/**
		On commence le sort avec la premiere et derniere valeurs du tableau
	 */
	@Override
	public void sort(int[] tab) {
		changedVector(tab);
		quicksort(tab, 0, tab.length-1);
	}
	
	/**
		Il nous faut un anchor pour partitioner le tableau, on prend le plus a gauche possible
		Apres avoir l'index a sa place, on trie la partie gauche et droite du tableau jusqu'a ce que le tableau soit
		entierement trie
	 */
	public int[] quicksort(int[] tab, int gauche, int droite) {
		if(gauche < droite) {
			int index = partition(tab,gauche,droite);
			quicksort(tab, index+1, droite);
			quicksort(tab, gauche, index-1);
		}
		
		return tab;
	}
		
	/**
		On repartie le tableau en 2, le cote gauche est plus petit que l'anchor et a droite est plus grand
		une fois que les 2 parties sont faites, l'anchor est a sa place finale et donc on renvoit donc son index
		pour plus tard trier le tab de gauche puis de droite
	 */
	public int partition(int[] tab, int gauche, int droite) {
		int pivot = tab[droite];
		int i = gauche-1;
		for(int j = gauche; j<droite; j++) {
			if(compare(tab[j], pivot)) {
				i+=1;	
				permute(tab,i,j);
			}
		}
		permute(tab,droite,i+1);
		return i+1;
	}
}
	