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
    * A�ade una pel�cula a la lista
    * @param pel Pel�cula a a�adir
    */
    public void anadirPelicula(Pelicula pel) {
        pelis.add(pel);
    
    }
    
    
    /**
     * Busca una pel�cula en la lista y la devuelve
     * @param titulo T�tulo de la pel�cula a buscar
     * @return la Pel�cula (si est� en la lista), null en caso contrario
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
