package java;

public class Interprete {
    
    
    String nombre;
    private ListaPeliculas peliculasHechas;
    private ListaInterpretes inter;        
    
    public Interprete (String nombre , ListaPeliculas peliculasHechas) {
        super();
        this.nombre = nombre;
        this.inter = new ListaInterpretes();
    }

    public ListaInterpretes getInterpretes() {
        return inter;
    }
    
    /**
    * Calcula y asigna el rating del int�rprete en base al rating de sus pel�culas
    */
    
    public void calcularRating() {// Ver ayuda en siguiente apartado
    /**
    * A�ade una pel�cula al int�rprete
    * @param pel Pel�cula a a�adir
    * POST: El rating del int�rprete NO se modifica en este momento
    */
        
    }

    public void anadirPelicula(Pelicula pel) {
        peliculasHechas.anadirPelicula(pel);
    }
    
}
