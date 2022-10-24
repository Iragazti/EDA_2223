package fase1;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class AplicacionIMDB {
	
	private static AplicacionIMDB appIMDB;
	private Scanner sc;
	public static AplicacionIMDB getInstance(){
		if (appIMDB == null) {
			appIMDB = new AplicacionIMDB();
		}
			return appIMDB;
	}


	public static void main(String[] args){
		CatalogoIMDB catalogo = new CatalogoIMDB();
        try {
			catalogo.cargarInterpretes("C:\\Users\\Agus\\Documents\\GitHub\\EDA_2223\\AGarciaOGonzaloJARodriguez\\src\\fase1\\ficheros\\cast_small.txt");
			catalogo.cargarPeliculas("C:\\Users\\Agus\\Documents\\GitHub\\EDA_2223\\AGarciaOGonzaloJARodriguez\\src\\fase1\\ficheros\\films_small.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
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
