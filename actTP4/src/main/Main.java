package main;

import java.io.IOException;

import model.LectureProbPizza;
import model.Pizza;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//On vérifie qu'on a bien passé en argument le fichier
		if(args.length < 1){
			usage();
			return;
		}
		
		//Récupération du probleme
		Pizza pizza = LectureProbPizza.convertirFilePizza(args[0]);
		
		
	}

	private static void usage() {
		System.out.println("Mode d'emploi... \n");
		System.out.println("Compilation : java Main.java donnee/data.in");
	}

}
