package comparaisons;

public class FonctionsReference {

	private int[] sizes;

	public FonctionsReference(int[] sizes) {
		this.sizes = sizes;
	}
	
	/**
	 * Retourne le tableau de toutes les valeurs de n^pow pour tous
	 * les n pr√©sents dans this.sizes.
	 * @param pow puissance
	 * @return tableau des r√©sultats
	 */
	public double[] puissance (double pow) {
		double[] values = new double[this.sizes.length];
		
		for (int idx=0 ; idx<this.sizes.length ; idx++)
			values[idx] = Math.pow(this.sizes[idx], pow);
		
		return values;
	}
	
	/**
	 * Retourne le tableau de toutes les valeurs de logn pour tous
	 * les n pr√©sents dans this.sizes.
	 * @param pow puissance
	 * @return tableau des r√©sultats
	 */
	public double[] logarithme () {
		double[] values = new double[this.sizes.length];
		
		for (int idx=0 ; idx<this.sizes.length ; idx++)
			values[idx] = Math.log(this.sizes[idx]);
		
		return values;
	}
	

	/**
	 * Retourne le tableau de toutes les valeur de nlogn pour tous
	 * les n prÈsents dans this.sizes
	 * @param
	 * @return tableau de rÈsultats
	 */
	public double[] NlogN(){
		double[] values = new double[this.sizes.length];
		
		for (int i=0;i<this.sizes.length;i++)
			values[i] = this.sizes[i] * Math.log(this.sizes[i]);
		
		return values;
	}
	
	
	/**
	 * Retourne le tableau de toutes les valeur de exp(n) pour tous
	 * les n prÈsents dans this.sizes
	 * @param
	 * @return tableau de rÈsultats
	 */
	public double[] Exp(){
		double[] values = new double[this.sizes.length];
		
		for (int i=0; i < this.sizes.length; i++){
			values[i] = Math.exp(this.sizes[i]);
		}
		
		return values;
	}
	
	
	/**
	 * Retourne le tableau de toutes les valeurs de k^n pour tous
	 * les n presents dans this.sizes.
	 * @param k
	 * @return tableau des resultats
	 */
	public double[] KpN (double k) {
		double[] values = new double[this.sizes.length];
		
		for (int idx=0 ; idx<this.sizes.length ; idx++)
			values[idx] = Math.pow(k,this.sizes[idx]);
		
		return values;
	}
	
	
	
	/**
	 * Retourne le tableau de toutes les valeur de n! pour tous
	 * les n prÈsents dans this.sizes
	 * @param
	 * @return tableau de rÈsultats
	 */
	public double[] sN(){
		double[] values = new double[this.sizes.length];
		
		for (int idx=0 ; idx<this.sizes.length ; idx++){
			values[idx]=1;
			for(int j=1;j<=this.sizes[idx];j++)
				values[idx] *= j;
		}
		
		return values;
	}
	
	
	/**
	 * Retourne le tableau de toutes les valeurs de n^n pour tous
	 * les n presents dans this.sizes.
	 * @param pow puissance
	 * @return tableau des resultats
	 */
	public double[] NpN () {
		double[] values = new double[this.sizes.length];
		
		for (int idx=0 ; idx<this.sizes.length ; idx++)
			values[idx] = Math.pow(this.sizes[idx],this.sizes[idx]);
		
		return values;
	}
	
	
	/**************************************************************************
     **************************************************************************
     ****************** RAPPORTS ENTRE FONCTIONS DE REFERENCE *****************
     **************************************************************************
     *************************************************************************/
	
		/** 
		 * Ecrit dans values[] les valeurs du rapport (n^epsi)/log(n) pour
		 * les valeurs de n contenues dans sizes[] 
		 * @param epsi puissance
		 * @return tableau des resultats
		 */
	    public double[] rapportNepsiLog (double epsi){
	    
	    	double[] values = new double[this.sizes.length];
	    	
			for (int i=0; i < this.sizes.length; i++)
			    values[i] =  Math.pow(this.sizes[i],epsi)/Math.log(this.sizes[i]);
			    
			return values;
			
	    }
	    
	    
	    
	    /** 
		 * Ecrit dans values[] les valeurs du rapport (n^k)/(2^n) pour
		 * les valeurs de n contenues dans sizes[] 
		 * @param k puissance
		 * @return tableau des resultats
		 */
	    public double[] rapportNpk2pN (double k){
	    
	    	double[] values = new double[this.sizes.length];
	    	
			for (int i=0; i < this.sizes.length; i++)
			    values[i] =  Math.pow(this.sizes[i],k)/Math.pow(2,this.sizes[i]);
			    
			return values;
			
	    }
	    
}
