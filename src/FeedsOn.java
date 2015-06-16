
public class FeedsOn {
	private int food;
	private double fallMeal;
	private double winterMeal;
	private double springMeal;
	private double summerMeal;
	
	int getFood(){return food;}
	double getMeal(int season){
		if (season == Seasons.FALL) return fallMeal;
		else if(season == Seasons.WINTER) return winterMeal;
		else if(season == Seasons.SPRING) return springMeal;
		else return summerMeal;
	}
	
	public FeedsOn(int food, double fallMeal, double winterMeal, double springMeal, double summerMeal){
		this.food = food;
		this.fallMeal = fallMeal;
		this.winterMeal = winterMeal;
		this.springMeal = springMeal;
		this.summerMeal = summerMeal;
	}
}
