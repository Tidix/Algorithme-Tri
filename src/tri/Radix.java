package tri;

import visualiser.ArrayVisualiser;

public class Radix extends Tri {
    // executer l'algo sans visualisation (pour cmd ou les tests)
    public Radix () {
        this(null, 0);
    }

    // Visualisation sans délai
    public Radix (ArrayVisualiser GUI) {
		this(GUI, 0);
	}

    // Visualisation avec délai
	public Radix (ArrayVisualiser GUI, int sleepTime) {
		super(GUI, sleepTime);
	}
    @Override
    public void sort(int[] tab) {
        int[] tmpTab = new int[tab.length];
        int[] newTabPointer = tmpTab;
        int[] oldTabPointer = tab;
        int[] counter = new int[256];
        int[] indices = new int[256];
        for (int i=0; i<4; i++) {
            //count elements in selected "bit zone"
            for (int j=0; j<newTabPointer.length; j++)
                counter[(oldTabPointer[j] >> (8*i)) & 0xFF]++;   
            //convert counts to indices
            for (int j=1; j<counter.length; j++)
                indices[j] = indices[j-1] + counter[j-1];
            //write onto to vector based on indices
            for (int j=0; j<newTabPointer.length; j++) {
                newTabPointer[indices[(oldTabPointer[j] >> (8*i)) & 0xFF]] = oldTabPointer[j];
                indices[(oldTabPointer[j] >> (8*i)) & 0xFF]++;
            }
            //switch vectors and reinit counters
            newTabPointer = newTabPointer == tab ? tmpTab : tab;
            oldTabPointer = oldTabPointer == tab ? tmpTab : tab;
            for (int j=0; j<counter.length; j++) counter[j] = 0;
            for (int j=0; j<indices.length; j++) indices[j] = 0;
        }
    }
}
