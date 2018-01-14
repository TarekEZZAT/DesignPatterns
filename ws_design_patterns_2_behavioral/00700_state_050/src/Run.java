interface IEventsPupitreTramway {
	public void emergencyStopRequired();

	public void nextStopRequired();

	public void doorsOpening();
}

interface IEventsPupitreStation {
	public void stopRequestFromStop();

	public void tramTakesPosition();

	public void movingAllowed();
}

interface IEventsTramControls {
	public void doorsOpen();

	public void doorsClose();

	public void tramStops();

	public void tramMoves();
}

interface TramState {
	public void stopRequired(AutomateTramway c);

	public void stopRequiredFromStop(AutomateTramway c);

	public void tramTakesPosition(AutomateTramway c);

	public void movingAllowed(AutomateTramway c);

	public void emmergencyStopRequired(AutomateTramway c);

	public void doorsOpening(AutomateTramway c);
}

class TramControls implements IEventsTramControls {
	public void doorsOpen() {
		System.out.println("Doors opened.");
	}

	public void doorsClose() {
		System.out.println("Doors closed.");
	}

	public void tramStops() {
		System.out.println("Slow down to the stop.");
	}

	public void tramMoves() {
		System.out.println("Start moving and accelerating");
	}
}

class Tramway implements IEventsPupitreTramway, IEventsPupitreStation {
	public Tramway() {
		m_tramControl = new TramControls();
		m_context = new AutomateTramway(m_tramControl);
	}

	public IEventsTramControls controles() {
		return m_tramControl;
	}

	public void stopRequestFromStop() {
		m_context.stopRequestFromStop();
		System.out.println("User stop request from next stop.");
	}

	public void tramTakesPosition() {
		m_context.tramTakesPosition();
	}

	public void movingAllowed() {
		m_context.movingAllowed();
	}

	public void emergencyStopRequired() {
		m_context.emergencyStopRequired();
	}

	public void nextStopRequired() {
		m_context.nextStopRequired();
		System.out.println("User stop request from tram.");
	}

	public void doorsOpening() {
		m_context.doorsOpening();
	}

	private AutomateTramway m_context;
	private IEventsTramControls m_tramControl;
}

class AutomateTramway implements IEventsPupitreStation, IEventsPupitreTramway {
	public AutomateTramway(IEventsTramControls referenceTram) {
		m_TramRefControl = referenceTram;
		m_hasState = new EtatArretStation();
	}

	public IEventsTramControls getControlesTramway() {
		return m_TramRefControl;
	}

	public void changerEtat(TramState etat) {
		m_hasState = etat;
	}

	public void emergencyStopRequired() {
		m_hasState.emmergencyStopRequired(this);
	}

	public void nextStopRequired() {
		m_hasState.stopRequired(this);
	}

	public void doorsOpening() {
		m_hasState.doorsOpening(this);
	}

	public void stopRequestFromStop() {
		m_hasState.stopRequiredFromStop(this);
	}

	public void tramTakesPosition() {
		m_hasState.tramTakesPosition(this);
	}

	public void movingAllowed() {
		m_hasState.movingAllowed(this);
	}

	private IEventsTramControls m_TramRefControl;
	private TramState m_hasState;
}

class EtatDeplacement implements TramState {
	public void stopRequired(AutomateTramway c) {
		c.changerEtat(new EtatArretImminent());
	}

	public void stopRequiredFromStop(AutomateTramway c) {
		c.changerEtat(new EtatArretImminent());
	}

	public void emmergencyStopRequired(AutomateTramway c) {
		c.getControlesTramway().tramStops();
		c.changerEtat(new EtatArretUrgence(this));
	}

	public void tramTakesPosition(AutomateTramway c) {
		System.out.println("Stop ignored.");
	}

	public void doorsOpening(AutomateTramway c) {
		System.out.println("Doors open impossible.");
	}

	public void movingAllowed(AutomateTramway c) {
		/* NOTHING */ }
}

class EtatArretUrgence implements TramState {
	public EtatArretUrgence(TramState etatPrecedent) {
		m_etatPrecedent = etatPrecedent;
		m_portesOUvertes = false;
	}

	public void emmergencyStopRequired(AutomateTramway c) {
		if (m_portesOUvertes)
			c.getControlesTramway().doorsClose();
		c.getControlesTramway().tramMoves();
		c.changerEtat(m_etatPrecedent);
	}

	public void tramTakesPosition(AutomateTramway c) {
		/* NOTHING */ }

	public void movingAllowed(AutomateTramway c) {
		/* NOTHING */ }

	public void stopRequired(AutomateTramway c) {
		/* NOTHING */ }

	public void stopRequiredFromStop(AutomateTramway c) {
		/* NOTHING */ }

	public void doorsOpening(AutomateTramway c) {
		c.getControlesTramway().doorsOpen();
		m_portesOUvertes = true;
	}

	private TramState m_etatPrecedent;
	private boolean m_portesOUvertes;
}

class EtatArretImminent implements TramState {
	public void emmergencyStopRequired(AutomateTramway c) {
		c.getControlesTramway().tramStops();
		c.changerEtat(new EtatArretUrgence(this));
	}

	public void tramTakesPosition(AutomateTramway c) {
		c.getControlesTramway().tramStops();
		c.changerEtat(new EtatArretStation());
	}

	public void doorsOpening(AutomateTramway c) {
		System.out.println("Ouverture porte impossible.");
	}

	public void stopRequired(AutomateTramway c) {
		/* NOTHING */ }

	public void movingAllowed(AutomateTramway c) {
		/* NOTHING */ }

	public void stopRequiredFromStop(AutomateTramway c) {
		/* NOTHING */ }
}

class EtatArretStation implements TramState {
	public EtatArretStation() {
		m_nextStopRequired = false;
	}

	public void stopRequired(AutomateTramway c) {
		m_nextStopRequired = true;
	}

	public void stopRequiredFromStop(AutomateTramway c) {
		m_nextStopRequired = true;
	}

	public void emmergencyStopRequired(AutomateTramway c) {
		c.getControlesTramway().tramStops();
		c.changerEtat(new EtatArretUrgence(this));
	}

	public void movingAllowed(AutomateTramway c) {
		c.getControlesTramway().doorsClose();
		c.getControlesTramway().tramMoves();
		if (m_nextStopRequired)
			c.changerEtat(new EtatArretImminent());
		else
			c.changerEtat(new EtatDeplacement());
	}

	public void doorsOpening(AutomateTramway c) {
		c.getControlesTramway().doorsOpen();
	}

	public void tramTakesPosition(AutomateTramway c) {
		/* NOTHING */ }

	private boolean m_nextStopRequired;
}

public class Run {
	public static void main(String[] args) {
		Tramway tram = new Tramway();
		// On va simuler les évènements en les appelant manuellement.
		tram.stopRequestFromStop();
		tram.movingAllowed();
		tram.tramTakesPosition();
		tram.doorsOpening();
		tram.movingAllowed();
		tram.tramTakesPosition();
		tram.doorsOpening(); // Portes impossibles à ouvrir
		tram.tramTakesPosition();
		tram.emergencyStopRequired();
		tram.doorsOpening();
		tram.emergencyStopRequired();
		tram.nextStopRequired();
		tram.tramTakesPosition();
	}
}
