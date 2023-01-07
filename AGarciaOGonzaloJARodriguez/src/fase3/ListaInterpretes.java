package fase3;

import java.util.ArrayList;
import java.util.List;

//import javax.swing.text.StyledEditorKit.BoldAction;

public class ListaInterpretes implements InterfazInterpretes{

    private List<Interprete> listaInterpretes;
    private int size;
        
        public ListaInterpretes()
        {
             listaInterpretes = new ArrayList<Interprete>();
             size = 0;
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
    public boolean isEmpty(){
        return this.size == 0;
    }
    public int size(){
        return this.size;
    }
    public Interprete getInterprete(int index){
        return this.listaInterpretes.get(index);
    }
    public Interprete eliminarInterprete(String inter){
        Interprete interprete = buscarInterprete(inter);
        if (interprete != null) {
            this.listaInterpretes.remove(interprete);
            size -= 1;
        }
        return interprete;
    }
    
}
