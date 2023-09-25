package personnages;

public class Romain {
	private static final int NB_MAX_EQUIPEMENTS = 2;
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;
	
	public Romain(String nom, int force) {
		super();
		assert force > 0;
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[NB_MAX_EQUIPEMENTS];
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
	
	private void equiperRomain(Equipement e, int i) {
		equipements[i] = e;
		System.out.println("Le soldat " + this.nom + " s'équipe avec un " + e.getNom() + ".");
		nbEquipements += 1;
	}
	
	public void sEquiper(Equipement e) {
		switch (nbEquipements) {
		case 2: 
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == e) {
				System.out.println("Le soldat "+ this.nom + " possède déjà un " + e.getNom() + " !");	
			}
			else {
				equiperRomain(e, 1);
			}
			break;
		default:
			equiperRomain(e, 0);
		}
	}
	 public static void main(String[] args) {
		Romain marc = new Romain("Marc", 6);
		marc.prendreParole();
		marc.parler("Je parleeeee");
		marc.recevoirCoup(9);
		System.out.println(Equipement.CASQUE + " " + Equipement.BOUCLIER);
		marc.sEquiper(Equipement.CASQUE);
		marc.sEquiper(Equipement.CASQUE);
		marc.sEquiper(Equipement.BOUCLIER);
		marc.sEquiper(Equipement.CASQUE);
		
	}
}

