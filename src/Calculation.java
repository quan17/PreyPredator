public class Calculation {
	public static Population Week(Animal[] animalEco, FoodSource[] foodSourceEco, Population population, int season, int week){
		int lastWeek = week - 1;
		
		for (int i = 0 ; i < Ecosystem.numOfAnimals; i++){
			if (population.getAnimal(i + 1, lastWeek) > 0){
				double growth = AnimalGrowth(i, animalEco, foodSourceEco, population, season, week);
				double decline = AnimalDecline(i, animalEco, population, season, week);
				double pop = population.getAnimal(i+1, lastWeek) + (growth - decline);
				population.setAnimla(i+1, week, pop);
			}
			else{
				population.setAnimla(i+1, week, 0);
			}
		}
		
		for (int i = 0; i < Ecosystem.numOfFoodSource; i++){
			if (population.getFoodSource(i + 1, lastWeek) > 0  && foodSourceEco[i].getGrowthRate(season) >0){
				double pop = population.getFoodSource(i+1, lastWeek) + FoodGrowth(i, animalEco, foodSourceEco, population, season, week);
				if(pop<=0) pop=0.0;
				population.setFoodSource(i+1, week, pop);
			}
			else{
				population.setFoodSource(i+1, week, population.getFoodSource(i+1, lastWeek));
			}
		}
		
		return population;
	}
	
	private static double AnimalGrowth (int animal ,Animal[] animalEco, FoodSource[] foodSourceEco, Population population, int season, int week){
		int numOfSoruce = 0;
		double preySum = 0;
		double mealSum = 0;
		
		for (PreysOn prey: animalEco[animal].getPreysOn()){
			if (population.getAnimal(prey.getAnimal(), week-1) > 0){
				numOfSoruce++;
				double k = prey.getHuntRate(season) * (( population.getAnimal(animal+1, week -1) * population.getAnimal(prey.getAnimal(), week - 1)) / Ecosystem.scaleFactor);
				k = k * (animalEco[animal].getAggressivity() / animalEco[prey.getAnimal() - 1].getEvasiveness());
				preySum += k;
			}
		}
		
		for (FeedsOn feed: animalEco[animal].getFeedsOn()){
			if (population.getFoodSource(feed.getFood(), week-1) > 0){
				numOfSoruce++;
				double k = feed.getMeal(season) * ((population.getAnimal(animal+1, week -1) * population.getFoodSource(feed.getFood(), week - 1))/ Ecosystem.scaleFactor);
				mealSum += k;
			}
		}
		
		double growth = 0;
		
		if (numOfSoruce > 0){
			growth = (animalEco[animal].getBirthRate()/numOfSoruce) * (preySum + mealSum);
		}
		
		return growth;
	}
	
	private static double AnimalDecline(int animal ,Animal[] animalEco, Population population, int season, int week){
		double decline = 0;
		
		for (int i = 0; i < Ecosystem.numOfAnimals; i++){
			if (i != animal && population.getAnimal(i+1, week-1) > 0){
				for(PreysOn prey : animalEco[i].getPreysOn()){
					if (prey.getAnimal() == (animal + 1)){
						double k = prey.getHuntRate(season) * ((population.getAnimal(animal+1, week - 1) * population.getAnimal(i+1, week - 1)) / Ecosystem.scaleFactor);
						k = k * (animalEco[i].getAggressivity() / animalEco[animal].getEvasiveness());
						decline += k;
					}
				}
			}
		}

		decline += (population.getAnimal(animal+1, week - 1) * animalEco[animal].getDeathRate());
		
		return decline;
	}
	
	private static double FoodGrowth(int food ,Animal[] animalEco, FoodSource[] foodSourceEco, Population population, int season, int week){
		double sum = 0;
		
		for (int i = 0; i < Ecosystem.numOfAnimals; i++){
			if (population.getAnimal(i+1, week - 1) > 0){
				for(FeedsOn feed: animalEco[i].getFeedsOn()){
					if (feed.getFood() == (food+1)){
						sum += feed.getMeal(season) * ((population.getAnimal(i+1, week - 1) * population.getFoodSource(food + 1, week - 1)) / Ecosystem.scaleFactor);
					}
				}
			}
		}
		
		double growth = (population.getFoodSource(food + 1, week - 1) * foodSourceEco[food].getGrowthRate(season)) - sum;
		return growth;
	}
}
