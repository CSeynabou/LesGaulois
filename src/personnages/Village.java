package personnages;

import java.util.Iterator;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village (String nom, int nbVillageoisMaximum) {
		this.nom = nom;	
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public boolean ajouterHabitant(Gaulois g) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = g;
			nbVillageois += 1;
			return true;
		}
		return false;
	}
	
	public Gaulois trouverHabitant(int numEntree) {
		return villageois[numEntree];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans village du chef "+ chef.getNom() + " vivent les légendaires gaulois : ");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- "+ trouverHabitant(i).getNom());	
		}
	}
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
// 		la case d'indice 30 du tableau village n'existe pas
//		 le nb maximum de villageois est 30 
//		donc la dernière cas est d'indice 29
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		affiche null
//		asterix se troube à la case d'indice 0
		Gaulois obelix = new Gaulois ("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
