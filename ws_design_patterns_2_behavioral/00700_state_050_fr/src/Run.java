interface IEventsPupitreTramway {
	public void arretUrgenceDeclenche();

	public void arretProchaineStationDeclenche();

	public void ouverturePorteDeclenche();
}

interface IEventsPupitreStation {
	public void arretDepuisStationDemande();

	public void tramwayPositionne();

	public void departAutorise();
}

interface IEventsControleTramway {
	public void ouvrirPortes();

	public void fermerPortes();

	public void stopperWagon();

	public void demarrerWagon();
}

interface EtatTramway {
	public void arretProchaineStationDemandee(AutomateTramway c);

	public void arretDepuisStationDemande(AutomateTramway c);

	public void tramwayPositionne(AutomateTramway c);

	public void departAutorise(AutomateTramway c);

	public void arretUrgenceDeclenche(AutomateTramway c);

	public void ouverturePorteDeclenche(AutomateTramway c);
}

class ControlesTramway implements IEventsControleTramway {
	public void ouvrirPortes() {
		System.out.println("Portes ouvertes.");
	}

	public void fermerPortes() {
		System.out.println("Portes fermées.");
	}

	public void stopperWagon() {
		System.out.println("Le tramway freine jusqu'à son arrêt.");
	}

	public void demarrerWagon() {
		System.out.println("Le tramway se lance en prenant de la vitesse.");
	}
}

class Tramway implements IEventsPupitreTramway, IEventsPupitreStation {
	public Tramway() {
		m_controlesWagon = new ControlesTramway();
		m_contexte = new AutomateTramway(m_controlesWagon);
	}

	public IEventsControleTramway controles() {
		return m_controlesWagon;
	}

	public void arretDepuisStationDemande() {
		m_contexte.arretDepuisStationDemande();
		System.out.println("Appel utilisateur d'un arrêt à la prochaine station depuis la station.");
	}

	public void tramwayPositionne() {
		m_contexte.tramwayPositionne();
	}

	public void departAutorise() {
		m_contexte.departAutorise();
	}

	public void arretUrgenceDeclenche() {
		m_contexte.arretUrgenceDeclenche();
	}

	public void arretProchaineStationDeclenche() {
		m_contexte.arretProchaineStationDeclenche();
		System.out.println("Appel utilisateur d'un arrêt à la prochaine station depuis le wagon.");
	}

	public void ouverturePorteDeclenche() {
		m_contexte.ouverturePorteDeclenche();
	}

	private AutomateTramway m_contexte;
	private IEventsControleTramway m_controlesWagon;
}

class AutomateTramway implements IEventsPupitreStation, IEventsPupitreTramway {
	public AutomateTramway(IEventsControleTramway referenceTram) {
		m_refCtrlTramway = referenceTram;
		m_possedeEtat = new EtatArretStation();
	}

	public IEventsControleTramway getControlesTramway() {
		return m_refCtrlTramway;
	}

	public void changerEtat(EtatTramway etat) {
		m_possedeEtat = etat;
	}

	public void arretUrgenceDeclenche() {
		m_possedeEtat.arretUrgenceDeclenche(this);
	}

	public void arretProchaineStationDeclenche() {
		m_possedeEtat.arretProchaineStationDemandee(this);
	}

	public void ouverturePorteDeclenche() {
		m_possedeEtat.ouverturePorteDeclenche(this);
	}

	public void arretDepuisStationDemande() {
		m_possedeEtat.arretDepuisStationDemande(this);
	}

	public void tramwayPositionne() {
		m_possedeEtat.tramwayPositionne(this);
	}

	public void departAutorise() {
		m_possedeEtat.departAutorise(this);
	}

	private IEventsControleTramway m_refCtrlTramway;
	private EtatTramway m_possedeEtat;
}

class EtatDeplacement implements EtatTramway {
	public void arretProchaineStationDemandee(AutomateTramway c) {
		c.changerEtat(new EtatArretImminent());
	}

	public void arretDepuisStationDemande(AutomateTramway c) {
		c.changerEtat(new EtatArretImminent());
	}

