package packchimique;

public class AtomeInexistantException extends Exception {

	private static final long serialVersionUID = 1L;

	public AtomeInexistantException(String atom) {
		super(atom + " ne fait pas partie des elements du tableau periodique !");
	}
}