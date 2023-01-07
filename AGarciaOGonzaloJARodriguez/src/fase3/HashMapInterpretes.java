package fase3;

import java.util.HashMap;

public class HashMapInterpretes implements InterfazInterpretes {
    private HashMap<String,Interprete> mapa;

    public HashMapInterpretes(){
        this.mapa= new HashMap<String,Interprete>();
    }
    public void anadirInterprete(Interprete inter){
        mapa.put(inter.getNombre(),inter);

    }
    //////se hacen con pruebas lineales?
	public Interprete buscarInterprete (String sNombre){
        return mapa.get(sNombre);
    }
	public Interprete eliminarInterprete(String nombre){
        return mapa.remove(nombre);
    }

    //// estas no se como se hacen
    public int size(){
        return 0;

    }
	public boolean isEmpty(){
        return false;
    }
}
