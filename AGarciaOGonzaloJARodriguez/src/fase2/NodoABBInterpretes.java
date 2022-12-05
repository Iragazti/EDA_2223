package fase2;


public class NodoABBInterpretes {

	private Interprete info;
	private NodoABBInterpretes left;
	private NodoABBInterpretes right;

	public NodoABBInterpretes(Interprete inter) {
		info = inter;
		left = null;
		right = null;
	}

	public Interprete getElem() {
		return info;
	}

	public NodoABBInterpretes getIzquierdo() {
		return left;
	}

	public NodoABBInterpretes getDerecho() {
		return right;
	}

	public void setLeft(NodoABBInterpretes izquierdo) {
		this.left = izquierdo;
	}

	public void setRight(NodoABBInterpretes derecho) {
		this.right = derecho;
	}

	public void setElem(Interprete elem) {
		this.info = elem;
	}

	public boolean hasLeft() {
		return (left != null);

	}

	public boolean hasRight() {
		return (right != null);

	}

	public void anadirInterprete(Interprete elem) {
		if (elem.compareTo(this.info) < 0) {
			if (this.hasLeft())
				this.left.anadirInterprete(elem);
			else
				this.left = new NodoABBInterpretes(elem);

		} else if (elem.compareTo(this.info) > 0) {
			if (this.hasRight())
				this.right.anadirInterprete(elem);
			else
				this.right = new NodoABBInterpretes(elem);

		}

	}
 
	public Interprete buscarInterprete(String sInterprete) {
		if (sInterprete.compareTo(this.info.getNombre()) == 0) {
			return this.info;
		} else if (sInterprete.compareTo(this.info.getNombre()) < 0 && this.hasLeft()) {
			return this.left.buscarInterprete(sInterprete);
		} else if (sInterprete.compareTo(this.info.getNombre()) > 0 && this.hasRight()) {
			return this.right.buscarInterprete(sInterprete);
		} else {
			return null;
		}

	}


	
	public Interprete getMin() {
		if(!this.hasLeft()) { //El mÃ­nimo es el nodo actual
		return this.info;
		}else {//El mÃ­nimo estÃ¡ en el subÃ¡rbol izquierdo
		return this.left.getMin();
		}
	}
	   
	 
 /////////////////////////////no se si lo borro del todo (en ese caso estaria mal///////////////////////////////
	 /**
	* Elimina un intérprete del árbol (puede seguir estando en las listas de
	* intérpretes de las películas)
	* @param nombre Nombre del intérprete a eliminar
	* @return el Interprete (si se ha eliminado), null en caso contrario
	*/
	
	public NodoABBInterpretes eliminarInterprete(String sInterprete) {
		Interprete elem = buscarInterprete(sInterprete);
		int comp = elem.compareTo(this.info);
 		if(comp==0) {//Caso (a): this es el nodo a eliminar
 			if(!this.hasLeft()) return this.right; //Caso (a1)
 			else if(!this.hasRight()) return this.left; //Caso (a2)
 			else {//Caso (a3): Tiene los dos subarboles, sustituir por el valor mÃ­nimo del subarbol derecho
 				ResultadoRemoveMin<Interprete> min = this.right.removeMin();
				this.right = min.nodo;
				this.info = min.valor;
				return this;
			}
		} else if(comp<0){//Caso (b) El elemento a eliminar, si estÃ¡, estarÃ¡ en el subÃ¡rbol izq
			if(this.hasLeft()) this.left = this.left.eliminarInterprete(sInterprete);
			return this;
			
		}else {//comp>0: Caso (c) El elemento a eliminar, si estÃ¡, estarÃ¡ en el subÃ¡rbol dcho
			if (this.hasRight()) this.right = this.right.eliminarInterprete(sInterprete);
			return this;
		}

	}
	/**
	 * Este metodo busca el apuntador al nodo con menor valor.
	 * @return una estructura que contiene el nodo buscado y su info.
	 */
	public ResultadoRemoveMin removeMin() {
		ResultadoRemoveMin resul = new ResultadoRemoveMin();
		if (!this.hasLeft()) {// El mÃ­nimo es el actual
			resul.valor = this.info;
			resul.nodo = this.right;
		} else { // El mÃ­nimo estÃ¡ en el subÃ¡rbol izquierdo
			ResultadoRemoveMin resulLeft = this.left.removeMin();
			this.left = resulLeft.nodo;
			resul.valor = resulLeft.valor;
			resul.nodo = this;
		}
		return resul;
	}

	/**
	 * Imprime el arbon el inorden
	 */
	public void inorden() {
		if (this.hasLeft())
			this.left.inorden();
		System.out.println(this.info.getNombre()); 
		if (this.hasRight())
			this.right.inorden();
	}
	
	//indica si el nodo es hoja
	public boolean isLeaf() {
		return (left == null && right == null);
	}

	public int size(){
		if(this.isLeaf()) return 1;
		else{
			int cont = 0;
			if(this.hasLeft()) cont += this.left.size();
			if(this.hasRight()) cont += this.right.size();
			return cont;
		}
	}


}