import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Constructor;

import Generateur.Tab;
import tri.*;

public class MainCalc {
private static final int[] sizes = {10, 100, 1000};
    private static final String[] shuffleTypes = {"normal", "faible_entropie", "faible_entropie_inverse", "fin_non_trie"};
        private static final String[] sorts = {"BubbleSort", "CombSort", "GnomeSort",
                                                "HeapSort", "InsertionSort", "PancakeSort", "QuickSort", 
                                                "Radix", "ShakerSort", "ShellSort", "TriFusion"};
    public static void main(String[] args) {
        int[][][][] costs = new int[sorts.length][shuffleTypes.length][sizes.length][2];
        int iter = 0;
        while (true) {
            iter++;
            for (int i=0; i<sorts.length; i++)
                for (int j=0; j<shuffleTypes.length; j++)
                    for (int k=0; k<sizes.length; k++) try {
                        //create and shuffle tab
                        int size = sizes[k];
                        int[] tab = Tab.createTable(size);
                        switch (shuffleTypes[j]) {
                            case "normal":
                                Tab.shuffleTable(tab, size*2);
                                break;
                            case "faible_entropie":
                                Tab.shuffleTable(tab, (int)(size*0.1));
                                break;
                            case "faible_entropie_inverse":
                                Tab.reverseTab(tab);
                                Tab.shuffleTable(tab, (int)(size*0.1));
                                break;
                            case "fin_non_trie":
                                Tab.shuffledTail(tab, (int)(size*0.5));
                        }
                        //initialiser tri et s'en servir pour trier le tableau
                        Class<?> clazz = Class.forName("tri."+sorts[i]);
                        Constructor<?> constructor = clazz.getConstructor();
                        Tri tri = (Tri)constructor.newInstance();
                        tri.sort(tab); 
                        //recalculer les couts moyens du tri
                        costs[i][j][k][0] = (costs[i][j][k][0]*(iter-1) + tri.getCostCompare()) / iter;
                        costs[i][j][k][1] = (costs[i][j][k][1]*(iter-1) + tri.getCostPermute()) / iter;
                    } catch (Exception e) {e.printStackTrace();}
            writeString(costs, iter);
        }
    }

    public static void writeString (int[][][][] costs, int iter) {
        //generate string
        String str = "Iterations: " + iter + "\n";
        for (int i=0; i<sorts.length; i++) {
            str += sorts[i].toUpperCase() + ":\n";
            for (int j=0; j<shuffleTypes.length; j++) {
                str += "\t" + shuffleTypes[j] + ":\n";
                for (int k=0; k<sizes.length; k++) {
                    str += "\t\t" + sizes[k] + " average compares: " + costs[i][j][k][0] + "\n";
                    str += "\t\t" + sizes[k] + " average permutes: " + costs[i][j][k][1] + "\n";
                }
            }
        }
        System.out.println(str);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/runCosts/" + "output.txt"));
            bw.write(str);
            bw.close();
        } catch (Exception e) {e.printStackTrace();}
    }
}
