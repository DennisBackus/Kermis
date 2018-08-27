
public abstract class Attractie {
	static int kaartjesCount;
	int count;
	String naam = "";
	float price;
	double oppervlakte;
	double omzet;
	double kansSpelBelasting;
	String draaien(){

		return "" + naam +  " staat nu aan";
	}
}
abstract class RisicoRijkeAttractie extends Attractie{
	int draaiLimiet;
	boolean opstellingsKeuring(){

		return false;
	}
}
interface GokAttractie{

	void kansSpelBelastingBetalen();

}
class BotsAuto extends Attractie{

	String draaien(){
		count++;
		kaartjesCount++;
		this.omzet = count * price;
		return "" + naam +  " staat nu aan en is al " + count + " keer aan geweest";
	}
	BotsAuto(){
		naam = "BotsAuto's";
		price = 2.50f;


	}
}

class Spin extends RisicoRijkeAttractie{
	int draaiLimiet = 5;
	String draaien(){
		count++;
		kaartjesCount++;
		this.omzet = count * price;
		return "" + naam +  " staat nu aan en is al "  + count + " keer aan geweest";
	}
	boolean opstellingsKeuring() {
		if(count != 0 && count % draaiLimiet == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	Spin(){
		naam = "Spin";
		price = 2.25f;
	}

}

class SpiegelPaleis extends Attractie{

	String draaien(){
		count++;
		kaartjesCount++;
		this.omzet = count * price;
		return "" + naam +  " staat nu aan";
	}
	SpiegelPaleis(){
		naam = "SpiegelPaleis";
		price = 2.75f;
	}
}

class SpookHuis extends Attractie{
	String draaien(){
		count++;
		kaartjesCount++;
		this.omzet = count * price;
		return "" + naam +  " staat nu aan";
	}
	SpookHuis(){
		naam = "SpookHuis";
		price = 3.20f;
	}
}

class Hawaii extends RisicoRijkeAttractie{
	int draaiLimiet =10;
	String draaien(){
		count++;
		kaartjesCount++;
		this.omzet = count * price;
		return "" + naam +  " staat nu aan";
	}
	boolean opstellingsKeuring() {
		if(count != 0 && count % draaiLimiet == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	Hawaii(){
		naam = "Hawaii";
		price = 2.90f;
	}
}

class LadderKlimmen extends Attractie implements GokAttractie{


	String draaien(){
		count++;
		kaartjesCount++;
		this.omzet = count * price;
		kansSpelBelastingBetalen();
		return "" + naam +  " staat nu aan";
	}
	LadderKlimmen(){
		naam = "Ladder Klimmen";
		price = 5.00f;
	}
	@Override
	public void kansSpelBelastingBetalen() {
		this.kansSpelBelasting = this.omzet * 0.3;
		this.omzet *= 0.7;

	}
}