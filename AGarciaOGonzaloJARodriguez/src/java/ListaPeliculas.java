package java;

import java.util.ArrayList;
import java.util.List;



public class ListaPeliculas {

private List<Pelicula> pelis;
    
    public ListaPeliculas()
    {
         pelis = new ArrayList<Pelicula>();
    }
    
    
    
    
    
    /**
    * Añade una película a la lista
    * @param pel Película a añadir
    */
    public void anadirPelicula(Pelicula pel) {
        pelis.add(pel);
    
    }
    
    
    /**
     * Busca una película en la lista y la devuelve
     * @param titulo Título de la película a buscar
     * @return la Película (si está en la lista), null en caso contrario
     * 
     */
    public Pelicula buscarPelicula(String titulo) {
        
        for( int i=0; i<pelis.size() ; i++) {
           
            if(pelis.get(i).getTitulo().equals(titulo)) {
                return pelis.get(i);
            }
            
        }
        return null;
        
    }
        

}
