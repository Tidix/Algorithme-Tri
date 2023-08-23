package tri;

import visualiser.ArrayVisualiser;

//MergeSort 
public class TriFusion extends Tri{

    // executer l'algo sans visualisation (pour cmd ou les tests)
	public TriFusion () {
        this(null, 0);
    }
    // Visualisation sans délai  
	public TriFusion (ArrayVisualiser GUI) {
	    this(GUI, 0);
	}

    //Visualisation avec un délai 
	public TriFusion (ArrayVisualiser GUI, int sleepTime) {
	    super(GUI, sleepTime);
	}
    
    //fonction de tri
    public void sort(int[] tab){
        triFusion(tab,0,tab.length-1);
    }

    // principe de récursion sur division de tableaux en 2 parties 
    public void triFusion(int[] tab, int debut, int fin){

        if (debut!=fin){ // On vérifie que le parcours n'est pas fini
            int milieu=(fin+debut)/2;     // indice milieu du tableau 
            triFusion(tab,debut,milieu);   // TriFusion première partie  
            triFusion(tab,milieu+1,fin);  // TriFusion deuxième partie
            fusion(tab,debut,milieu,fin);  // fusion des parties de tableaux triés
        }
    }

    // fonction de fusion des deux tableaux
    private void fusion(int tab[],int deb1,int milieu,int fin){
    	int deb2=milieu+1;
    	int table1[]=new int[milieu-deb1+1]; 

    	for(int i=deb1;i<=milieu;i++){
    		table1[i-deb1]=tab[i];
        }
    	
    	int compt1=deb1; 
    	int compt2=deb2;
    	for(int i=deb1;i<=fin;i++){   //tous les éléments du 1er tableau sont triée 
        	if (compt1==deb2) 
            {
                costPermute++; // On force l'incrémentation du coût
            break; // Tout est triée, on sort de la boucle
            }
        else if (compt2==(fin+1)) // Si le 2ème tableau est vide, on ajoute tout les éléments restant du 1er tableau
            {
            tab[i]=table1[compt1-deb1];
            compt1++;
            costPermute++; // On force l'incrémentation du coût
            }
        else if(compare(table1[compt1-deb1],tab[compt2])) // si l'élément de 1er tableau est plus petit que celui du 2ème
            {
            tab[i]=table1[compt1-deb1]; // ajout dans tableau principale
            compt1++;
            }
        else   // Si élément du 2eme tableau est plus petit, on l'ajoute dans le tableau principale 
            {
            costPermute++;  // On force l'incrémentation du coût
            tab[i]=tab[compt2]; 
            compt2++;
            }
        }
    }


    
}