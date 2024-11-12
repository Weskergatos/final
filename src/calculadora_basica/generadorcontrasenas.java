package calculadora_basica;
import java.util.Random;

public class generadorcontrasenas {

	    public static void main(String[] args) {
	        int longitud = 10; 
	        System.out.println("Tu contrasena es: " + generarContrasena(longitud));
	    }

	    public static String generarContrasena(int longitud) {
	        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        String contrasena = "";
	        Random random = new Random();

	        for (int i = 0; i < longitud; i++) {
	            int indice = random.nextInt(caracteres.length());
	            contrasena += caracteres.charAt(indice);
	        }

	        return contrasena;
	    }
	}

