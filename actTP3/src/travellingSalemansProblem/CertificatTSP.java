package travellingSalemansProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import until.Methode;
import classesPb.*;

public class CertificatTSP implements Certificat{

	private TSP tsp;
	public List<String> tableauSolution;
	public int nbCertificatMax;
	public String certificat;
	public String certificatSaisie;
	public String certificatGenerer;
	private Scanner scanner;
	public int numCertificat = 0;
	
	/**
	 * Constructeur
	 * @param tsp
	 */
	public CertificatTSP(TSP tsp){
		this.tsp=tsp;
		this.tableauSolution = new ArrayList<String>();
		this.nbCertificatMax = Methode.factorial( tsp.longueurTournee - 1 ) * tsp.longueurTournee;
	}

	
	public TSP getTsp() {
		return tsp;
	}

	public void setTsp(TSP tsp) {
		this.tsp = tsp;
	}

	public Boolean valideCertificatSaisie(){
		if(tableauSolution.isEmpty())
			reset();
		
		if(tableauSolution.contains(certificatSaisie))
			return true;
		
		return false;
	}

	public Boolean valideCertificatGenerer(){
		if(tableauSolution.isEmpty())
			reset();
		
		if(tableauSolution.contains(this.certificatGenerer))
			return true;
		
		return false;
	}
	
	public Boolean valideCertificat(){
		
		if(tableauSolution.contains(this.certificat))
			return true;
		
		return false;
	}
	
	public void genererAllCertificat(int valeurTournee, List<Integer> listVilleVisite){

		if(listVilleVisite.size() == getTsp().nbVilles){
			
			/** Condition de validite **/
			if( ( valeurTournee + this.getTsp().distances[listVilleVisite.get(listVilleVisite.size()-1)][listVilleVisite.get(0)] ) <= this.getTsp().longueurTournee){
				
				String parcours = "";
				
				/** sauvegarde du certificat en base **/
				for(int m=0;m<listVilleVisite.size();m++)
					parcours += tsp.ville[listVilleVisite.get(m)];
				
				parcours += tsp.ville[listVilleVisite.get(0)];
				
				/** par securite pour eviter des doublons **/
				if(!tableauSolution.contains(parcours))
					tableauSolution.add(parcours);
				
				System.out.println("Certif g�n�r� ! ");
			}else{
				System.out.println("Certif non valide ");
			}
		}
		
		for(int i=0;i<this.getTsp().nbVilles;i++){
			
			List<Integer> listTmp = listVilleVisite;
			
			if(!listTmp.contains(i)){

				/** Si le premier parcours est initialiser **/
				if(listTmp.size()>0){
					/** Condition de validite : Ssi longueur entre 2 ville <= a la tournee **/
					if( ( this.getTsp().distances[listTmp.get(listTmp.size()-1)][i] + valeurTournee ) <= this.getTsp().longueurTournee){
								
						/** valeur parcouru calculer **/
						int valeurTourneeTmp = valeurTournee + this.getTsp().distances[listTmp.get(listTmp.size()-1)][i] ;
						
						//System.out.println("valeurTourneeTmp : "+valeurTourneeTmp+ " dernier ajout : "+listTmp.get(listTmp.size()-1));
						
						/** ajout a la list la ville passe **/
						listTmp.add(i);
						
						/** On continue de rechercher la suite de la tournee **/
						genererAllCertificat( valeurTourneeTmp  ,listTmp);
						
						listTmp.remove(listTmp.size()-1);
					}else{
						System.out.println("Certif non valide ");
					}
				}else{ /** Sinon on initialise **/
					listTmp.add(i);
					genererAllCertificat( 0 ,listTmp);
					
					/** Car non symetrique demande **/
					listTmp.remove(listTmp.size()-1);
				}
			}
		}
	}
	
	
	
	public void usage(){
		System.out.println("( Format saisie : '132451' aucun espaces ).");
	}
	
	
	
	
	
	
	
	
	@Override
	public void saisie() {	/** Methode "verification" propose � l'utilisateur de saisir un certificat et v�rifie sa validit� **/
		usage();
		scanner = new Scanner(System.in);
		certificatSaisie = scanner.nextLine();		
	}


	@Override
	public void display() {
		System.out.println("Certificat existant : "+certificat);
	}

	
	@Override
	public void alea() {
		
		int prochain;
		
		List<Integer> listValeur = new ArrayList<Integer>();
		listValeur.add( (int)( Math.random()*( this.getTsp().nbVilles - 1 + 1 ) ) + 1 );
		
		while( listValeur.size() < ( this.getTsp().nbVilles  ) ){
			if(  !listValeur.contains( ( prochain = (int)( Math.random()*( this.getTsp().nbVilles - 1 + 1 ) ) + 1 ) ) ){
				listValeur.add( prochain );
			}
		}	
		listValeur.add(listValeur.get(0));
		
		this.certificatGenerer="";
		for(int i=0; i < listValeur.size(); i++)
			this.certificatGenerer += listValeur.get(i);
		
		System.out.print("Certificat g�n�rer : "+ this.certificatGenerer + " est valide ? ");
	}

	@Override
	public void reset() {
		/** Reinitialisation des donnees **/
		tableauSolution.clear();
		numCertificat = 0;
		
		/** Generations des certificats **/
		genererAllCertificat(0, new ArrayList<Integer>());
		
		/** Recup du premier certificat dans la liste **/
		if(tableauSolution.isEmpty()) System.out.println("Pas de solution");
		else certificat = tableauSolution.get(numCertificat);
		
	}

	@Override
	public boolean estDernier() {
		/** Le dernier de la liste des certificats **/
		if(numCertificat == tableauSolution.size())
			return true;
		
		return false;
	}

	
	@Override
	public void suivant() {
		
		/** Aucun certificat en memoire **/
		if(tableauSolution.isEmpty())
			reset();
		
		/** Ssi on a parcouru tous les certificats **/
		if(estDernier())
			numCertificat = 0;
		
		/** Recuperation du premier certificat **/
		if(!tableauSolution.isEmpty()){
			certificat = tableauSolution.get(numCertificat);	
			numCertificat++;
		}
	}

}
