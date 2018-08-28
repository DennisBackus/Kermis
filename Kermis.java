import java.util.ArrayList;
import java.util.Scanner;
public class Kermis {

	public static void main(String[] args) {
		Kermis kermis = new Kermis();
		kermis.startProgramma();

	}

	void startProgramma() {
		ArrayList<Attractie> attracties = new ArrayList();
		BotsAuto bots = new BotsAuto();
		attracties.add(bots);
		Spin spin = new Spin();
		attracties.add(spin);
		SpiegelPaleis spiegel = new SpiegelPaleis();
		attracties.add(spiegel);
		SpookHuis spook = new SpookHuis();
		attracties.add(spook);
		Hawaii hawaii = new Hawaii();
		attracties.add(hawaii);
		LadderKlimmen ladder = new LadderKlimmen();
		attracties.add(ladder);
		Kassa kassa = new Kassa(); 
		boolean finished = false; 
		while (!finished) {
			System.out.println(drawLine());
			System.out.println("Kies een attractie om in te gaan!");

			System.out.println("1. BotsAuto's ");
			System.out.println("2. Spin ");
			System.out.println("3. Spiegel Paleis ");
			System.out.println("4. Spookhuis");
			System.out.println("5. Hawaii");
			System.out.println("6. Ladder Klimmen");
			System.out.println("Voer o in voor de omzet");
			System.out.println("Voer k in voor het aantal verkochte kaartjes");
			String keuze = "";
			try {
				keuze = userInput();
				if(keuze.equals("o")) {
					System.out.println("De totale omzet is: " + kassa.getOmzet(attracties));
					System.out.println("Het totaal bedrag betaalde belasting is " + BelastingInspecteur.totaalBetaaldeBelasting);

				}

				else if (keuze.equals("k")) {
					System.out.println("Het totaal aantal verkochte kaartjes is: " + checkKaartjes(attracties));
				}

				else {
					int intKeuze = Integer.parseInt(keuze);
					System.out.println(attracties.get(intKeuze-1).draaien());
					if(Attractie.rondes == BelastingInspecteur.randomBezoek) {
						BelastingInspecteur.belastingInnen(attracties);
					}
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}

		}
	}

	String userInput() throws Exception {
		Scanner sc_input = new Scanner(System.in);
		String input = sc_input.nextLine();
		boolean legal = false;
		String[] allowedInput = {"1", "2", "3", "4", "5", "6", "o", "k"};
		for(int i =0; i < allowedInput.length; i++) {
			if(input.equals(allowedInput[i])) {
				System.out.println(">>" + allowedInput[i]);
				legal = true;
				break;
			}
		}
		if(!legal) {
			throw new Exception("Geen valid input! Probeer opnieuw.");
		}

		return input;

	}
	int checkKaartjes(ArrayList<Attractie> attracties) {
		int totalCount =0;
		for(int i=0; i<attracties.size(); i++) {
			System.out.println("De attractie " + attracties.get(i).naam + " heeft " + attracties.get(i).count + " kaartjes verkocht");
			totalCount += attracties.get(i).count;
		}
		return totalCount;
	}
	String drawLine() {
		return "--------------------------------------------------------------------------------";
	}

}
