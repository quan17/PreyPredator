
public class Ecosystem {
	
	
	public interface Food{
		public static final int Grain = 1;
		public static final int Water  = 2;
		public static final int Carrot= 3;
		public static final int Apple = 4;

	}
	
	public static int scaleFactors = 4000;
	public static int numOfAnimals = 5;
	public static int numOfFoodSource = 4;
	
	public static Animal[] getAnimal(){
		Animal[] animalArray  = new Animal[numOfAnimals];
		
		//change
		//Add animal and it food 
		Animal lion = new Animal("Lion",1.3, 1.1, 0.03, 0.011);
		lion.presyOn(Animals.Deer,9);
		lion.presyOn(Animals.Rabbit,9);
		lion.feedsOn(Food.Water, 7);
		animalArray[Animals.Lion - 1] = lion;
		
		Animal tiger = new Animal("Tiger",1.3, 1.1, 0.03, 0.011);
		tiger.presyOn(Animals.Fox, 9);
		tiger.feedsOn(Food.Water, 7);
		animalArray[Animals.Tiger - 1] = tiger;
		
		Animal deer = new Animal("Deer", 1.1, 1.3, 0.03, 0.011);
		deer.feedsOn(Food.Water, 7);
		deer.feedsOn(Food.Apple, 7);
		animalArray[Animals.Deer - 1] = deer;
		
		Animal fox = new Animal("Fox",1.3, 1.1, 0.03, 0.001);
		fox.presyOn(Animals.Rabbit,9);
		fox.feedsOn(Food.Water, 7);
		animalArray[Animals.Fox - 1] = fox;
		
		Animal rabbit = new Animal("Rabbit",1.3, 1.1, 0.03, 0.011);
		rabbit.feedsOn(Food.Grain, 7);
		rabbit.feedsOn(Food.Water, 7);
		rabbit.feedsOn(Food.Carrot, 7);
		animalArray[Animals.Rabbit - 1] = rabbit;
		
		
		//end chagne
		return animalArray;
	}
	
	public static FoodSource[] getFoodSource(){
		FoodSource[] foodSourceArray = new FoodSource[numOfFoodSource];
		
		//change
		//Add food source , For unlimited growth rate pass -1
		FoodSource grass = new FoodSource("Grass", -1);
		FoodSource water = new FoodSource("Water", -1);
		FoodSource carrot = new FoodSource("Carrot", -1);
		FoodSource apple = new FoodSource("Apple", -1);
		
		foodSourceArray[Food.Grain - 1] = grass;
		foodSourceArray[Food.Water - 1] = water;
		foodSourceArray[Food.Carrot - 1] = carrot;
		foodSourceArray[Food.Apple - 1] = apple;
		
		
		//end change
		return foodSourceArray;
	}
	
	public static int scaleFactor = 50000;
}
