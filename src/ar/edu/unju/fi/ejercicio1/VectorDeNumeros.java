package ar.edu.unju.fi.ejercicio1;

/**
 * Clase encargada de manejar el vector de numeros.
 * */
public class VectorDeNumeros
{
	public static final int TAMANIO_VECTOR = 6;
	public static final int LIMITE = 10;
	public static int posicionDelVector = -1;

	/**
	 * Crea un vector con el tama?o indicado en la constante TAMANIO_VECTOR
	 * y lo devuelve.
	 * @return
	 */
	public static Integer[] crearVector( )
	{
		return new Integer[TAMANIO_VECTOR];
	}
	
	/**
	 * Recibe un n?mero por parametros y se encarga de confirmar si es primo o no.
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
	 * Se encarga de crear un n?mero aleatorio entre 1 y el valor que tenga la constante LIMITE.
	 * El n?mero generado se devuelve.
	 * @return
	 */
	public static int generarNumeroAleatorio()
	{
		return (int) Math.floor(Math.random()*LIMITE+1) ;
	}
	
	/**
	 * Recibe como parametros un vector de enteros y un n?mero entero. 
	 * Se encarga de buscar ese n?mero en el Vector y si lo encuentra devuelve 
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
	 * Carga el vector pasado por parametros con n?meros aleatorio entre 1 y 1000 que no sean primos.
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
	
	/**
	 * Calcula el cuadrado del n?mero pasado por parametro.
	 * @param base
	 * @return
	 */
	public static Integer calcularCuadrado(Integer base)
	{
		return (int) Math.pow(base, 2);
	}
	
	/**
	 * Busca los multiplos de tres del vector pasado por parametros y los elevea al
	 * cuadrado.
	 * @param vector
	 * @return
	 */
	public static Integer[] cambiarMultiplosDeTres(Integer[] vector )
	{
		for(int i = 0 ; i <= posicionDelVector ; i++ )
		{
			if( vector[i] % 3 == 0 )
			{
				vector[i] = calcularCuadrado(vector[i]);
			}
		}
		return vector;
	}
	

	/**
	 * Se encarga de buscar el numero pasado por parametro en el vector.
	 * Si no lo encuentra devuelve null, caso contrario devuelve la posici?n del n?mero.
	 * @param vector
	 * @param buscado
	 * @return
	 */
	public static Integer buscarNumeroEnElVector( Integer[] vector , Integer buscado )
	{
		int i = 0;
		while(i <= posicionDelVector && !vector[i].equals(buscado) )
		{
			i++;
		}
		return i <= posicionDelVector ? i : null ;
	}
	
	/**
	 * Se encarga de eliminar el n?mero pasado por parametros en el Vector si lo encuentra.
	 * @param vector
	 * @param buscado
	 * @return
	 */
	public static Integer[] eliminarNumero(Integer[] vector , Integer buscado)
	{
		Integer posicionDelNumero = buscarNumeroEnElVector(vector, buscado);
		if( posicionDelNumero != null )
		{
			for(int i = posicionDelNumero ; i <= posicionDelVector - 1; i++)
			{
				vector[i] = vector[i + 1 ] ;
			}
			posicionDelVector--;
		}
		return vector;
	}
	
	/**
	 * Recorre el vector pasado por parametro comparando las diferencias entre n?meros. Si la diferencia es negativa se la convierte a positivo.
	 * Si encuentra un resultado que coincida con el n?mero objectivo pasado por parametros lo cuenta.
	 * Al final devuelve la cantidad de coincidencias que encontr?.
	 * @param vector
	 * @param numeroObjectivo
	 * @return
	 */
	public static Integer obtenerParesDeDiferenciasEntreNumeros(Integer[] vector, Integer numeroObjectivo )
	{
		Integer cantidad = 0, diferencia = 0 ;
		for(int i = 0 ; i < posicionDelVector ; i++ )
		{
			for(int j = i + 1; j <= posicionDelVector ; j++)
			{
				diferencia = vector[i] - vector[j] > 0 ? (vector[i] - vector[j]) : (vector[i] - vector[j]) * (-1) ;
				if( diferencia == numeroObjectivo )
					cantidad++;
			}
		}
		return cantidad;
	}
}
