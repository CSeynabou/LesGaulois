package personnages;

import musee.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement[] trophees; 

	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
		trophees = new Equipement[100];
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "" + texte + "");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : "; 
//	}
	private String prendreParole() {
		return "Le gaulois " + this.nom + " : ";
		}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force*effetPotion/3);
//	}
//	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement nvTrophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; nvTrophees != null && i < nvTrophees.length; i++, nbTrophees++) {
		this.trophees[nbTrophees] = nvTrophees[i];
		}
		}

	public void boirePotion(int forcePotion){
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois décuplée.");

	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees != 0) {
			this.parler("Je donne au musee tous mes trophees : ");
			while(nbTrophees != 0) {
				musee.donnerTrophees(this, trophees[nbTrophees]);
				System.out.println(" - "+ trophees[nbTrophees].getNom());
				nbTrophees--;
			}
			}
		}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Yihouuuuu");
		//asterix.frapper(marc);
		asterix.boirePotion(3);
		}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getNbTrophees() {
		return nbTrophees;
	}

	public void setNbTrophees(int nbTrophees) {
		this.nbTrophees = nbTrophees;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	}
	