	public void arretUrgenceDeclenche(AutomateTramway c) {
		c.getControlesTramway().stopperWagon();
		c.changerEtat(new EtatArretUrgence(this));
	}

	public void tramwayPositionne(AutomateTramway c) {
		System.out.println("Station passée sans s'arrêter.");
	}

	public void ouverturePorteDeclenche(AutomateTramway c) {
		System.out.println("Ouverture porte impossible.");
	}

	public void departAutorise(AutomateTramway c) {
		/* RIEN */ }
}

class EtatArretUrgence implements EtatTramway {
	public EtatArretUrgence(EtatTramway etatPrecedent) {
		m_etatPrecedent = etatPrecedent;
		m_portesOUvertes = false;
	}

	public void arretUrgenceDeclenche(AutomateTramway c) {
		if (m_portesOUvertes)
			c.getControlesTramway().fermerPortes();
		c.getControlesTramway().demarrerWagon();
		c.changerEtat(m_etatPrecedent);
	}

	public void tramwayPositionne(AutomateTramway c) {
		/* RIEN */ }

	public void departAutorise(AutomateTramway c) {
		/* RIEN */ }

	public void arretProchaineStationDemandee(AutomateTramway c) {
		/* RIEN */ }

	public void arretDepuisStationDemande(AutomateTramway c) {
		/* RIEN */ }

	public void ouverturePorteDeclenche(AutomateTramway c) {
		c.getControlesTramway().ouvrirPortes();
		m_portesOUvertes = true;
	}

	private EtatTramway m_etatPrecedent;
	private boolean m_portesOUvertes;
}

class EtatArretImminent implements EtatTramway {
	public void arretUrgenceDeclenche(AutomateTramway c) {
		c.getControlesTramway().stopperWagon();
		c.changerEtat(new EtatArretUrgence(this));
	}

	public void tramwayPositionne(AutomateTramway c) {
		c.getControlesTramway().stopperWagon();
		c.changerEtat(new EtatArretStation());
	}

	public void ouverturePorteDeclenche(AutomateTramway c) {
		System.out.println("Ouverture porte impossible.");
	}

	public void arretProchaineStationDemandee(AutomateTramway c) {
		/* RIEN */ }

	public void departAutorise(AutomateTramway c) {
		/* RIEN */ }

	public void arretDepuisStationDemande(AutomateTramway c) {
		/* RIEN */ }
}

class EtatArretStation implements EtatTramway {
	public EtatArretStation() {
		m_demandeProchainArret = false;
	}

	public void arretProchaineStationDemandee(AutomateTramway c) {
		m_demandeProchainArret = true;
	}

	public void arretDepuisStationDemande(AutomateTramway c) {
		m_demandeProchainArret = true;
	}

	public void arretUrgenceDeclenche(AutomateTramway c) {
		c.getControlesTramway().stopperWagon();
		c.changerEtat(new EtatArretUrgence(this));
	}

	public void departAutorise(AutomateTramway c) {
		c.getControlesTramway().fermerPortes();
		c.getControlesTramway().demarrerWagon();
		if (m_demandeProchainArret)
			c.changerEtat(new EtatArretImminent());
		else
			c.changerEtat(new EtatDeplacement());
	}

	public void ouverturePorteDeclenche(AutomateTramway c) {
		c.getControlesTramway().ouvrirPortes();
	}

	public void tramwayPositionne(AutomateTramway c) {
		/* RIEN */ }

	private boolean m_demandeProchainArret;
}

public class Run {
	public static void main(String[] args) {
		Tramway tram = new Tramway();
		// On va simuler les évènements en les appelant manuellement.
		tram.arretDepuisStationDemande();
		tram.departAutorise();
		tram.tramwayPositionne();
		tram.ouverturePorteDeclenche();
		tram.departAutorise();
		tram.tramwayPositionne();
		tram.ouverturePorteDeclenche(); // Portes impossibles à ouvrir
		tram.tramwayPositionne();
		tram.arretUrgenceDeclenche();
		tram.ouverturePorteDeclenche();
		tram.arretUrgenceDeclenche();
		tram.arretProchaineStationDeclenche();
		tram.tramwayPositionne();
	}
}
