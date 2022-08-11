package ar.edu.unju.fi.ejercicio1;

/**
 * Clase encargada de manejar el vector de numeros.
 * */
public class VectorDeNumeros
{
	public static final int TAMANIO_VECTOR = 5;
	public static final int LIMITE = 1000;
	public static int posicionDelVector = -1;

	/**
	 * Crea un vector con el tama�o indicado en la constante TAMANIO_VECTOR
	 * y lo devuelve.
	 * @return
	 */
	public static Integer[] crearVector( )
	{
		return new Integer[TAMANIO_VECTOR];
	}
	
	/**
	 * Recibe un n�mero por parametros y se encarga de confirmar si es primo o no.
	 * Devuelve verdadero o falso.
	 * @param numero
	 * @return
	 */
	public static boolean esNumeroPrimo(Integer numero)
	{
		boolean esPrimo = numero == 1 ? false : true ; //Si es 1 no es primo.
		int i = 2;
		while(i < numero && esPrimo)
		{
			if( numero % i == 0 )
				esPrimo = false;
			else
				i++;
		}
		return esPrimo;
	}
	
	/**
	 * Se encarga de crear un n�mero aleatorio entre 1 y el valor que tenga la constante LIMITE.
	 * El n�mero generado se devuelve.
	 * @return
	 */
	public static int generarNumeroAleatorio()
	{
		return (int) Math.floor(Math.random()*LIMITE+1) ;
	}
	
	/**
	 * Recibe como parametros un vector de enteros y un n�mero entero. 
	 * Se encarga de buscar ese n�mero en el Vector y si lo encuentra devuelve 
	 * verdadero.
	 * @param vector
	 * @param buscado
	 * @return
	 */
	public static boolean numeroRepetido(Integer[] vector, int buscado  )
	{
		boolean repetido = false;
		int i = 0;
		while( !repetido && i <=posicionDelVector && i >= 0  )
		{
			if( vector[i] == buscado )
				repetido = true;
			else
				i++;
		}
		return repetido;
	}
	
	/**
	 * Carga el vector pasado por parametros con n�meros aleatorio entre 1 y 1000 que no sean primos.
	 * Al final devuelve el vector cargado.
	 * @param vector
	 * @return
	 */
	public static Integer[] cargarVector(Integer[] vector )
	{
		int numeroTemporal;
		while(posicionDelVector < TAMANIO_VECTOR - 1)
		{
			numeroTemporal = generarNumeroAleatorio();
			if( ! esNumeroPrimo(numeroTemporal)  && ! numeroRepetido(vector, numeroTemporal) || posicionDelVector == -1) //Si no es primo, si no esta repetido y si es el primero
			{
				posicionDelVector++;
				vector[ posicionDelVector  ] = numeroTemporal ;
			}
		}
		return vector;
	}
	
	/**
	 * Se encarga de mostrar el vector pasado por parametros.
	 * @param vector
	 */
	public static void mostrarVector(Integer[] vector )
	{
		for( int i = 0 ; i <= posicionDelVector ; i++ )
		{
			System.out.println("Posicion: " + i + " = " + vector[i] );
		}
	}
}
