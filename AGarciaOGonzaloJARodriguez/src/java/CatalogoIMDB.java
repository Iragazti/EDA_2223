package java;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CatalogoIMDB {

private static CatalogoIMDB miCatalogo;

    private ListaPeliculas listaPeliculas;
    private ListaInterpretes listaInterpretes;
    
    
    public CatalogoIMDB() {
      
        super();
        this.listaPeliculas = new ListaPeliculas();
        this.listaInterpretes = new ListaInterpretes();
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
    
    /**
    * Carga las pel�culas del cat�logo desde el fichero indicado
    * @param nomF Nombre del fichero que contiene las pel�culas
     * @throws FileNotFoundException
    */
    public void cargarPeliculas(String nomF) throws FileNotFoundException {// Ver ayuda en siguiente apartado
        Scanner entrada = new Scanner(new FileReader(nomF));
        String linea = "";
        String[] datos = null; //Array donde cada posición contendrá los datos de cada película.
        while (entrada.hasNext()) {
            linea = entrada.nextLine();
            datos = linea.split("\t");
            this.listaPeliculas.anadirPelicula(new Pelicula(datos[0], Integer.valueOf(datos[1]), Double.valueOf(datos[2]), Integer.valueOf(datos[3])));
        }
        
    }
    
    /**
     * Esta función carga todos los intérpretes de los archivos en listaInterpretes.
     * Se lee el archivo línea por línea y se va tratando separando el artista con sus películas.
     * @param nomF el nombre del fichero a leer.
     * @throws FileNotFoundException Si el archivo no existe.
     */
    public void cargarInterpretes(String nomF) throws FileNotFoundException {
        
        Scanner entrada = new Scanner(new FileReader(nomF));
        String linea = "";
        String[] datos = null;
        ListaPeliculas pelisDeInterprete = new ListaPeliculas();
        Pelicula peliculaActual = null;
        String[] datosPelis = null;

        while (entrada.hasNext()) {
            linea = entrada.nextLine();
            datos = linea.split("->"); //Separa el nombre del intérprete de sus películas
            datosPelis = datos[1].split("\\|\\|"); //Separa todas las películas del artista y las añade a una array
            
            for (int i = 0; i < datosPelis.length; i++) { //Añade cada elemento del array a la estructura pelisDeInterprete.
                peliculaActual = this.listaPeliculas.buscarPelicula(datosPelis[i]);
                pelisDeInterprete.anadirPelicula(peliculaActual);
            }
            
            this.listaInterpretes.anadirInterprete(new Interprete(datos[0], pelisDeInterprete));
        }
        
    } 
    public void imprimirInfoPelicula(String titulo) {
    /**
    * Imprime por pantalla el nombre del int�rprete, su rating y los t�tulos
    * de sus pel�culas.
    * @param nombre Nombre del int�rprete
    */
        
    }
    public void imprimirInfoInterprete(String nombre) {
    /**
    * A�ade un nuevo voto a una pel�cula
    * PRE: el valor del voto est� entre 0.0 y 10.0.
    * @param titulo T�tulo de la pel�cula
    * @param voto Valor del voto
    */
    }
    public void anadirVoto(String titulo, float voto) {
    
        
    }
}
