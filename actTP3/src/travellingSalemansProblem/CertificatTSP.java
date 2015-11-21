package travellingSalemansProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import until.Methode;
import classesPb.*;

public class CertificatTSP implements Certificat{

	private TSP tsp;
	public List<String> tableauSolution;
	public int nbCertificatMax;
	public String certificat;
	public String certificatSaisie;
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

	public Boolean valideCertificat(){
		if(tableauSolution.isEmpty())
			reset();
		
		if(tableauSolution.contains(certificatSaisie))
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
		System.out.println("Les certificats pour ce probl�me sont : ");
		for(int i=0;i<tableauSolution.size();i++)
			System.out.println(tableauSolution.get(i));
	}

	
	
	@Override
	public void alea() {
		if(tableauSolution.isEmpty())
			reset();
			
		/** Ssi tous les certificats sont en memoire **/
		if(tableauSolution.size() == nbCertificatMax){
			Random random = new Random();
			int pointeurCertficat = random.nextInt(tableauSolution.size());
			certificat = tableauSolution.get(pointeurCertficat);
		}else{
				
		}
		
	}

	@Override
	public void reset() {
		/** Reinitialisation des donnees **/
		tableauSolution.clear();
		numCertificat = 0;
		
		/** Generations des certificats **/
		genererAllCertificat(0, new ArrayList<Integer>());
		
		/** Recup du premier certificat dans la liste **/
		certificat = tableauSolution.get(numCertificat);
		
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
		certificat = tableauSolution.get(numCertificat);	
		
	}

}