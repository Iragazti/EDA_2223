package fase3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.management.Descriptor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CatalogoIMDB {

    private static CatalogoIMDB miCatalogo;
    private ListaPeliculas listaPeliculas;
    private InterfazInterpretes listaInterpretes;

    public CatalogoIMDB(){
        super();
        this.listaPeliculas = new ListaPeliculas();
        this.listaInterpretes = new HashMapInterpretes();
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
            //Crea un array con todas las películas del interprete actual
            for (int i = 0; i < datosPelis.length; i++) {// O(N) N = datosPelis.length
                peliculaActual = this.listaPeliculas.buscarPelicula(datosPelis[i]);
                pelisDeInterprete.anadirPelicula(peliculaActual);
            }
            peliculaActual = null;

            interpreteActual = new Interprete(datos[0], pelisDeInterprete);
            interpreteActual.calcularRating();
            listaInterpretes.anadirInterprete(interpreteActual);
            
            // Esta parte carga el intérprete actual en la lista de intérpretes de cada una
            // de sus películas.
            for (int i = 0; i < pelisDeInterprete.size(); i++) { // O(M) M = pelisDeInterprete.length;
                peliculaActual = pelisDeInterprete.getPelicula(i);
                peliculaActual.anadirInterprete(interpreteActual);
            }

        }
        entrada.close();
        setInterpretes(listaInterpretes);
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


    /*
     * 
        * 
        * 
        olarizu: hay que mirar el primer pdf de grafos para esto
        porque el ejercicio resulto que tiene ella lo tiene hecho con grafos,
        y le funciona y tiene sentido. 
        no se si tenemos que crear o no nosotros el grafo o que. 
        luego resolvemos esto y en principio el c esta hecho
 
     /**
        * Devuelve la distancia mínima entre dos intérpretes dados.
        * @param inter1: nombre del primer intérprete
        * @param inter2: nombre del segundo intérprete
        * @return: distancia mínima entre ambos intérpretes. En caso de que no
        * estén mapaDistancias, devuelve -1.
        */
        public int distancia(String origen, String destino) {
            // Crea un mapa para almacenar la distancia de cada nodo al nodo inicial
            Map<Interprete,Integer> mapaDistancias = new HashMap<Interprete, Integer>();
            //Cola para almacenar nodos visitados
            Queue<Interprete> cola = new LinkedList<Interprete>();
        
            Interprete interpreteO = this.listaInterpretes.buscarInterprete(origen);
            Interprete interpreteD = this.listaInterpretes.buscarInterprete(destino);
            
            boolean encontrado=false;
            mapaDistancias.put(interpreteO, 0);
            cola.add(interpreteO);

            while(!cola.isEmpty() && !encontrado){
                // Toma el primer nodo de la cola
                Interprete actual = cola.poll();
                
                if (actual.compareTo(interpreteD) == 0){// Si es el nodo destino, devuelve la distancia almacenada en el mapa
                    return mapaDistancias.get(actual);
                }
                for (Interprete vecino:actual.obtenerAdyacentes()) {
                    if (!mapaDistancias.containsKey(vecino)){ // Si el vecino no ha sido visitado
                        // Agrega el vecino a la cola y asigna una distancia igual a la del nodo actual + 1
                        cola.add(vecino);
                        mapaDistancias.put(vecino, mapaDistancias.get(actual)+1);
                    }
                }
            }
            // Si no se ha encontrado el nodo destino, devuelve -1
            return -1;
        }
        /**
        * Imprime el camino más corto entre dos intérpretes. Si no existe camino,
        * imprime un mensaje indicando este hecho.
        * @param inter1: nombre del primer intérprete
        * @param inter2: nombre del segundo intérprete
        */
        public void imprimirCamino(String inter1, String inter2){
            LinkedList<Interprete> resultado = new LinkedList<Interprete>();
            HashMap<String,Interprete> mapaDistancias = new HashMap<String,Interprete>();
            Queue<Interprete> cola = new LinkedList<Interprete>();
            Interprete interprete1 = this.listaInterpretes.buscarInterprete(inter1);
            Interprete interprete2 = this.listaInterpretes.buscarInterprete(inter2);
            
            cola.add(interprete1);
            mapaDistancias.put(inter1, null);

            boolean encontrado = false;

            while (!cola.isEmpty()&&!encontrado){
                Interprete inter = cola.remove();
                if (inter.getNombre().equals(interprete2.getNombre())){
                    encontrado=true;
                } else {
                    for (Interprete aux : inter.obtenerAdyacentes()){
                        if (!mapaDistancias.containsKey(aux)) {
                            cola.add(aux);
                            mapaDistancias.put(aux.getNombre(),inter);
                        }
                    }
                }
            }
            if (encontrado){
                Interprete actual = interprete2;
                while(actual!=null){
                    resultado.addFirst(actual);
                    actual=mapaDistancias.get(actual);
                }
            }
            if (!resultado.isEmpty()){
                System.out.println(resultado);
            }else{
                System.out.println("no existe camino");
            }
            
        }

}
