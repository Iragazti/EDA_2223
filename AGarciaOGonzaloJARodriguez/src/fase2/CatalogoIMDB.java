package fase2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class CatalogoIMDB {

    private static CatalogoIMDB miCatalogo;
    //TODO cambiar a interfaz. Apartado B
    private ListaPeliculas listaPeliculas;
    private InterfazInterpretes listaInterpretes;

    public CatalogoIMDB(){
        super();
        this.listaPeliculas = new ListaPeliculas();
        this.listaInterpretes = new ListaInterpretes();
    }

    public static CatalogoIMDB getInstance() {
        if (miCatalogo == null)
            miCatalogo = new CatalogoIMDB();

        return miCatalogo;
    }

    public InterfazInterpretes getInterpretes(){
        return this.listaInterpretes;
    }
    public ListaPeliculas getPeliculas(){
        return this.listaPeliculas;
    }

    /**
     * Carga las pel�culas del cat�logo desde el fichero indicado
     * 
     * @param nomF Nombre del fichero que contiene las pel�culas
     * @throws FileNotFoundException
     */
    public void cargarPeliculas(String nomF) throws FileNotFoundException {// Ver ayuda en siguiente apartado
        Scanner entrada;
        try{
        entrada = new Scanner(new FileReader(nomF)); // O(N)
        }
        catch(Exception e){
            e.printStackTrace();
            throw new FileNotFoundException("No se ha encontrado el archivo en la ruta.");
        }

        String linea = "";
        String[] datos = null; // Array donde cada posición contendrá los datos de cada película.
        Pelicula peli = null;

        while (entrada.hasNext()) { // O(N)
            linea = entrada.nextLine();
            datos = linea.split("\u0009");
            peli = new Pelicula(datos[0], Integer.valueOf(datos[1]), Double.valueOf(datos[2]),
                    Integer.valueOf(datos[3]));
            this.listaPeliculas.anadirPelicula(peli);
        }

    }

    /**
     * Este método lee cada línea del fichero cargado en el parámetro y procesa cada
     * línea.
     * El proceso que sigue consiste en separar el intérprete de las películas donde
     * ha participado.
     * Guarda estos dos datos en la estructura 'datos'. Seguido de esto, separa una
     * vez más cada una de las
     * películas en 'datosPelis'.
     * 
     * @param nomF el nombre del fichero a leer.
     * @throws FileNotFoundException Si el archivo no existe.
     */
    public void cargarInterpretes(String nomF) throws FileNotFoundException { // O(N*M)
        Scanner entrada;
        
        try{
            entrada = new Scanner(new FileReader(nomF));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            throw new FileNotFoundException("No se ha encontrado el archivo en la ruta.");
        }

        String linea = "";
        String[] datos = null;
        String[] datosPelis = null;
        Pelicula peliculaActual = null;
        ListaPeliculas pelisDeInterprete = null;
        Interprete interpreteActual = null;

        while (entrada.hasNext()) {
            linea = entrada.nextLine();
            datos = linea.split("->"); // Separa el nombre del intérprete de sus películas
            datosPelis = datos[1].split("\\|\\|"); // Separa todas las películas del artista y las añade a una array
            pelisDeInterprete = new ListaPeliculas();

            for (int i = 0; i < datosPelis.length; i++) {// O(N) N = datosPelis.length
                peliculaActual = this.listaPeliculas.buscarPelicula(datosPelis[i]);
                pelisDeInterprete.anadirPelicula(peliculaActual);
            }

            interpreteActual = new Interprete(datos[0], pelisDeInterprete);
            interpreteActual.calcularRating();
            this.listaInterpretes.anadirInterprete(interpreteActual);

            // Esta parte carga el intérprete actual en la lista de intérpretes de cada una
            // de sus películas.
            for (int i = 0; i < pelisDeInterprete.size(); i++) { // O(M) M = pelisDeInterprete.length;
                peliculaActual = pelisDeInterprete.getPelicula(i);
                peliculaActual.anadirInterprete(interpreteActual);
            }

        }
        entrada.close();

    }

    /**
     * Imprime por pantalla el nombre del int�rprete, su rating y los t�tulos
     * de sus pel�culas.
     * 
     * @param nombre Nombre del int�rprete
     */
    public void imprimirInfoPelicula(String titulo) { // O(N)
        Pelicula pelicula = listaPeliculas.buscarPelicula(titulo);
        if (pelicula == null) {
            System.out.println("La película no ha sido hallada.");
        } else {
            System.out.println(String.format(
                    "Título: %s\nAño: %d\nRating: %f\nNum. votos: %d\nTotal de intérpretes: %d", titulo,
                    pelicula.getAno(), pelicula.getRating(), pelicula.getVotos(), pelicula.getInterpretes().size()));
            for (int i = 0; i < pelicula.getInterpretes().size(); i++) {
                System.out.println(pelicula.getInterpretes().getInterprete(i).getNombre());
            }
        }
    }

    /**
     * A�ade un nuevo voto a una pel�cula
     * PRE: el valor del voto est� entre 0.0 y 10.0.
     * 
     * @param titulo T�tulo de la pel�cula
     * @param voto   Valor del voto
     */
    public void imprimirInfoInterprete(String nombre) { // O(N)
        Interprete interprete = listaInterpretes.buscarInterprete(nombre);
        if (interprete == null) {
            System.out.println("El intérprete no ha sido hallado.");
        } else {
            double rating = interprete.getRating();
            ListaPeliculas peliculasHechas = interprete.getPeliculasHechas();
            System.out.println(String.format("Nombre: %s\nRating: %f\nTotal de películas del intérprete: %d", nombre,
                    rating, peliculasHechas.size()));
            for (int i = 0; i < peliculasHechas.size(); i++) {
                System.out.println(peliculasHechas.getPelicula(i).getTitulo());
            }
        }
    }

    public void anadirVoto(String titulo, float voto) {
        Pelicula peli = listaPeliculas.buscarPelicula(titulo);
        peli.anadirVoto(voto);
        for (int i = 0; i < peli.getInterpretes().size(); i++) {
            peli.getInterpretes().getInterprete(i).calcularRating();
        }
    }

    /**
     * Inicializa el conjunto de intérpretes del catálogo con el conjunto de
     * intérpretes que se le pasa como parámetro
     * 
     * @param intérpretes: conjunto de intérpretes
     */
    public void setInterpretes(InterfazInterpretes interpretes) {
        this.listaInterpretes = interpretes;
    }

    /**
     * Elimina del catálogo la película cuyo título se pasa como parámetro.
     * Además, elimina la película de la lista de películas de cada uno de los
     * intérpretes de dicha película.
     * Aquellos intérpretes que se quedan sin películas son eliminados del
     * catálogo, y al resto se les actualiza el rating.
     */

    public Pelicula eliminarPelicula(String titulo) { //O(n^2 + LogN)
        Pelicula pelicula = this.listaPeliculas.buscarPelicula(titulo); //O(logN)
        if (pelicula != null) {
            for (int i = 0; i < pelicula.getInterpretes().size(); i++) { //O(n)
                Interprete interActual = pelicula.getInterpretes().getInterprete(i);
                interActual.getPeliculasHechas().eliminarPelicula(pelicula);
                if (interActual.getPeliculasHechas().size() == 0) {
                    this.listaInterpretes.eliminarInterprete(interActual.getNombre()); //O(n)
                }
                interActual.calcularRating();
            }
            this.listaPeliculas.eliminarPelicula(pelicula);
        }
        return pelicula;
    }
}
