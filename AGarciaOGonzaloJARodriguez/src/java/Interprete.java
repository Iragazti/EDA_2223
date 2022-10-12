package java;

public class Interprete {
    
    
    String nombre;
    String peliculasHechas;
    
    
  private ListaInterpretes inter;        
    
    public Interprete (String nombre , String peliculasHechas) {
        super();
        this.nombre = nombre;
        this.peliculasHechas = peliculasHechas;
        this.inter = new ListaInterpretes();
    }

    public ListaInterpretes getInterpretes() {
        return inter;
    }
    
    /**
    * Calcula y asigna el rating del intérprete en base al rating de sus películas
    */
    public void calcularRating() {// Ver ayuda en siguiente apartado
    /**
    * Añade una película al intérprete
    * @param pel Película a añadir
    * POST: El rating del intérprete NO se modifica en este momento
    */
        
    }
    public void anadirPelicula(Pelicula pel) {
        
    }
    
}
