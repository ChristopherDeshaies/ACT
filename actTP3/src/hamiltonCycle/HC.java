package hamiltonCycle;

import classesPb.NP;
import classesPb.NPRed;
import travellingSalemansProblem.TSP;

public class HC extends NPRed{
	
	public int nbVilles;
	public boolean[][] distances;
	
	public HC(int nbVilles, boolean[][] distances){
		this.nbVilles=nbVilles;
		this.distances=distances;
	}
	
	public NP red() {
		
		int [][] distancesRed = new int[nbVilles][nbVilles];
		String [] nomVille = new String[nbVilles];
		
		/** Initialisation de la matrice HC - 1 = true et autre = false **/
		for(int i=0;i < distances.length;i++){
			for(int j=0;j < distances[i].length; j++){
				if(distances[i][j]==true)distancesRed[i][j]=1;
				else distancesRed[i][j]= (int)( Math.random()*( 10 - 3 + 1 ) ) + 3;
				System.out.println(distancesRed[i][j]);
			}
			System.out.println(" ");
		}
		/** Initialisation des nom de villes **/
		for(int i=0;i < distances.length;i++)
			nomVille[i] = String.valueOf(i);
		
		TSP reducPoly = new TSP(nbVilles,distancesRed,nbVilles,nomVille);
		return reducPoly;
		
	}
	
}
