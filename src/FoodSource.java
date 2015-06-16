
public class FoodSource {
	private String name;
	private double fallGrowth;
	private double winterGrowth;
	private double summerGrowth;
	private double springGrowth;
	
	String getName(){return name;}
	double getGrowthRate(int season){
		if (season == Seasons.FALL) return fallGrowth;
		else if(season == Seasons.WINTER) return winterGrowth;
		else if(season == Seasons.SPRING) return springGrowth;
		else return summerGrowth;
	}
	
	public FoodSource(String name, double growthRate){
		this(name,growthRate,growthRate,growthRate,growthRate);
	}
	
	public FoodSource(String name, double fallGrowthRate, double winterGrowthRate, double springGrowthRate, double summerGrowthRate){
		this.name = name;
		fallGrowth = fallGrowthRate;
		winterGrowth = winterGrowthRate;
		summerGrowth = summerGrowthRate;
		springGrowth = springGrowthRate;
	}
}
