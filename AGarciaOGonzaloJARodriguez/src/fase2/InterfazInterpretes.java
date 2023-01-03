package fase2;

public interface InterfazInterpretes {

	public void anadirInterprete(Interprete inter);
	public Interprete buscarInterprete (String sNombre);
	public Interprete eliminarInterprete(String nombre);
    public int size();
	public boolean isEmpty();
}
