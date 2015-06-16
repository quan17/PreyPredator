
public class Population {
	private double[][] animalPop;
	private double[][] foodPop;
	
	double getAnimal(int animal, int week){return animalPop[animal-1][week];}
	void setAnimla(int animal, int week, double population){
		animalPop[animal-1][week] = population;
	}
	
	double getFoodSource(int foodSource, int week){return foodPop[foodSource-1][week];}
	void setFoodSource(int foodSource, int week, double population){
		foodPop[foodSource-1][week] = population;
	}
	
	public Population(int simulationLength){
		animalPop = new double[Ecosystem.numOfAnimals][simulationLength+1];
		foodPop = new double[Ecosystem.numOfFoodSource][simulationLength+1];
	}
}
