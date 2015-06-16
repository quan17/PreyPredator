
public class PreysOn {
	private int animal;
	private double fallHunt;
	private double winterHunt;
	private double springHunt;
	private double summerHunt;
	
	int getAnimal(){return animal;}
	double getHuntRate(int season){
		if (season == Seasons.FALL) return fallHunt;
		else if(season == Seasons.WINTER) return winterHunt;
		else if(season == Seasons.SPRING) return springHunt;
		else return summerHunt;
	}
	
	public PreysOn(int animal, double fallHuntRate, double winterHuntRate, double springHuntRate, double summerHuntRate){
		this.animal = animal;
		fallHunt = fallHuntRate;
		winterHunt = winterHuntRate;
		springHunt = springHuntRate;
		summerHunt = summerHuntRate;
	}
}
