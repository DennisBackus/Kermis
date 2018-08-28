import java.util.Scanner;

public abstract class Attractie {
	static int kaartjesCount;
	static int rondes;
	int count;
	String naam = "";
	float price;
	double oppervlakte;
	double omzet;
	double alBelasteOmzet;
	boolean moetReparatie;

	String draaien(){
		count++;
		kaartjesCount++;
		rondes++;
		this.omzet += price;
		return "" + naam +  " staat nu aan en is al " + count + " keer aan geweest";
	}
}
abstract class RisicoRijkeAttractie extends Attractie{

	int draaiLimiet=0;


	String draaien() {
		try {
			opstellingsKeuring();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Druk op M om een monteur te roepen");
			Scanner sc_input = new Scanner(System.in);
			while(moetReparatie) {
				String input = sc_input.nextLine();
				if(input.equals("m")) {
					moetReparatie = false; 
					System.out.println("De monteur heeft " + naam + " succesvol gerepareerd");
				}
				else {
					System.out.println("Dat is niet de monteur");
				}
			}
		}
		finally {
			super.draaien();
		}
		return ""+ naam +  " staat nu aan en is al " + count + " keer aan geweest";
	}
	void opstellingsKeuring() throws Exception{
		if(count != 0 && count % draaiLimiet == 0) {
			moetReparatie = true;
			throw new Exception("Draai limiet bereikt");
		}

	}
}
interface GokAttractie{

}
class BotsAuto extends Attractie{

	BotsAuto(){
		naam = "BotsAuto's";
		price = 2.50f;


	}
}

class Spin extends RisicoRijkeAttractie implements GokAttractie{

	String draaien(){
		return super.draaien();
	}

	void opstellingsKeuring() throws Exception {
		super.opstellingsKeuring();
	}
	Spin(){
		naam = "Spin";
		price = 2.25f;
		draaiLimiet = 5;
	}

}

class SpiegelPaleis extends Attractie{

	SpiegelPaleis(){
		naam = "SpiegelPaleis";
		price = 2.75f;
	}
}

class SpookHuis extends Attractie{
	SpookHuis(){
		naam = "SpookHuis";
		price = 3.20f;
	}
}

class Hawaii extends RisicoRijkeAttractie{
	String draaien(){
		return super.draaien();
	}

	void opstellingsKeuring() throws Exception {
		super.opstellingsKeuring();
	}

	Hawaii(){
		naam = "Hawaii";
		price = 2.90f;
		draaiLimiet =10;
	}
}

class LadderKlimmen extends Attractie implements GokAttractie{


	String draaien(){
		count++;
		kaartjesCount++;
		rondes++;
		this.omzet = count * price;
		return "" + naam +  " staat nu aan";
	}
	LadderKlimmen(){
		naam = "Ladder Klimmen";
		price = 5.00f;
	}

}
