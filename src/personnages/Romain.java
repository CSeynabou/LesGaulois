package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		super();
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;				
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+ "" + texte + "");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forceDebut = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		}else {
			parler("J'abandonne ...");
		}
		assert force < forceDebut;
	}	
	
	 public static void main(String[] args) {
		Romain marc = new Romain("Marc", 6);
		marc.prendreParole();
		marc.parler("Je parleeeee");
		marc.recevoirCoup(9);
		
	}
}

