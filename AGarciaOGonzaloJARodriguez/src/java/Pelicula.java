package java;

public class Pelicula  {
    
    
    private String titulo;
    private int ano;
    private double rating;
    private int votos;
        
    //MIRAR UML
    
   
    private ListaPeliculas pelis;        
    
    public Pelicula (String titulo , int ano ,double rating, int votos) {
        super();
        this.titulo = titulo;
        this.ano = ano;
        this.rating= rating;
        this.votos = votos;
        this.pelis = new ListaPeliculas();
    }

    public ListaPeliculas getPelis() {
        return pelis;
    }

   
   
    
   
    public void anadirInterprete(Interprete inter) {
        
        /**
        * Añade un intérprete a la película
        * @param inter Intérprete a añadir
        */
   
        
    }
    public void anadirVoto(float voto) {// Ver ayuda en siguiente apartado
        /**
         * Añade un nuevo voto a la película.
         * POST: se han recalculado los ratings de sus intérpretes
         * @param voto
         */ 
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void setPelis(ListaPeliculas pelis) {
        this.pelis = pelis;
    }

}
