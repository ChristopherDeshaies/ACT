package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LectureProbPizza {
	
	/**
	 * Fonction qui lit le fichier de problème - extrait les données et initialise une instance Pizza avec 
	 * @return
	 * @throws IOException 
	 */
	public static Pizza convertirFilePizza(String fichier) throws IOException{
		
		int longueur, largueur, taille, jambonMin;
		
		//Ouverture du flux de lecture du fichier
		InputStream ips = new FileInputStream( fichier );
		InputStreamReader ipsr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		String ligne;
		
		//Lecture des paramètres
		ligne=br.readLine();
		
		
		//***********************************************
		//*************** POUR L'INSTANT ****************
		//***********************************************
		longueur=5;
		largueur=3;
		taille=6;
		jambonMin=1;
		
		//Initialise la pizza
		boolean [][] pizza = new boolean[longueur][largueur];
		int i=0;
		
		while((ligne=br.readLine())!=null)
			for(int j=0; j<ligne.length(); i++,j++)
				if( ligne.charAt(j) == 'H' )
					pizza[i][j]=true;
				else
					pizza[i][j]=false;
			
		//Fermeture du flux de lecture
		br.close();
		
		//Return la pizza lu
		return new Pizza(longueur, largueur, taille, jambonMin, pizza);
	}
}
