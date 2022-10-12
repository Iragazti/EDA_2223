package java;

import java.util.ArrayList;
import java.util.List;

public class ListaInterpretes {

    private List<Interprete> listaInterpretes;
        
        public ListaInterpretes()
        {
             listaInterpretes = new ArrayList<Interprete>();
        }

    /**
    * A�ade un int�rprete a la lista
    * @param inter Int�rprete a a�adir
    */
    public void anadirInterprete(Interprete inter) {
        listaInterpretes.add(inter);
    }

    /**
    * Busca un int�rprete en la lista y lo devuelve
    * @param nombre Nombre del int�rprete a buscar
    * @return el Interprete (si est� en la lista), null en caso contrario
    */
   
    public Interprete buscarInterprete(String nombre) {
        Interprete actual;
        for (int i = 0; i < listaInterpretes.size(); i++) {
                actual = listaInterpretes.get(i);
                if (actual.getNombre().equals(nombre)) {
                    return actual;
                }
        }
        return null;
    }
}
