package fase2;

import java.util.ArrayList;
import java.util.List;

public class ListaInterpretes {

    private List<Interprete> listaInterpretes;
    private int size = 0;
        
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
        size += 1;
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
    public int getSize(){
        return this.size;
    }
    public Interprete getInterprete(int index){
        return this.listaInterpretes.get(index);
    }
}
