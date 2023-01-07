package fase3;

import java.util.HashMap;
import java.util.Map;

public class HashMapInterpretes implements InterfazInterpretes {
    private Map<String,Interprete> mapa;

    public HashMapInterpretes(){
        this.mapa= new HashMap<String,Interprete>();
    }
    public void anadirInterprete(Interprete inter){
        mapa.put(inter.getNombre(),inter);

    }
    //mapa.get ya tiene internamente la prueba lineal
	public Interprete buscarInterprete (String sNombre){
        return mapa.get(sNombre);
    }
	public Interprete eliminarInterprete(String nombre){
        return mapa.remove(nombre);
    }

    public int size(){
        return mapa.size();

    }
	public boolean isEmpty(){
        return mapa.isEmpty();
    }
}
