package java;

public class Interprete {
    
    
    private String nombre;
    private ListaPeliculas peliculasHechas;
    private ListaInterpretes inter;        
    private double rating;

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
        int sumRating = 0;
        int sumVotos = 0;
        for (int i = 0; i < peliculasHechas.getSize(); i++) {
            if (peliculasHechas.getPelicula(i).getVotos() > 0) {
                
                sumRating += peliculasHechas.getPelicula(i).getRating() * peliculasHechas.getPelicula(i).getVotos();
                sumVotos += peliculasHechas.getPelicula(i).getVotos();
            }
        }
        this.rating = sumRating / sumVotos;
        
    }

    public void anadirPelicula(Pelicula pel) {
        peliculasHechas.anadirPelicula(pel);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPeliculas getPeliculasHechas() {
        return peliculasHechas;
    }

    public void setPeliculasHechas(ListaPeliculas peliculasHechas) {
        this.peliculasHechas = peliculasHechas;
    }
    
}
