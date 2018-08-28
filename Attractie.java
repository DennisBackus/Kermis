
public abstract class Attractie {
	static int kaartjesCount;
	static int rondes;
	int count;
	String naam = "";
	float price;
	double oppervlakte;
	double omzet;
	double alBelasteOmzet;

	String draaien(){
		count++;
		kaartjesCount++;
		rondes++;
		this.omzet = count * price;
		return "" + naam +  " staat nu aan en is al " + count + " keer aan geweest";
	}
}
abstract class RisicoRijkeAttractie extends Attractie{

	int draaiLimiet=0;
	
	String draaien() {
		if(opstellingsKeuring()) {
			return "" + naam + " moet gekeurd worden, draailimiet is bereikt";
		}
		else {
			return	super.draaien();
		}
	}
	boolean opstellingsKeuring() {
		if(count != 0 && count % draaiLimiet == 0) {
			return true;
		}
		else {
			return false;
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

		boolean opstellingsKeuring() {
			return super.opstellingsKeuring();
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

		boolean opstellingsKeuring() {
			return super.opstellingsKeuring();
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
