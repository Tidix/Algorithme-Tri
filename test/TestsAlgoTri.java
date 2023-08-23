package tests;
import Generateur.*;
import tri.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import org.junit.Assertions.*;
//import org.junit.Test;

/* Classe de test pour les sorties de chaque algorithme 
   On vérifie que le tableau retourner est trié avec une méthode isSorted(int[] tab) */
class TestsAlgoTri {

	//init tableau 100

    int tailletab   =     100;
    int entropy     =     10000;
    boolean reverse =     false;

    int[] tab = new Tab().createTable(tailletab);
 
    
    @Test
    public void TestBogoSort(){
    	new BogoSort(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
    
    
    @Test
    public void TestBubbleSort(){
    	new BubbleSort(null,0).sort(tab);
        assertTrue(isSorted(tab));  
    }
    
    
    @Test
    public void TestQuickSort(){
    	new QuickSort(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
    
    
    @Test
    public void TestShakerSort(){
    	new ShakerSort(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
   
    
    @Test
    public void TestShellSort(){
    	new ShellSort(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
    
    
    @Test
    public void TestFusionSort(){
    	new TriFusion(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
   
    
    @Test
    public void TestHeapSort(){
    	new HeapSort(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
    
    
    @Test
    public void TestPancakeSort(){
    	new PancakeSort(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
    
    
    @Test
    public void TestCombSort(){
    	new CombSort(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
    
    
    @Test
    public void TestRadixSort(){
    	new Radix(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
    
    
    @Test
    public void TestInsertionSort(){
    	new InsertionSort(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
    
    
    @Test
    public void TestGnomeSort(){
    	new GnomeSort(null,0).sort(tab);
        assertTrue(isSorted(tab));
    }
    
    
    
    
    // Vérifie que le tableau est trié
    public static boolean isSorted (int[] tab) {

        for (int i=1; i<tab.length; i++)

            if (tab[i-1] > tab[i]) return false;

        return true;

    }
}
