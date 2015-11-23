package hamiltonPath;

import hamiltonCycle.HC;

import java.io.FileReader;
import java.util.Scanner;

import travellingSalemansProblem.CertificatTSP;

public class testHP {

	public static void main(String[] arg) throws Exception{
		//saisie du probleme
		if (arg.length < 2)
		    System.out.println("java testHP  mode file.ham");
		else {
			
			//le probleme dans un fichier de donnees
			@SuppressWarnings("resource")
			Scanner donnee = new Scanner (new FileReader(arg[1]));
			
			for (int i=0; i<3; i++) donnee.nextLine();
			donnee.next();
			int nbv= donnee.nextInt();	 
				
			for (int i=0; i<4; i++) donnee.nextLine();
			boolean D[][]=new boolean[nbv][nbv];
			
			for (int i=0; i<nbv; i++){
				for (int j=0; j<nbv; j++) {
					D[i][j]= donnee.nextBoolean();
					System.out.println(D[i][j]+" ");
				}
				System.out.println();
			}
	    
			HP pb=new HP(nbv,D);
	    
			System.out.println(arg[0]);
	    
			// les differents modes
			if (arg[0].equals("-verif")) { 
				CertificatTSP c= (CertificatTSP) pb.red().cert();
				System.out.print("Proposez un certificat:");
				c.saisie();
				
				System.out.print("Votre certificat est-il correct? ");
				System.out.println(pb.red().estCorrect(c));

	    	}else if (arg[0].equals("-nondet")) {
	    		System.out.println(pb.red().aUneSolutionNonDeterministe());
	        }else if (arg[0].equals("-exhaust"))  { 
	        	System.out.println("le probleme a-t-il une solution? ");
	        	//System.out.println(pb.red().aUneSolution());
	        	System.out.println(pb.red().red().aUneSolution());
	    	}else
	    		System.out.println("erreur de mode");
		}

	}
}
