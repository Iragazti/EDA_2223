package java;

public class CatalogoIMDB {

private static CatalogoIMDB miCatalogo;
    
    
    
    private ListaPeliculas listaPeliculas;
    private ListaInterpretes listaInterpretes;
    
    
    public CatalogoIMDB() {
      
        super();
        this.listaPeliculas = new ListaPeliculas();
        this.listaInterpretes = new ListaInterpretes();
    }
    
    public static CatalogoIMDB getInstance()
    {
        if( miCatalogo == null )
            miCatalogo = new CatalogoIMDB();
        
        return miCatalogo;
    }
   /* 
    public Pelicula getPeliculas() {
        return listaPeliculas;
    }
    
    
*/
    
    /**
    * Carga las pel�culas del cat�logo desde el fichero indicado
    * @param nomF Nombre del fichero que contiene las pel�culas
    */
    public void cargarPeliculas(String nomF) {// Ver ayuda en siguiente apartado
    /**
    * Carga los int�rpretes del cat�logo desde el fichero indicado
    * POST: se han cargado los int�rpretes y se han calculado sus ratings
    * @param nomF Nombre del fichero que contiene los int�rpretes
    */
    }
    
    
    public void cargarInterpretes(String nomF) {
    /**
    * Imprime por pantalla el n� de int�rpretes de una pel�cula y sus nombres
    * @param titulo T�tulo de la pel�cula
    */
        
    }
    public void imprimirInfoPelicula(String titulo) {
    /**
    * Imprime por pantalla el nombre del int�rprete, su rating y los t�tulos
    * de sus pel�culas.
    * @param nombre Nombre del int�rprete
    */
        
    }
    public void imprimirInfoInterprete(String nombre) {
    /**
    * A�ade un nuevo voto a una pel�cula
    * PRE: el valor del voto est� entre 0.0 y 10.0.
    * @param titulo T�tulo de la pel�cula
    * @param voto Valor del voto
    */
    }
    public void anadirVoto(String titulo, float voto) {
    
        
    }
}
