package fase2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaPeliculas {

private List<Pelicula> pelis;
private int size;
    
    public ListaPeliculas()
    {
         pelis = new ArrayList<Pelicula>();
         size = 0;
    }
    

    /**
    * Aï¿½ade una pelï¿½cula a la lista
    * @param pel Pelï¿½cula a aï¿½adir
    */
    public void anadirPelicula(Pelicula pelicula) {
        pelis.add(pelicula);
        size++;
    
    }
    
    
    /**
     * Busca una pelï¿½cula en la lista y la devuelve
     * @param titulo Tï¿½tulo de la pelï¿½cula a buscar
     * @return la Pelï¿½cula (si estï¿½ en la lista), null en caso contrario
     * 
     */
   
    /////////////////////////////////////optimizado
  public Pelicula buscarPelicula(String titulo) {
        
        int izq = 0;
        int der = (pelis.size()-1);
        int medio= (izq+der)/2;
        
        while (izq < der && !pelis.get(medio).getTitulo().equals(titulo) ) {
            if(titulo.compareTo(pelis.get(medio).getTitulo()) < 0) {
                der = medio - 1;
            }else {
                izq = medio + 1;
            }
            medio = (izq + der) / 2;
        }

        if(pelis.get(medio).getTitulo().equals(titulo)) {
            return pelis.get(medio);
        }else {
            return null;
        }  
        
    }

    public int size(){
        return this.size;
    }
        
    public Pelicula getPelicula(int index){
        return pelis.get(index);

    }


        /**
    * Elimina de la lista la película pasada como parámetro.
    * @param pel: película a eliminar
    * @return true si se ha eliminado, false en caso contrario
    */

    public boolean eliminarPelicula(Pelicula pel){
        size -= 1;
        return this.pelis.remove(pel);
    }

}
