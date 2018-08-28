import java.util.ArrayList;
import java.util.Random;

public class BelastingInspecteur {
	static double genomenBelasting;
	static Random ran = new Random();
	static int randomBezoek = ran.nextInt(15) +1;
	static double totaalBetaaldeBelasting;


	static double belastingInnen(ArrayList<Attractie> attracties){
		System.out.println("De belasting inspecteur is er.");
		genomenBelasting = 0;
		for(Attractie att : attracties) {
			if(att instanceof GokAttractie) {
				att.omzet -= att.alBelasteOmzet;
				genomenBelasting += (att.omzet*0.3);
				att.omzet *= 0.7;
				att.omzet += att.alBelasteOmzet;
				att.alBelasteOmzet = att.omzet;
			}
		}
		totaalBetaaldeBelasting += genomenBelasting;
		Kassa.belastingInspecteurCount++;
		System.out.println("De belasting is betaald. Het bedrag was " + genomenBelasting + " euro en is uit de kassa gehaald.");
		System.out.println("Het gereserveerde bedrag is weer gereset.");
		Attractie.rondes =0;
		randomBezoek = ran.nextInt(15) +1;
		return genomenBelasting;
	}
}
