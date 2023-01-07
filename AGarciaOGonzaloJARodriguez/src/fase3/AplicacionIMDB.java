package fase3;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AplicacionIMDB {
	
	private static AplicacionIMDB appIMDB = null;
	//private Scanner sc = null;
	private static String strPeli, strInter;
	private static CatalogoIMDB catalogo;
	private static String inter1, inter2;
	public static AplicacionIMDB getInstance(){
		if (appIMDB == null) {
			appIMDB = new AplicacionIMDB();
		}
			return appIMDB;
	}


	public static void main(String[] args) throws FileNotFoundException{
		catalogo = new CatalogoIMDB();
        System.out.println("¡Bienvenid@ a la aplicación de IMDB!");
		System.out.println("Cargando peliculas...");
		catalogo.cargarPeliculas("C:\\Users\\agust\\Desktop\\smallerfiles\\films_tiny.txt");
		System.out.println("En el catálogo hay "+ catalogo.getPeliculas().size() +" películas.");
		System.out.println("Cargando interpretes...");
		catalogo.cargarInterpretes("C:\\Users\\agust\\Desktop\\smallerfiles\\cast_tiny.txt");
		System.out.println("En el catálogo hay "+ catalogo.getInterpretes().size() + " interpretes.");
		//Men�
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		
		while(opcion!=0) {
			strPeli = strInter = inter1 = inter2 = null;
			System.out.println("Escoja una opci�n:");
			System.out.println("1. Mostrar informaci�n de pel�cula");
			System.out.println("2. Mostrar informaci�n de int�rprete");
			System.out.println("3. A�adir voto a pel�cula");
			System.out.println("4. Eliminar película");
			System.out.println("5. Indicar la distancia mínima entre dos intérpretes");
			System.out.println("6. Camino más corto entre dos intérpretes");
			System.out.println("0. Salir");
			sc = new Scanner(System.in);
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
				
			   case 1: 
			   		System.out.println("Introduzca el nombre de una película:");
			   		strPeli = sc.nextLine();
			   		catalogo.imprimirInfoPelicula(strPeli);
			        break;

				case 2:
					System.out.println("Introduzca el nombre de un intérprete:");
					strInter = sc.nextLine();
					catalogo.imprimirInfoInterprete(strInter);
					break;
				
				case 3:
					System.out.println("Introduzca el nombre de una película:");
					strPeli = sc.nextLine();
					if (strPeli == null) {
						System.out.println("No se ha encontrado la pelicula.");
						break;
					}
					System.out.println("Introducir puntuación entre 0.0 y 10.0:");
					float puntuacion = sc.nextFloat();
					catalogo.anadirVoto(strPeli, puntuacion);
					break;

				case 4:
					System.out.println("Introduzca el título una película:");
					strPeli = sc.nextLine();
					if(catalogo.eliminarPelicula(strPeli) != null){
						System.out.println(String.format("Se ha eliminado la pelicula %s. En el catálogo quedan %d películas y %d intérpretes.",
						strPeli, catalogo.getPeliculas().size(), catalogo.getInterpretes().size()));
					}
					else{
						System.out.println("La película no se ha encontrado en el catálogo");
					}
					break;
				/**
				 * Cuando escoja la opción 5, se le pedirá que introduzca dos nombres de intérprete
				 *	y se le indicará cuál es la distancia mínima entre dichos intérpretes.
				 */
				case 5:
					System.out.println("Deberás escribir el nombre de dos intérpretes.");
					System.out.println("Escribe el nombre del primer intérprete:");
					inter1 = sc.nextLine();
					System.out.println("Escribe el nombre del segundo intérprete:");
					inter2 = sc.nextLine();
					int distancia = catalogo.distancia(inter1, inter2);
					System.out.println(String.format("la distancia entre %s y %s es: %d", inter1, inter2, distancia));
					break;

				/**
				 * Cuando escoja la opción 6, se le pedirá que introduzca dos nombres de intérprete
				 * 	y se le mostrará el camino más corto entre dichos intérpretes
				 */
				case 6:
					System.out.println("Deberás escribir el nombre de dos intérpretes.");
					System.out.println("Escribe el nombre del primer intérprete:");
					inter1 = sc.nextLine();
					System.out.println("Escribe el nombre del segundo intérprete:");
					inter2 = sc.nextLine();
					catalogo.imprimirCamino2(inter1, inter2);
					break;
				case 0:
					break;
				default:
					break;
			}
		}
		sc.close();
		

	}

}
