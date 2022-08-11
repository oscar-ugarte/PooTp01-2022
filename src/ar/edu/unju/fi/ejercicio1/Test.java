package ar.edu.unju.fi.ejercicio1;

/*
 * @author Oscar Ugarte
 * @since 1.0
 * 
 * */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] miVector = VectorDeNumeros.crearVector() ;
		miVector = VectorDeNumeros.cargarVector(miVector);
		VectorDeNumeros.mostrarVector(miVector);
	}

}
