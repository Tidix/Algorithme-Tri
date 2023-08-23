package tri;
import visualiser.ArrayVisualiser;

public class InsertionSort extends Tri{
    // executer l'algo sans visualisation (pour cmd ou les tests)
    public InsertionSort () {
        this(null, 0);
    }

    // Visualisation sans latence
    public InsertionSort (ArrayVisualiser GUI) {
	    this(GUI, 0);
	}

    // Visualisation avec latence
    public InsertionSort (ArrayVisualiser GUI, int sleepTime) {
        super(GUI, sleepTime);
    }

    @Override
    public void sort(int[] tab) {
        int[] tab2 = new int[tab.length];
        int min, k = 0;
        for(int i = 0; i < tab.length; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 0; j < tab.length; j++) {
                if(compare(tab[j], min)) { //tab[j] < min
                    min = tab[j];
                    k = j;
                    costPermute++; //assignation, on force l'incrementation de cost
                }
            }
            costPermute++;
            tab2[i] = min;
            tab[k] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < tab.length; i++){
            tab[i] = tab2[i];
            costPermute++;
        }
        
    }
    
}
