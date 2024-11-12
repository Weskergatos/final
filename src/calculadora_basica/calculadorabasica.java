package calculadora_basica;
import java.util.InputMismatchException;
import java.util.Scanner;


public class calculadorabasica {

	    enum Operacion {
	        SUMA("+"),
	        RESTA("-"),
	        MULTIPLICA("*"),
	        DIVIDE("/"),
	        MODULO("%"),
	        ELEVA("^");

	        private final String simbolo;

	        Operacion(String simbolo) {
	            this.simbolo = simbolo;
	        }

	        public String getSimbolo() {
	            return switch (simbolo) {
	                case "*" -> "×";
	                case "/" -> "÷";
	                default -> simbolo;
	            };
	        }

	        public static Operacion obtenerDesdeSimbolo(String operador) {
	            for (Operacion op : Operacion.values()) {
	                if (op.simbolo.equals(operador)) {
	                    return op;
	                }
	            }
	            throw new IllegalArgumentException("Operador invalido: " + operador);
	        }
	    }

	    private static Double calcular(Operacion operacion, Double num1, Double num2) {
	        return switch (operacion) {
	            case SUMA -> num1 + num2;
	            case RESTA -> num1 - num2;
	            case MULTIPLICA -> num1 * num2;
	            case DIVIDE -> num2 == 0.0 ? Double.NaN : num1 / num2;
	            case MODULO -> num1 % num2;
	            case ELEVA -> Math.pow(num1, num2);
	        };
	    }

	    private static double leerNumero(Scanner scanner) {
	        while (true) {
	            try {
	                return scanner.nextDouble();
	            } catch (InputMismatchException e) {
	                System.out.println("Por favor, ingrese un numero valido.");
	                scanner.next();
	            }
	        }
	    }

	    private static Operacion leerOperacion(Scanner scanner) {
	        while (true) {
	            System.out.println("Operaciones disponibles: +, -, *, /, %, ^");
	            System.out.print("Elige la operacion: ");
	            String operadorIngresado = scanner.next();
	            try {
	                return Operacion.obtenerDesdeSimbolo(operadorIngresado);
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	    }

	    public static void main(String[] args) {

	        try (Scanner scanner = new Scanner(System.in)) {
	            System.out.print("Ingrese el primer numero: ");
	            double numero1 = leerNumero(scanner);

	            System.out.print("Ingrese el segundo numero: ");
	            double numero2 = leerNumero(scanner);

	            Operacion operacion = leerOperacion(scanner);

	            double resultado = calcular(operacion, numero1, numero2);
	            System.out.println("Operacion: " + numero1 + " " + operacion.getSimbolo() + " " + numero2);
	            System.out.println("Resultado: " + resultado);
	        }
	    }
	}

	