package tri;

import visualiser.ArrayVisualiser;

public class HeapSort extends Tri {
    // executer l'algo sans visualisation (pour cmd ou les tests)
    public HeapSort () {
        this(null, 0);
    }

    public HeapSort(ArrayVisualiser GUI) { // Visualisation sans délai
        this(GUI, 0);
    }

    public HeapSort(ArrayVisualiser GUI, int sleepTime){ // Visualisation avec délai
        super(GUI,sleepTime);
    }

    @Override //fonction de tri
    public void sort(int[] tab) {
        super.changedVector(tab);
        int size = tab.length;
        for (int root = (int) Math.floor(size / 2) - 1; root >= 0; root--) {
            heapify(tab, size, root);
        }
        for (int j = size - 1; j >= 0; j--) {
            permute(tab, 0, j); 
            heapify(tab, j, 0);
        }

    }
    /*
     * Fonction de tamisage des noeuds
     * Si un élement ne correspond pas à la propriété, il est echangé avec le noeud du haut.
     *      Un noeud plus grand que son parent est inversé avec ce parent
     *      
     */
    private void heapify(int[] tab, int size, int root) {
        int k = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (compare(left, size) && compare(tab[k], tab[left])) {
            k = left;
        }
        if (compare(right, size) && compare(tab[k], tab[right])) {
            k = right;
        }

        if (k != root) {
            permute(tab, k, root);
            heapify(tab, size, k);
        }
    }

}
