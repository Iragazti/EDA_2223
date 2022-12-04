package fase2;




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
        this.anadirInterprete(inter);
    }

   


    /**
    * Busca un intÃ©rprete en la lista y lo devuelve
    * @param nombre Nombre del intÃ©rprete a buscar
    * @return el Interprete (si estÃ¡ en la lista), null en caso contrario
    */
    public Interprete buscarInterprete(String nombre){
        if (!this.isEmpty()) {
            return this.root.buscarInterprete(nombre);
        } else {
            return null;
        }
    }


   
    /**
    * Elimina un intÃ©rprete del Ã¡rbol (puede seguir estando en las listas de
    * intÃ©rpretes de las pelÃ­culas)
    * @param nombre Nombre del intÃ©rprete a eliminar
    * @return el Interprete (si se ha eliminado), null en caso contrario
    */

    public Interprete eliminarInterprete(String nombre){

        return this.eliminarInterprete(nombre);

    }

    /**
    * Devuelve el nÂº de elementos del Ã¡rbol.
    * @return nÂº de elementos del Ã¡rbol
    */
    public int size(){
        return this.size();
    }

    
}