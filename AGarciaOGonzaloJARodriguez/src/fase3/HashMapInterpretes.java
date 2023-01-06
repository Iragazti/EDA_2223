package fase3;

import java.util.HashMap;
import java.util.Map;

public class HashMapInterpretes implements InterfazInterpretes{
    private Map<String,Interprete> tabla;
    public HashMapInterpretes(){
        this.tabla = new HashMap<String,Interprete>();
    }
    public void anadirInterprete(Interprete inter){
        this.tabla.put(inter.getNombre(), inter);
    }
	public Interprete buscarInterprete (String sNombre){
        return this.tabla.get(sNombre);
    }
	public Interprete eliminarInterprete(String nombre){
        Interprete interprete = this.tabla.get(nombre);
        this.tabla.put(interprete.getNombre(), null);
        return interprete;
    }
    public int size(){
        return this.tabla.size();
    }
	public boolean isEmpty(){
        return this.tabla.isEmpty();
    }
}
