package travellingSalemansProblem;
import classesPb.*;

public class TSP extends NP{
	public int nbVilles;
	public int[][] distances;
	public String[] ville;
	public int longueurTournee;

	public TSP(int nb, int dist[][], int lg, String[] ville){
		this.nbVilles=nb;
		this.distances=dist;
		this.longueurTournee=lg;
		this.ville=ville;
	}
	
	public CertificatTSP cert() { 
		return new CertificatTSP(this);
	}
	
	public boolean estCorrect(Certificat c){
		
		while( c.estDernier() ){

			if(c.valideCertificatSaisie())
				return true;
		}
		return false;
	}


}
