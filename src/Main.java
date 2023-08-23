import javax.swing.JFrame;

import tri.*;

import visualiser.ArrayVisualiser;

import Generateur.*;

public class Main {

    public static void main(String[] args) {

        //init tableau

        int tailletab   =     100;
        int entropy     =     10000;
        boolean reverse =     false;


        int[] tab = new Tab().createTable(tailletab); //création tableau

        if(reverse)
            Tab.reverseTab(tab);
        else {
            Tab.shuffleTable(tab, entropy);
        }

        ArrayVisualiser panel = new ArrayVisualiser(tab); //init JPanel

        JFrame window = new JFrame(); //init JFrame

        window.add(panel); //ajout du JPanel dans le JFrame

        window.setExtendedState(JFrame.MAXIMIZED_BOTH); //taille max interface

        window.setVisible(true); //visu

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit

        

        /* UTILISATION : choisir un des algo suivants et mettre les autres sous commentaires
        on ne modifira que le délai, on touche pas au panel ni au sort.



        /******* complexité moyenne nlogn **********/

        new HeapSort(panel, 100).sort(tab);

        //new QuickSort(panel,100).sort(tab);

        //new TriFusion(panel,100).sort(tab);

        
        /******* complexité moyenne n² **********/

        //new BubbleSort(panel,20).sort(tab);

        //new ShakerSort(panel,10).sort(tab);

        //new InsertionSort(panel,10).sort(tab);

        //new CombSort(panel,100).sort(tab);

        //new GnomeSort(panel,100).sort(tab);

        //new ShellSort(panel,100).sort(tab);

        //new PancakeSort(panel, 10).sort(tab);

        /****** autres ******/

        //new BogoSort(panel,10).sort(tab);

        //new Radix(panel,100).sort(tab);

    }

    /*******************************************************************/

    //méthode de vérification si l'algo est bien trié
    public static boolean isSorted (int[] tab) {

        for (int i=1; i<tab.length; i++)

            if (tab[i-1] > tab[i]) return false;

        return true;

    }

}
