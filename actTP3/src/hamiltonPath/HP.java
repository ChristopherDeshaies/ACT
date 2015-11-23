package hamiltonPath;

import hamiltonCycle.HC;
import classesPb.NPRed;

public class HP {

	public int nbVilles;
	public boolean[][] distances;
	
	public HP(int nbVilles, boolean[][] distances){
		this.nbVilles=nbVilles;
		this.distances=distances;
	}
	
	public NPRed red() {
		HC reducPoly = new HC(nbVilles,distances);
		return reducPoly;
	}
}
