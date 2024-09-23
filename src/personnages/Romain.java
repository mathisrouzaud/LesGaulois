package personnages;

public class Romain {
	private String nom;
	private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipements = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
    public void sEquiper(Equipement equipement) {
        switch (nbEquipements) {
            case 0:
            case 1:
                if (contientDeja(equipement)) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + "!");
                } else {
                    equipements[nbEquipements] = equipement;
                    nbEquipements++;
                    System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
                }
                break;
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
        }
    }

    private boolean contientDeja(Equipement equipement) {
        for (Equipement equipementActuel : equipements) {
            if (equipementActuel != null && equipementActuel.equals(equipement)) {
                return true;
            }
        }
        return false;
    }

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
    public static void main(String[] args) {
       Romain minus = new Romain("Minus",4);
       minus.sEquiper(Equipement.CASQUE);
       minus.sEquiper(Equipement.CASQUE);
       minus.sEquiper(Equipement.BOUCLIER);
       minus.sEquiper(Equipement.BOUCLIER);
    }
}