package comparaisons;

import datastructures.*;
public class Mesures {

	/**
	 * Permet de renvoyer la mesure de la complexité pour l'exécution de
	 * la fonction alea sur une structure de donnée.
	 * @param aMesurer Structure de données sur laquelle on exécute alea
	 * @return Valeur de la mesure
	 */
	public static long mesureAlea (DataStructure aMesurer) {
		// TODO : Compléter la fonction afin de pouvoir renvoyer une valeur.
		long startTime;
		long totalTime;
		
		startTime = System.nanoTime();
		aMesurer.alea();
		totalTime = System.nanoTime() - startTime;

		return totalTime;
	}
	

	
	public static long mesureRecherche(DataStructure aMesurer, int value){
		
		long startTime;
		long totalTime;
		
		startTime = System.nanoTime();
		aMesurer.recherche(value);
		totalTime = System.nanoTime() - startTime;
		
		return totalTime;
	}
	
	public static long mesureMinimumSimple(DataStructure aMesurer){
		long startTime;
		long totalTime;
		
		startTime = System.nanoTime();
		aMesurer.minimumSimple();
		totalTime = System.nanoTime() - startTime;
		
		return totalTime;	
	}
	
	public static long mesureMinimumTri(DataStructure aMesurer){
		long startTime;
		long totalTime;
		
		startTime = System.nanoTime();
		aMesurer.minimumTri();
		totalTime = System.nanoTime() - startTime;
		
		return totalTime;
	}

	public static double mesureMystere(DataStructure aMesurer) {
		long startTime;
		long totalTime;
		
		startTime = System.nanoTime();
		aMesurer.mystere();
		totalTime = System.nanoTime() - startTime;
		
		return totalTime;
	}
	
	
}
