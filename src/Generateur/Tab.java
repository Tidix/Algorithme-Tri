package Generateur;

//les fonctions permettant la génération de tableau modifié
public class Tab {
	public static int[] createTable(int n) {
		int[] tab = new int[n];
		for(int i = 0; i < n; i++)
			tab[i] = i;
		return tab;
	}
	// mélanger un tableau avec un certain niveau d'entropy
	public static void shuffleTable(int[] tab, int entropy) {
		int rdm1, rdm2;
		for(int i = 0 ; i < entropy ; i++) {
			rdm1 = (int) (Math.random() * tab.length);
			rdm2 = (int) (Math.random() * tab.length);
			int cpt = tab[rdm1];
			tab[rdm1] = tab[rdm2];
			tab[rdm2] = cpt;
		}
	}
	// Inverse un tableau
	public static void reverseTab(int[] tab){
		for(int i = 1; i < (tab.length-1)/2; i++){
			int cpt = tab[i];
			tab[i] = tab[tab.length-i];
			tab[tab.length-i] = cpt;

		}
	}
	//mélange seulement la première parti d'un tableau
	public static void shuffledTail(int[] tab, int entropy){
		int range = (int) (tab.length*0.25);
		int rdm1, rdm2;
		for(int i = 0 ; i < entropy ; i++) {
			rdm1 = (int) (Math.random() * range);
			rdm2 = (int) (Math.random() * range);
			int cpt = tab[rdm1];
			tab[rdm1] = tab[rdm2];
			tab[rdm2] = cpt;
		}
	}
}
