package java;

public class CatalogoIMDB {

private static CatalogoIMDB miCatalogo;
    
    
    
    private ListaPeliculas listaPeliculas;
    
    
    public CatalogoIMDB() {
      
        super();
        this.listaPeliculas = new ListaPeliculas();
        
    }
    
    public static CatalogoIMDB getInstance()
    {
        if( miCatalogo == null )
            miCatalogo = new CatalogoIMDB();
        
        return miCatalogo;
    }
   /* 
    public Pelicula getPeliculas() {
        return listaPeliculas;
    }
*/
}
