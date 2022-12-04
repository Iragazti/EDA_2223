package fase2;

import java.util.Comparator;
import java.util.LinkedList;

public class ABBInterpretes <T extends Comparable<T>> implements InterfazInterpretes {

    NodoABBInterpretes root;

    public ABBInterpretes (Interprete inter){
        this.root = new NodoABBInterpretes(inter);
    }
    public ABBInterpretes(NodoABBInterpretes inter) {
		this.root = inter;
	}
	public ABBInterpretes() {
		this.root = null;
	}


	public boolean isEmpty() {
		return (root == null);
	}



    /**
* Añade un intérprete a la lista
* @param inter Intérprete a añadir
*/
public void anadirInterprete(Interprete inter){
    if (this.isEmpty()) {
        this.root = new NodoABBInterpretes(inter);
    } else {
        this.root.anadirInterprete(inter);
    }

}
/**
* Busca un intérprete en la lista y lo devuelve
* @param nombre Nombre del intérprete a buscar
* @return el Interprete (si está en la lista), null en caso contrario
*/
public Interprete buscarInterprete(String nombre){
    if (!this.isEmpty()) {
        return this.root.buscarInterprete(nombre);
    } else {
        return null;
    }
}


/////////////////////////////no se si lo borro del todo (en ese caso estaria mal///////////////////////////////
/**
* Elimina un intérprete del árbol (puede seguir estando en las listas de
* intérpretes de las películas)
* @param nombre Nombre del intérprete a eliminar
* @return el Interprete (si se ha eliminado), null en caso contrario
*/



public Interprete eliminarInterprete(String nombre){
    Interprete inter;
    inter.getNombre();
    if(!this.isEmpty()) {
        this.root = this.root.eliminarInterprete(inter);
    }
}


/**
* Devuelve el nº de elementos del árbol.
* @return nº de elementos del árbol
*/
public int size(){
    if (this.isEmpty())return 0;
    else return this.root.size();
}
@Override
public Interprete eliminarInterprete(String nombre) {
    // TODO Auto-generated method stub
    return null;
}



    
}
