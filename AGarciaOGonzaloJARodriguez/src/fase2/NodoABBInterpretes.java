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

	// SETTERS????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
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
    //////////////////////////tengo dudas aqui///////////////////////
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
		if(!this.hasLeft()) { //El mínimo es el nodo actual
		return this.info;
		}else {//El mínimo está en el subárbol izquierdo
		return this.left.getMin();
	}
	   
	 
	//////////////////////////////como se hace con un string?

	public NodoABBInterpretes eliminarInterprete(Interprete elem) {
		int comp = elem.compareTo(this.info);
 		if(comp==0) {//Caso (a): this es el nodo a eliminar
 			if(!this.hasLeft()) return this.right; //Caso (a1)
 			else if(!this.hasRight()) return this.left; //Caso (a2)
 			else {//Caso (a3): Tiene los dos subarboles, sustituir por el valor mínimo del subarbol derecho
 				ResultadoRemoveMin<Interprete> min = this.right.removeMin();
				this.right = min.nodo;
				this.info = min.valor;
				return this;
			}
		} else if(comp<0){//Caso (b) El elemento a eliminar, si está, estará en el subárbol izq
			if(this.hasLeft()) this.left = this.left.eliminarInterprete(elem);
			return this;
			
		}else {//comp>0: Caso (c) El elemento a eliminar, si está, estará en el subárbol dcho
			if (this.hasRight()) this.right = this.right.eliminarInterprete(elem);
			return this;
		}

	}

	public ResultadoRemoveMin removeMin() {
		ResultadoRemoveMin resul = new ResultadoRemoveMin();
		if (!this.hasLeft()) {// El mínimo es el actual
			resul.valor = this.info;
			resul.nodo = this.right;
		} else { // El mínimo está en el subárbol izquierdo
			ResultadoRemoveMin resulLeft = this.left.removeMin();
			this.left = resulLeft.nodo;
			resul.valor = resulLeft.valor;
			resul.nodo = this;
		}
		return resul;
	}




	//////////////////////////////hay que ordenarlo¿?

	public void inorden() {
		if (this.hasLeft())
			this.left.inorden();
		System.out.println(this.info.getNombre()); 
		if (this.hasRight())
			this.right.inorden();
	}
	//////////////////////////////////////esta bien?
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