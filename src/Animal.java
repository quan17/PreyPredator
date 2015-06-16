import java.util.ArrayList;



public class Animal {
	private String name;
	private double aggressivity;
	private double evasiveness;
	private double birthRate;
	private double deathRate;
	private double springDisease = 0;
	private double winterDisease = 0;
	private double summerDisease = 0;
	private double fallDisease = 0;
	private ArrayList<PreysOn> preysOnAL = new ArrayList<PreysOn>();
	private ArrayList<FeedsOn> feedsOnAL = new ArrayList<FeedsOn>();
	
	String getName(){return name;}
	double getAggressivity(){return aggressivity;}
	double getEvasiveness(){return evasiveness;}
	double getBirthRate(){return birthRate;}
	double getDeathRate(){return deathRate;}
	ArrayList<PreysOn> getPreysOn(){return preysOnAL;}
	ArrayList<FeedsOn> getFeedsOn(){return feedsOnAL;}
	double getDisease(int season){
		if (season == Seasons.FALL) return fallDisease;
		else if(season == Seasons.WINTER) return winterDisease;
		else if(season == Seasons.SPRING) return springDisease;
		else return summerDisease;
	}
	
	public Animal(String name, double aggressivityFactor, double evasivenessFactor, double birthRate, double deathRate){
		this.name = name;
		aggressivity = aggressivityFactor;
		evasiveness = evasivenessFactor;
		this.birthRate = birthRate;
		this.deathRate = deathRate;
	}
	
	public void presyOn(int animal, double huntRate){
		this.presyOn(animal, huntRate, huntRate, huntRate, huntRate);
	}
	
	public void presyOn(int animal, double fallHuntRate, double winterHuntRate, double springHuntRate, double summerHuntRate){
		PreysOn preys = new PreysOn(animal, fallHuntRate, winterHuntRate, springHuntRate, summerHuntRate);
		preysOnAL.add(preys);
	}
	
	public void feedsOn(int food, double meal){
		this.feedsOn(food, meal, meal, meal, meal);
	}
	
	public void feedsOn(int food, double fallMeal, double winterMeal, double springMeal, double summerMeal){
		FeedsOn feeds = new FeedsOn(food, fallMeal, winterMeal, springMeal, summerMeal);
		feedsOnAL.add(feeds);
	}
	
	public void disease(double disease){
		this.disease(disease, disease, disease, disease);
	}
	
	public void disease(double fallDisease, double winterDisease, double springDisease, double summerDisease){
		this.fallDisease = fallDisease;
		this.winterDisease = winterDisease;
		this.springDisease = springDisease;
		this.summerDisease = summerDisease;
	}
	
	
}
