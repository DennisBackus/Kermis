import java.util.ArrayList;

public class Kassa {
	static double totaleOmzet;
	double getOmzet(ArrayList<Attractie> attracties){
		for(int i =0; i < attracties.size(); i++) {
			System.out.println("De omzet van " + attracties.get(i).naam + " is " + attracties.get(i).omzet);
			totaleOmzet += attracties.get(i).omzet;
		}
		return totaleOmzet;
	}
}
