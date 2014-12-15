package rest;


public class Formuletest {

	public static void main(String[] args) {
		
		double ArsenalOff = 703;
		double ArsenalDef = 658;
		double ArsenalEnd = 806;
		
		double ArsenalSum = 1361;
		
		double AstonVillaOff = 614;
		double AstonVillaDef = 649; 
		double AstonVillaEnd = 764;
		
		double AstonVillaSum = 1263;
		
		double a = 5000000;
		double b = 0.1;
		
		double ArsenalChance = 0;
		double AstonVillaChance = 0;
		
		double ArsenalGoals = 0;
		double AstonVillaGoals = 0;
		
		for (int i = 0; i<15; i++){
			ArsenalChance = ((ArsenalSum/AstonVillaSum)*Math.pow((ArsenalEnd/AstonVillaEnd),1+(i/a))*b);
			AstonVillaChance = ((AstonVillaSum/ArsenalSum)*Math.pow(AstonVillaEnd/ArsenalEnd,1+(i/a))*b);
			
			
			
			System.out.println(ArsenalChance);
			if (Math.random() < ArsenalChance){
				System.out.println("Arsenal gescoord!");
				ArsenalGoals++;
			}
			System.out.println(AstonVillaChance);
			if (Math.random() < AstonVillaChance){
				System.out.println("AstonVilla gescoord!");
				AstonVillaGoals++;
			}
		}
		System.out.println("MATCH FINISHEEEEEEEEED");
		System.out.println("A: "+ArsenalGoals+"\nAV: "+AstonVillaGoals);
	}

}
