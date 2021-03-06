package model;

public class CoupePossiblePizza {

	public int nbJambon;
	public int taillePart;
	public boolean[][] partPizza;
	public int x;
	public int y;
	public CoupePossiblePizza(int nbJambon, int taillePart){
		this.nbJambon=nbJambon;
		this.taillePart=taillePart;
		
		this.x=1;
		this.y=1;
		partPizza = new boolean[x][y];
		partPizza[0][0]=true;
		
	}
	
	/**
	 * Retourne une part de pizza de base
	 * @return
	 */
	public boolean[][] getPartPizza(){
		return partPizza;
	}
	
	
	/**
	 * Renvoie toutes les tailles de part possible
	 * Debut avec x = 1 et y = 1
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean[][] partPossibleSuivante(int x, int y){
		int xTmp=1;
		int yTmp=1;
		
		//Fin des part possible
		if( x > taillePart )
			return null;
		
		if( ( x * (y+1) ) <= taillePart ){
			yTmp = y+1;
		}else{
			xTmp = x+1;
			yTmp = 1;
		}

		return new boolean[xTmp][yTmp];
	}
}
