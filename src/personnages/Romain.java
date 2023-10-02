package personnages;

public class Romain {
	private static final int NB_MAX_EQUIPEMENTS = 2;
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;
	
	public Romain(String nom, int force) {
		super();
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
	
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public Equipement[] getEquipements() {
		return equipements;
	}

	public void setEquipements(Equipement[] equipements) {
		this.equipements = equipements;
	}

	public int getNbEquipements() {
		return nbEquipements;
	}

	public void setNbEquipements(int nbEquipements) {
		this.nbEquipements = nbEquipements;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipements; i++) {
			if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
				resistanceEquipement += 8;
			} else {
				System.out.println("Equipement casque");
				resistanceEquipement += 5;
			}
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] == null) {
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
		}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forceDebut = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		}else {
//			parler("J'abandonne ...");
//		}
//		assert force < forceDebut;
//	}	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		if (force>forceCoup) {
			force -= forceCoup;
		} else {
			force = 0;
		}
		
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
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

