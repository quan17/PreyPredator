import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PreyPredator extends JFrame{
	public static void main(String[] args) {
		new PreyPredator().setVisible(true);
	}
	
	private PreyPredator(){
		super("Prey-Predator");
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		inputJP = new JPanel();
		resultJP = new JPanel();
		resultJP.setLayout(new GridLayout(2, 1));
		addButtons();
	}
	
	private void addButtons(){
		inputJP.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel lenLable = new JLabel("Simulation Lenght(in week): ");
		lenLable.setFont(font);
		JLabel startLable = new JLabel("Start month: ");
		startLable.setFont(font);
		simLenTF = new JTextField(10);
		simLenTF.setFont(font);
		simStartCB = new JComboBox(monthList);
		simStartCB.setFont(font);
		
		int y = 0;
		gbc.gridx = 0;
		gbc.gridy = y;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		inputJP.add(lenLable,gbc);
		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.WEST;
		inputJP.add(simLenTF,gbc);
		
		y++;
		gbc.gridx = 0;
		gbc.gridy = y;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		inputJP.add(startLable,gbc);
		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.WEST;
		inputJP.add(simStartCB,gbc);
		
		JLabel animalTitle = new JLabel("Animal Start Population");
		animalTitle.setFont(font);
		y += 2;
		gbc.gridx = 0;
		gbc.gridy = y;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(25, 0, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		inputJP.add(animalTitle,gbc);
	
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridwidth = 1;
		int k=0;
		for(int i = 0; i < Ecosystem.numOfAnimals; i++){
			
			if ((i%2) == 0){y++; k = 0;}
			
			JLabel jb = new JLabel(animalEco[i].getName() + ": ");
			jb.setFont(font);
			animalStartValue[i] = new JTextField(10);
			animalStartValue[i].setFont(font);
			
			gbc.gridx = k;
			gbc.gridy = y;
			gbc.anchor = GridBagConstraints.EAST;
			inputJP.add(jb,gbc);
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx = k + 1;
			inputJP.add(animalStartValue[i],gbc);
			
			k = 2;
		}
		
		if (Ecosystem.numOfAnimals > 0){
			
			JLabel foodTitle = new JLabel("Food Source Start Value");
			foodTitle.setFont(font);
			y += 2;
			gbc.gridx = 0;
			gbc.gridy = y;
			gbc.gridwidth = 4;
			gbc.insets = new Insets(25, 0, 0, 0);
			gbc.anchor = GridBagConstraints.CENTER;
			inputJP.add(foodTitle,gbc);
			
			gbc.gridwidth = 1;
			gbc.insets = new Insets(0, 0, 0, 0);
			k = 0;
			for (int i= 0; i < Ecosystem.numOfFoodSource; i++){
				
				if ((i%2) == 0){y++; k = 0;}
				JLabel jb = new JLabel(foodSourceEco[i].getName() + ": ");
				jb.setFont(font);
				foodStartValue[i] = new JTextField(10);
				foodStartValue[i].setFont(font);
				
				gbc.gridx = k;
				gbc.gridy = y;
				gbc.anchor = GridBagConstraints.EAST;
				inputJP.add(jb,gbc);
				gbc.anchor = GridBagConstraints.WEST;
				gbc.gridx = k + 1;
				inputJP.add(foodStartValue[i],gbc);
				
				k = 2;
			}
		}
		
		JButton startJB = new JButton("Start Simulation");
		startJB.setFont(font);
		JButton clearJB = new JButton("Clear Values");
		clearJB.setFont(font);
		
		
		clearJB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearValue();
			}
		});
		
		startJB.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startSimu();
			}
		});

		y += 2;
		
		gbc.gridx = 0;
		gbc.gridy = y;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(25, 0, 0, 0);
		gbc.anchor = GridBagConstraints.WEST;
		inputJP.add(clearJB,gbc);
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.EAST;
		inputJP.add(startJB,gbc);

		clearValue();
		add(inputJP);
	}
	
	private void clearValue(){
		simLenTF.setText("0");
		simStartCB.setSelectedIndex(0);
		
		for(int i = 0; i < Ecosystem.numOfAnimals; i++){
			animalStartValue[i].setText("0");
		}
		
		for (int i= 0; i < Ecosystem.numOfFoodSource; i++){
			foodStartValue[i].setText("0");
		}
	}
	
	private void startSimu(){
		simulationLength = Integer.parseInt(simLenTF.getText());
		population = new Population(simulationLength);
		
		int index = simStartCB.getSelectedIndex();
		if (index == 0){season = Seasons.WINTER; seasonWeekCount = 4;}
		else if (index == 1){season = Seasons.WINTER; seasonWeekCount = 8;}
		else if (index == 2){season = Seasons.SPRING; seasonWeekCount = 0;}
		else if (index == 3){season = Seasons.SPRING; seasonWeekCount = 4;}
		else if (index == 4){season = Seasons.SPRING; seasonWeekCount = 8;}
		else if (index == 5){season = Seasons.SUMMER; seasonWeekCount = 0;}
		else if (index == 6){season = Seasons.SUMMER; seasonWeekCount = 4;}
		else if (index == 7){season = Seasons.SUMMER; seasonWeekCount = 8;}
		else if (index == 8){season = Seasons.SPRING; seasonWeekCount = 0;}
		else if (index == 9){season = Seasons.SPRING; seasonWeekCount = 4;}
		else if (index == 10){season = Seasons.SPRING; seasonWeekCount = 8;}
		else if (index == 11){season = Seasons.WINTER; seasonWeekCount = 0;}
		
		for(int i = 0; i < Ecosystem.numOfAnimals; i++){
			population.setAnimla(i+1, 0, Integer.parseInt(animalStartValue[i].getText()));
		}
		
		for (int i= 0; i < Ecosystem.numOfFoodSource; i++){
			population.setFoodSource(i+1, 0, Integer.parseInt(foodStartValue[i].getText()));
		}
		
		for (int i = 1; i <= simulationLength; i++){
			if (seasonWeekCount == weekInSeason){
				if (season == 4) season = 1;
				else season++;
				seasonWeekCount = 1;
			}
			else seasonWeekCount++;
			
			population = Calculation.Week(animalEco, foodSourceEco, population, season, i);
		}
		
		System.out.println(population.getAnimal(1, 0));
		System.out.println(population.getAnimal(1, 1));
		
		remove(inputJP);
		showResult();
		revalidate();
	}
	
	private void showResult(){
		resultJP.removeAll();
		JPanel chart = Graph.chartPanel(population, simulationLength,animalEco,foodSourceEco);
		resultJP.add(chart);
		
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int y = 0;
		
		JLabel animalTitle = new JLabel("Animals");
		animalTitle.setFont(font);
		y += 2;
		gbc.gridx = 0;
		gbc.gridy = y;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(25, 0, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		jp.add(animalTitle,gbc);
	
		gbc.insets = new Insets(0, 10, 0, 0);
		gbc.gridwidth = 1;
		int k=0;
		for(int i = 0; i < Ecosystem.numOfAnimals; i++){
			
			if ((i%2) == 0){y++; k = 0;gbc.insets = new Insets(0, 0, 0, 0);}
			else {gbc.insets = new Insets(0, 25, 0, 0);}
			
			JLabel jb = new JLabel(animalEco[i].getName() + ": ");
			jb.setFont(font);
			
			String startValue =  Integer.toString((int)( Math.round(population.getAnimal(i+1, 0))));
			String endValue = Integer.toString((int)( Math.round(population.getAnimal(i+1, simulationLength))));
			JLabel resultjb = new JLabel(startValue + " -> " + endValue);
			resultjb.setFont(font);
			
			gbc.gridx = k;
			gbc.gridy = y;
			gbc.anchor = GridBagConstraints.EAST;
			jp.add(jb,gbc);
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx = k + 1;
			jp.add(resultjb,gbc);
			
			k = 2;
		}
		
		if (Ecosystem.numOfAnimals > 0){
			
			JLabel foodTitle = new JLabel("Food Source ");
			foodTitle.setFont(font);
			y += 2;
			gbc.gridx = 0;
			gbc.gridy = y;
			gbc.gridwidth = 4;
			gbc.insets = new Insets(10, 0, 0, 0);
			gbc.anchor = GridBagConstraints.CENTER;
			jp.add(foodTitle,gbc);
			
			gbc.gridwidth = 1;
			gbc.insets = new Insets(0, 0, 0, 0);
			k = 0;
			for (int i= 0; i < Ecosystem.numOfFoodSource; i++){
				
				if ((i%2) == 0){y++; k = 0;gbc.insets = new Insets(0, 0, 0, 0);}
				else {gbc.insets = new Insets(0, 25, 0, 0);}
				
				JLabel jb = new JLabel(foodSourceEco[i].getName() + ": ");
				jb.setFont(font);
				
				String startValue =  Integer.toString((int)( Math.round(population.getFoodSource(i+1, 0))));
				String endValue = Integer.toString((int)( Math.round(population.getFoodSource(i+1, simulationLength))));
				JLabel resultjb = new JLabel(startValue + " -> " + endValue);
				resultjb.setFont(font);
				
				gbc.gridx = k;
				gbc.gridy = y;
				gbc.anchor = GridBagConstraints.EAST;
				jp.add(jb,gbc);
				gbc.anchor = GridBagConstraints.WEST;
				gbc.gridx = k + 1;
				jp.add(resultjb,gbc);
				
				k = 2;
			}
		}
		
		

		
		JButton resimJB = new JButton("ReSimulate");
		resimJB.setFont(font);
		resimJB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(resultJP);
				add(inputJP);
				revalidate();
				repaint();
			}
		});
		
		y++;
		gbc.gridx = 0;
		gbc.gridy = y;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(25, 0, 0, 0);
		gbc.anchor = GridBagConstraints.EAST;
		jp.add(resimJB, gbc);
		
		resultJP.add(jp);
		add(resultJP);
	}
	
	private JPanel inputJP;
	private JPanel resultJP;
	
	private Animal[] animalEco = Ecosystem.getAnimal();;
	private FoodSource[] foodSourceEco = Ecosystem.getFoodSource();
	private JTextField simLenTF;
	private JComboBox simStartCB;
	private String[] monthList = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private JTextField[] animalStartValue = new JTextField[Ecosystem.numOfAnimals];
	private JTextField[] foodStartValue = new JTextField[Ecosystem.numOfFoodSource];
	private Font font = new Font("Monospaced", Font.BOLD, 24);
	private int width = 800;
	private int height = 800;
	
	private int simulationLength;
	private int season = Seasons.FALL;
	private int weekInSeason = 12;
	private int seasonWeekCount = 0;
	private Population population;
}
