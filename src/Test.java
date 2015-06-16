//
//public class Test {
//	public static void main(String[] args) {
//		
//		int simulationLength = 10;
//		int season = Seasons.FALL;
//		
//		int weekInSeason = 4;
//		int seasonWeekCount = 0; 
//		
//		Population population = new Population(simulationLength);
//		
//		
//		population.setAnimla(Animals.Tiger, 0, 15);
//		population.setAnimla(Animals.Fox, 0, 25);
//		population.setAnimla(Animals.Zebra, 0, 29);
//		population.setAnimla(Animals.Rabbit, 0, 43);
//
//		population.setFoodSource(Food.Grass, 0, 24);
//		population.setFoodSource(Food.Apple, 0, 20);
//
//		
//		
//		//Do not change***************************************************
//		
//		Animal[] animalEco = Ecosystem.getAnimal();
//		FoodSource[] foodSourceEco = Ecosystem.getFoodSource();
//		
//		for (int i = 1; i <= simulationLength; i++){
//			if (seasonWeekCount == weekInSeason){
//				if (season == 4) season = 1;
//				else season++;
//				seasonWeekCount = 1;
//			}
//			else seasonWeekCount++;
//			
//			population = Calculation.Week(animalEco, foodSourceEco, population, season, i);
//		}
//		
//		
//		for (int i = 0; i <= simulationLength;i++){
//			System.out.println(population.getAnimal(Animals.Rabbit, i));
//		}
//	}
//	
//	
//	
//}
