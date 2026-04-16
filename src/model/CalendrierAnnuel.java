package model;

public class CalendrierAnnuel {
	private Mois[] calendrier = new Mois[12];
	
	private static class Mois {
		private String nom;
		private boolean[] jours;
		
		private Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
		}
		
		private boolean estLibre(int jour) {
			return !jours[jour -1];
		}
		
		private void reserver(int jour) {
			if (!estLibre(jour)) {
				throw new IllegalStateException();
			} 
			jours[jour-1] = true;
		}
	}
	
	public CalendrierAnnuel() {
		String[] noms = {
			    "Janvier", "Février", "Mars", "Avril", "Mai", "Juin",
			    "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"
			};
			int[] jours = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

			for (int i = 0; i < 12; i++) {
			    calendrier[i] = new Mois(noms[i], jours[i]);
			}
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour);
	}
	
	public boolean reserver(int jour, int mois) {
		if (estLibre(jour, mois)) {
			calendrier[mois-1].reserver(jour);
			return true;
		} else {
			return false;
		}
		
	}
}
