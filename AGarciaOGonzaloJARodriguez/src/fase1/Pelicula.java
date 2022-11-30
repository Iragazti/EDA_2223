package fase1;

public class Pelicula  {

    private String titulo;
    private int ano;
    private double rating;
    private int votos;      
    private ListaInterpretes interpretes;

    public Pelicula (String titulo , int ano ,double rating, int votos) {
        super();
        this.titulo = titulo;
        this.ano = ano;
        this.rating = rating;
        this.votos = votos;
        this.interpretes = new ListaInterpretes();
    }

    
   
   
    public void anadirInterprete(Interprete inter) {
        interpretes.anadirInterprete(inter);
    }
    /**
     * A�ade un nuevo voto a la pel�cula.
     * POST: se han recalculado los ratings de sus int�rpretes
     * @param voto
     */ 
    public void anadirVoto(float rating) {// Ver ayuda en siguiente apartado.
        
        if (this.rating == -1) {
            this.rating = rating;
            votos = 1;
        }
        else{
            this.votos = this.votos+1; 
            this.rating = (this.rating*this.votos + rating)/(this.votos+1);
        }
        
        
    }


    // Setters y getters
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
    public void setRating(double rating){
        this.rating = rating;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public ListaInterpretes getInterpretes(){
        return this.interpretes;
    }

}
