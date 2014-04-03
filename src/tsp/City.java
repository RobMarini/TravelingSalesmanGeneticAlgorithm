package tsp;
import java.util.ArrayList;


public class City {
	//The City's index in the array of distances, valid numbers are 0,maxVal
	private Integer cityNumber = -1;
	//the list of distances between this city and any other city, equivalent to a row in the matrix
	private ArrayList<Integer> distances = new ArrayList<Integer>();
	
	City(int c, ArrayList<Integer> d){
		cityNumber = c;
		//want a copy of it for ourselves
		distances = new ArrayList<Integer>(d);
	}

	public int getCityNumber() {
		return cityNumber;
	}
	public void setCityNumber(int cityNumber) {
		this.cityNumber = cityNumber;
	}
	public ArrayList<Integer> getDistances() {
		return distances;
	}
	public void setDistances(ArrayList<Integer> distances) {
		this.distances = distances;
	}
	public String toString(){
		return cityNumber.toString();
	}
}
