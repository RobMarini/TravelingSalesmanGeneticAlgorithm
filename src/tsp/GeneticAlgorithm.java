package tsp;
import java.util.ArrayList;
import java.util.Collections;


public class GeneticAlgorithm {
	//uses Tour to run a genetic algorithm
	//hold candidates
	private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
	private ArrayList<Tour> allTours = new ArrayList<Tour>();


	public ArrayList<Tour> getAllTours() {
		return allTours;
	}

	public void setAllTours(ArrayList<Tour> allTours) {
		this.allTours = allTours;
	}

	public static double getMutationrate() {
		return mutationRate;
	}

	public static int getTournamentsize() {
		return tournamentSize;
	} 
	public ArrayList<Tour> mutateGeneration(){
		ArrayList<Tour> newTours = new ArrayList<Tour>(allTours);
		for(int i=0;i<newTours.size();i++){
			newTours.set(i, newTours.get(i).mutate());
		}
		return newTours;
	}
	public ArrayList<Tour> crossoverGeneration(){
		ArrayList<Tour> newTours = new ArrayList<Tour>();
		for(int i=0;i<allTours.size()-1;i++){
			newTours.add(allTours.get(i).Mate(allTours.get(i+1)));
		}
		return newTours;
	}
	
	public ArrayList<Tour> generateGeneration(Boolean mutate){
		ArrayList<Tour> newGeneration = new ArrayList<Tour>(allTours.size()*2-1);
		if(mutate){
			newGeneration.addAll(new ArrayList<Tour>(allTours));
			newGeneration.addAll(new ArrayList<Tour>(this.mutateGeneration()));
			Collections.sort(newGeneration);
		}else{
			//allTours contains invalid tours
			newGeneration.addAll(new ArrayList<Tour>(allTours));
			newGeneration.addAll(new ArrayList<Tour>(this.crossoverGeneration()));
			// TODO: Debug this shit.
			Collections.sort(newGeneration); 
		}
		return new ArrayList<Tour>(newGeneration.subList(0, allTours.size()));
	}
}
