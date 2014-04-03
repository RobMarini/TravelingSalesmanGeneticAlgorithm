package tsp;

import java.util.ArrayList;

public class Tour implements Comparable<Tour> {
	ArrayList<City> tour;
	
	Tour(ArrayList<City> c){
		tour = new ArrayList<City>(c);
	}
	
	public Double getFitness(){
		//our fitness is 1/distance traveled
		Integer totalDistance = 0;
		//NOTE: The distance traveled here assumes that we are solving the TSP where you reach every city EXACTLY once without returning to the initial city
		for(int i=0;i<tour.size()-1;i++){
			City c1 = tour.get(i);
			City c2 = tour.get(i+1);
			totalDistance += c1.getDistances().get(c2.getCityNumber());
		}
		return 1/(double)totalDistance;
	}
	public Integer getDistance(){
		Integer totalDistance =0;
		for(int i=0;i<tour.size()-1;i++){
			City c1 = tour.get(i);
			City c2 = tour.get(i+1);
			totalDistance += c1.getDistances().get(c2.getCityNumber());
		}
		return totalDistance;
	}

	@Override
	public int compareTo(Tour o) {
		return this.getDistance().compareTo(o.getDistance());
	}
	public Tour mutate(){
		//return a mutated version of this tour
		Integer random1 = (int) (Math.random()*tour.size());
		Integer random2 = (int) (Math.random()*tour.size());
		if(random1==random2){return this;}
		ArrayList<City> temp = new ArrayList<City>(tour);
		City c1 = temp.get(random1);
		City c2 = temp.get(random2);
		temp.set(random1, c2);
		temp.set(random2, c1);
		return new Tour(temp);
	}
	public Tour Mate(Tour t){
		ArrayList<City> temp = t.tour;
		Integer random = (int) (Math.random()*tour.size());
		ArrayList<City> child =  new ArrayList<City>(tour.subList(0, random));
		for(int i=0;i<child.size();i++){
			temp.remove(child.get(i));
		}
		for(City c:temp){
			if(c!=null){
				child.add(c);
			}
		}
		//Child cannot have null cities
		//child = new ArrayList<City>(child.subList(0, 30));
		ArrayList<City> returnVal = new ArrayList<City>(30);
		for(City c:child){
			if(c!=null){
				returnVal.add(c);
			}
		}
		return new Tour(returnVal);
	}
	
	public ArrayList<Tour> seed(Integer i){
		//creates initialized tours
		ArrayList<Tour> tours = new ArrayList<Tour>(i);
		for(int j=0;j<i;j++){
			tours.add(new Tour(this.mutate().tour));
		}
		return tours;
	}
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("[");
		for(City c:this.tour){
			s.append(c.toString()+",");
		}
		s.deleteCharAt(s.length()-1);
		s.append("]");
		return s.toString();
	}
}
