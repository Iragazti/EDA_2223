package fase3;

import java.util.HashSet;

public class Interprete implements Comparable<Interprete>{
    
    private String nombre;
    private double rating;
    private ListaPeliculas peliculasHechas;

    public Interprete (String nombre , ListaPeliculas peliculasHechas) {
        super();
        this.nombre = nombre;
        this.peliculasHechas = peliculasHechas;
    }
    
    /**
    * Calcula y asigna el rating del int�rprete en base al rating de sus pel�culas
    */
    
    public void calcularRating() {// Ver ayuda en siguiente apartado
        double sumRating = 0;
        double sumVotos = 0;
        for (int i = 0; i < peliculasHechas.size(); i++) { //O(N)
            if (peliculasHechas.getPelicula(i).getVotos() > 0) {
                
                sumRating += peliculasHechas.getPelicula(i).getRating() * peliculasHechas.getPelicula(i).getVotos();
                sumVotos += peliculasHechas.getPelicula(i).getVotos();
            }
        }
        if (sumVotos == 0) {
            this.rating = 0;
        }
        else{
            this.rating = sumRating / sumVotos;
        }
        
        
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
    public double getRating(){
        return this.rating;
    }

    public int compareTo(Interprete i) {
		
		return nombre.compareTo(i.nombre );		
	}
    /**
    * Devuelve un HashSet con todos los adyacentes del intérprete, es decir,
    * aquellos intérpretes con los que ha participado en alguna película.
    * @return: el HashSet con los intérpretes que son adyacentes.
    */
    public HashSet<Interprete> obtenerAdyacentes(){
        //TODO
        HashSet<Interprete> adyacentes = new HashSet<>();
        return adyacentes;
    }



   
    
}
