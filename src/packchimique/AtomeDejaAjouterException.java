package packchimique;

public class AtomeDejaAjouterException extends Exception {

	private static final long serialVersionUID = 1L;

	public AtomeDejaAjouterException(String atom) {
		super(atom + " est d�j� dans la table des elements !");
	}
}