package tri;

import visualiser.ArrayVisualiser;

public class PancakeSort extends Tri{
    // executer l'algo sans visualisation (pour cmd ou les tests)
    public PancakeSort () {
        this(null, 0);
    }

	 public PancakeSort (ArrayVisualiser GUI) { // Visualisation sans délai
	    this(GUI, 0);
	}

	public PancakeSort (ArrayVisualiser GUI, int sleepTime) { // Visualisation avec délai
	    super(GUI, sleepTime);
	}


	@Override //fonction de tri, utilisation d'une pile que l'on permute et retourne
	public void sort(int[] tab) {
		pancaking(tab);
	}

    public int max(int[] tab,int size){ 
        int imax = 0;
        for(int i = 1; i < size; i++)
            if(compare(tab[imax], tab[i])) //comparaison
                imax = i;
        return imax;
    }
    public void reverse(int[] tab,int size){ //rotation de la piles
        for(int i = 0; i < size ; i++ , size--)
			permute(tab, i, size);
    }
    //Résoltion
    public void pancaking(int[] tab){
        for(int len = tab.length; len>=1; len--){
            int max = max(tab, len);
            if(max != len){
                reverse(tab, max);
                reverse(tab, len-1);
            }
        }

    }
	
	
}
	