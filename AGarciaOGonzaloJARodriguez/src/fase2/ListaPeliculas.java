package fase2;
import java.util.ArrayList;
import java.util.List;

public class ListaPeliculas {

private List<Pelicula> pelis;
private int size = 0;
    
    public ListaPeliculas()
    {
         pelis = new ArrayList<Pelicula>();
    }
    

    /**
    * A�ade una pel�cula a la lista
    * @param pel Pel�cula a a�adir
    */
    public void anadirPelicula(Pelicula pelicula) {
        pelis.add(pelicula);
        size++;
    
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

    public int getSize(){
        return this.size;
    }
        
    public Pelicula getPelicula(int index){
        return pelis.get(index);

    }
   

    public boolean eliminarPelicula(Pelicula pel){
        buscarPelicula
            return true;
        else 
            return false;
    }


}
