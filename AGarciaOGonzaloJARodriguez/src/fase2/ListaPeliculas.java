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
    public Pelicula buscarPelicula2(String titulo) {
        
        for( int i=0; i<pelis.size() ; i++) {
           
            if(pelis.get(i).getTitulo().equals(titulo)) {
                return pelis.get(i);
            }
            
        }
        return null;
        
    }
    /////////////////////////////////////optimizado
  public Pelicula buscarPelicula(String titulo) {
        
        int izq = 0;
        int der = (pelis.size()-1);
        int medio= (izq+der)/2;
        
        while (izq < der && !pelis.get(medio).getPelicula().equals(titulo) ) {
            if(titulo.compareTo(pelis.get(medio).getPelicula()) < 0) {
                der = medio - 1;
            }else {
                izq = medio + 1;
            }
            medio = (izq + der) / 2;
        }

        if(pelis.get(medio).getPelicula().equals(titulo)) {
            return pelis.get(medio);
        }else {
            return null;
        }  
        
    }

    public int getSize(){
        return this.size;
    }
        
    public Pelicula getPelicula(int index){
        return pelis.get(index);

    }
    
    
    /**
    * Elimina de la lista la pel�cula pasada como par�metro.
    * @param pel: pel�cula a eliminar
    * @return true si se ha eliminado, false en caso contrario
    */
    public boolean eliminarPelicula(Pelicula pel) {
    	
    	return false;
    }



}
