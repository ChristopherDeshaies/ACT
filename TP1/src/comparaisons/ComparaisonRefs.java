package comparaisons;

import io.EcritureFichier;

public class ComparaisonRefs {
	
	/**
	 * question 1.3.1
	 * n^ksi vs log(n)
	 * @param
	 */
	public static void NpKsiVSlogn(){
		// Les valeurs de x à tester pour tracer nos courbes
		int[] sizes = {1, 2,10,20,30,40,50,100,150,200,300,400,500,1000,1500,2000,5000,10000,25000,50000,75000,100000,250000,500000};
		FonctionsReference fr = new FonctionsReference(sizes);
				
		// Création des résultats
		double[][] results = new double[4][];
		results[0] = fr.rapportNepsiLog(1);
		results[1] = fr.rapportNepsiLog(0.5);
		results[2] = fr.rapportNepsiLog(0.2);
		results[3] = fr.rapportNepsiLog(0.1);

		// Écriture du fichier de résultats
		EcritureFichier.output("data/comparaisons_refs2.txt", results, sizes);
	}
	
	/**
	 * question 1.3.1
	 * n^ksi vs log(n)
	 * @param
	 */
	public static void NpKVSNpk(){
		// Les valeurs de x à tester pour tracer nos courbes
		int[] sizes = {1, 2,10,20,30,40,50,100,150,200,300,400,500,1000,1500,2000,5000,10000,25000,50000,75000,100000,250000,500000};
		FonctionsReference fr = new FonctionsReference(sizes);
				
		// Création des résultats
		double[][] results = new double[4][];
		results[0] = fr.rapportNpk2pN(1);
		results[1] = fr.rapportNpk2pN(2);
		results[2] = fr.rapportNpk2pN(4);
		results[3] = fr.rapportNpk2pN(6);

		// Écriture du fichier de résultats
		EcritureFichier.output("data/comparaisons_refs3.txt", results, sizes);
	}
	
	
	public static void main(String[] args) {
		// Les valeurs de x à tester pour tracer nos courbes
		int[] sizes = {1, 2,10,20,30,40,50,100,150,200,300,400,500,1000,1500,2000,5000,10000,25000,50000,75000,100000,250000,500000};
		FonctionsReference fr = new FonctionsReference(sizes);
		
		// Création des résultats
		double[][] results = new double[7][];
		results[0] = fr.puissance(1);
		results[1] = fr.logarithme();
		results[2] = fr.NlogN();
		results[3] = fr.Exp();
		results[4] = fr.KpN(2);
		results[5] = fr.sN();
		results[6] = fr.NpN();
		
		// Écriture du fichier de résultats
		EcritureFichier.output("data/comparaisons_refs.txt", results, sizes);
		
		// question 1.3 Limites graphiques
		NpKsiVSlogn();
		NpKVSNpk();
	}
	
}
