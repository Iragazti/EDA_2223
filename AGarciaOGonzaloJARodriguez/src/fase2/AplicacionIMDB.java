package fase2;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AplicacionIMDB {
	
	private static AplicacionIMDB appIMDB = null;
	private Scanner sc = null;
	
	
	public static AplicacionIMDB getInstance(){
		if (appIMDB == null) {
			appIMDB = new AplicacionIMDB();
		}
			return appIMDB;
	}


	public static void main(String[] args) throws FileNotFoundException{
		CatalogoIMDB catalogo = new CatalogoIMDB();
        System.out.println("¡Bienvenid@ a la aplicación de IMDB!");
		System.out.println("Cargando peliculas...");
		catalogo.cargarPeliculas("C:\\Users\\Agus\\Desktop\\ficheros\\films_tiny.txt");
		System.out.println("En el catálogo hay"+ catalogo.getPeliculas().getSize() +" películas.");
		System.out.println("Cargando interpretes...");
		catalogo.cargarInterpretes("C:\\Users\\Agus\\Desktop\\ficheros\\cast_tiny.txt");
		System.out.println("En el catálogo hay"+ catalogo.getInterpretes().size() +" interpretes.");
	
		//Men�
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		
		while(opcion!=0) {
			System.out.println("Escoja una opci�n:");
			System.out.println("1. Mostrar informaci�n de pel�cula");
			System.out.println("2. Mostrar informaci�n de int�rprete");
			System.out.println("3. A�adir voto a pel�cula");

			System.out.println("0. Salir");
			sc = new Scanner(System.in);
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
				
			   case 1: 
			   		System.out.println("Introduzca el nombre de una película:");
			   		String strPeli = sc.nextLine();
			   		catalogo.imprimirInfoPelicula(strPeli);
			        break;

				case 2:
					System.out.println("Introduzca el nombre de un intérprete:");
					String strInter = sc.nextLine();
					catalogo.imprimirInfoInterprete(strInter);
					break;
				
				case 3:
					System.out.println("Introduzca el nombre de una película:");
					String stPeli = sc.nextLine();
					System.out.println("Introducir puntuación entre 0.0 y 10.0:");
					float puntuacion = sc.nextFloat();
					catalogo.anadirVoto(stPeli, puntuacion);
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
