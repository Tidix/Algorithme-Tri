package tri;

import visualiser.ArrayVisualiser;

// classe abstraite pour tous les algo
public abstract class Tri {
    protected String logPath;
    protected ArrayVisualiser gui;
    protected int delay;
    protected int costCompare = 0;
    protected int costPermute = 0;
    
    // executer l'algo sans visualisation (pour cmd ou les tests)
    public Tri (){
        delay = 0;
    }

    public Tri (String path) {
        logPath = path;
        delay = 0;
    }

    //visualisation sans délai
    public Tri (ArrayVisualiser GUI) {
        this(GUI, 0);
    }

    //visualisation avec délai
    public Tri (ArrayVisualiser GUI, int sleepTime) {
        gui = GUI;
        delay = sleepTime;
    }

    //méthode abstraite qui effectue le tri pour chaque algo
    public abstract void sort(int[] tab);
    
    //actualisation visualisation et des coûts
    protected void refresh () {
        
        if (gui != null){
            gui.setCostPermute(costPermute);
            gui.setCostCompare(costCompare);
            gui.repaint();}
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void changedVector (int[] tab) {
        // pour effectuer les tests, on lance sans l'interface
    	if(gui!=null) {
    		gui.setTab(tab);
    	}
    }
    // Permets de permuter des valeurs de tableau et d'incrémenter le coût de permutation
    protected void permute(int[] tab, int i, int j) {
		int cpt = tab[i];
		tab[i] = tab[j];
		tab[j] = cpt;
		refresh(); 
        costPermute += 1; //Pour chaque permutation, on instancie le coût de permutation
	}

    // Permets de comparer des valeurs de tableau et d'incrémenter le coût de comparaison
    protected boolean compare (int x, int y) {
        costCompare += 1; //Pour chaque comparaison, on instancie le coût de comparaison
        return x < y;
    }
    //accesseur coût de permutation
    public int getCostPermute(){
        return costPermute;
    }
    //accesseur coût de comparaison
    public int getCostCompare(){
        return costCompare;
    }
}
