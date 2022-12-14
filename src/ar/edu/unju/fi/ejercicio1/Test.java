package ar.edu.unju.fi.ejercicio1;

import java.util.Scanner;

/*
 * @author Oscar Ugarte
 * @since 1.0
 * 
 * */
public class Test {

	/**
	 * Muestra un menu de opciones para facilitar las pruebas.
	 */
	public static void mostrarMenu()
	{
		System.out.println("*****M E N U*****");
		System.out.println("0) Salir.");
		System.out.println("1) Mostrar Vector.");
		System.out.println("2) Calcular cuadrado de los multiplos de 3.");
		System.out.println("3) Eliminar un numero del vector.");
		System.out.println("4) Recorre el vector contando la diferencias entre pares de numeros que coincidan con el numero indicado.");
		System.out.print("Ingrese una opcion: " );
	}
	
	public static void main(String[] args) {
		Integer [] miVector = VectorDeNumeros.crearVector() ;
		miVector = VectorDeNumeros.cargarVector(miVector);
		Integer opcion = 5, numero = 0;
		Scanner teclado = new Scanner(System.in);
		VectorDeNumeros.mostrarVector(miVector);
		while(opcion != 0)
		{
			mostrarMenu();
			opcion = teclado.nextInt();
			switch(opcion)
			{
				case 0:
					System.out.println("Saliendo del programa.");
					break;
				case 1:
					VectorDeNumeros.mostrarVector(miVector);
					break;
				case 2:
					miVector = VectorDeNumeros.cambiarMultiplosDeTres(miVector);
					VectorDeNumeros.mostrarVector(miVector);
					break;
				case 3:
					System.out.print("Ingrese el numero a eliminar: ");
					numero = teclado.nextInt();
					miVector = VectorDeNumeros.eliminarNumero(miVector, numero);
					break;
				case 4:
					System.out.print("Ingrese el numero que quiere buscar entre las restas del vector: ");
					numero = teclado.nextInt();
					System.out.println("Se encontraron un total de : "  + VectorDeNumeros.obtenerParesDeDiferenciasEntreNumeros(miVector, numero) + " coincidencias con  " + numero + " .");
					break;
				default:
					System.out.println("Opcion invalida.");
			}
		}
	}

}
