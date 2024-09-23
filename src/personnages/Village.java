package personnages;

public class Village {
    private String nom;
    private Chef chef;
    private Gaulois[] villageois;
    private int nbVillageois;

	public Village(String nom, int nbVillageMax) {
		this.nom = nom;
        this.villageois = new Gaulois[nbVillageMax]; 
        this.nbVillageois = 0;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
    public void ajouterHabitant(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            nbVillageois++;
        } 
        else {

            System.out.println("Le village est plein !");
        }
    }

    public int getNbVillageois() {
        return nbVillageois;
    }
    
    public Gaulois trouverHabitant(int numero) {
        if (numero >= 0 && numero < nbVillageois) {
            return villageois[numero];
        } else {
            System.out.println("Numéro de villageois invalide.");
            return null;
        }
    }
    
    public void afficherVillageois() {
        if (chef != null) {
            System.out.println("Chef du village : " + chef.getNom());
        } else {
            System.out.println("Le village n'a pas de chef.");
        }
        
        if (nbVillageois > 0) {
            System.out.println("Villageois :");
            for (int i = 0; i < nbVillageois; i++) {
                System.out.println("- " + villageois[i].getNom());
            }
        } else {
            System.out.println("Il n'y a aucun villageois dans ce village.");
        }
    }
    
    
    public static void main(String[] args) {
        Village village = new Village("Village des Irréductibles",10);

        Chef abraracourcix = new Chef("Abraracourcix", 6, village);
        village.setChef(abraracourcix);


        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterHabitant(asterix);


        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterHabitant(obelix);
        village.afficherVillageois();

        Gaulois gaulois = village.trouverHabitant(1);
        System.out.println(gaulois);
    }
}
