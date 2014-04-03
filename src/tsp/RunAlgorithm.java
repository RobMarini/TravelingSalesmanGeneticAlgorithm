package tsp;

import java.io.File;
import java.io.FileNotFoundException;

public class RunAlgorithm {

	
	public static void main(String[] args) {
		CityReader cr = new CityReader();
		Integer numTours = 30;
		Integer numTrials = 100000;
		try {
			Tour tour = new Tour(cr.readCities("files/30cities.txt"));
			GeneticAlgorithm geneticMutate = new GeneticAlgorithm();
			GeneticAlgorithm geneticCrossover = new GeneticAlgorithm();
			geneticMutate.setAllTours(tour.seed(numTours));
			for(int i=0;i<numTrials;i++){
				geneticMutate.setAllTours(geneticMutate.generateGeneration(true));
			}
			geneticCrossover.setAllTours(tour.seed(numTours));
			for(int i=0;i<numTrials;i++){
				geneticCrossover.setAllTours(geneticCrossover.generateGeneration(false));
			}
			
			System.out.println("The results from Mutation Genetic Algorithm");
			System.out.println("best distance: " + geneticMutate.getAllTours().get(0).getDistance());
			System.out.println("Path: " + geneticMutate.getAllTours().get(0).toString());
			System.out.println();
			
			System.out.println("The results from Crossover Genetic Algorithm");
			System.out.println("best distance: " + geneticCrossover.getAllTours().get(0).getDistance());
			System.out.println("Path: " + geneticCrossover.getAllTours().get(0).toString());
		} catch (FileNotFoundException e) {
			File here = new File(".");
			System.out.println(here.getAbsolutePath());
			e.printStackTrace();
		}
		


	}

}
