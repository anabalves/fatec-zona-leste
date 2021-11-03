import java.util.Locale;
import java.util.Scanner;

public class Exercicio63 {

	private static Scanner scan;
	
	private static double calcularSerie(double num) {
		
		double i, resultSerie = 0;
		
		for (i = 1; i <= num; i++) {
			resultSerie += (1 / i);
		}
		
		return resultSerie;
	}

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		scan = new Scanner(System.in);

		double num;

		System.out.print("Digite um numero para ser o limite do denominador da serie: ");
		num = scan.nextInt();
		
		System.out.printf("O resultado da soma da serie e %.2f", calcularSerie(num));
		
		scan.close();

	}

}