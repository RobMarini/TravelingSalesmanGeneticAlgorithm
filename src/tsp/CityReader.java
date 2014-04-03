package tsp;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CityReader {
	private ArrayList<City> tour = new ArrayList<City>();
	Integer numCities = 0;
	Integer maxVal = 0;
	
	public ArrayList<City> readCities(String filename) throws FileNotFoundException{
		InputStream fileInputStream;
		BufferedReader reader;
		String line;
		fileInputStream = new FileInputStream(filename);
		reader = new BufferedReader(new InputStreamReader(fileInputStream));
		try {
			//We would like to read in the first two lines separately
			numCities = Integer.parseInt(reader.readLine());
			maxVal = Integer.parseInt(reader.readLine());
			int i = 0;
			while ((line = reader.readLine()) != null) {
			    // Deal with the line
				String[] temp = line.split("\\t");
				ArrayList<Integer> d = new ArrayList<Integer>();
				//lets try java's fancy new for loop
				for(String dist:temp){
					d.add(Integer.parseInt(dist));
				}
				if(!d.isEmpty()){
					City c = new City(i,d);
					tour.add(c);
					//increase our index
					i=i+1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tour;
	}
	
	public ArrayList<City> getTours(){
		return tour;
	}
}
