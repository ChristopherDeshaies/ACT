package comparaisons;

import datastructures.Liste;
import datastructures.Tableau;
import io.EcritureFichier;

public class ComparaisonStructures {

	public static void main(String[] args) {
		// Les valeurs de x a tester pour tracer nos courbes
		int[] sizes = {2,10,20,30,40,50,100,150,200,300,400,500,1000,1500,2000,5000,10000,25000,50000,75000,100000,250000,500000};
		double[][] results = new double[10][sizes.length];
		Tableau[] l = new Tableau[sizes.length];
		Liste[] list = new Liste[sizes.length];
		
		// Creation des resultats
		for (int idx=0 ; idx<sizes.length ; idx++) {
			l[idx] = new Tableau(sizes[idx]);
			list[idx] = new Liste(sizes[idx]);
			results[0][idx] = Mesures.mesureAlea(l[idx]);
			results[5][idx] = Mesures.mesureAlea(list[idx]);
		}
		
		for(int idx=0;idx<sizes.length;idx++){
			results[1][idx] = Mesures.mesureRecherche(l[idx],sizes[idx]);
			results[2][idx] = Mesures.mesureMinimumSimple(l[idx]);
			results[3][idx] = Mesures.mesureMinimumTri(l[idx]);
			results[4][idx] = Mesures.mesureMystere(l[idx]);
			results[6][idx] = Mesures.mesureRecherche(list[idx],sizes[idx]);
			results[7][idx] = Mesures.mesureMinimumSimple(list[idx]);
			results[8][idx] = Mesures.mesureMinimumTri(list[idx]);
			results[9][idx] = Mesures.mesureMystere(list[idx]);
		}
		
		// Ecriture du fichier de résultats
		//EcritureFichier.output("data/alea_tableau_1.txt", results, sizes);
		EcritureFichier.output("data/alea_tableau_4.txt", results, sizes);
		
		
	}
	
}