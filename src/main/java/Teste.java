import java.util.Random;
import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);	
		int n = 10;
		int i;
		int v1[] = new int[n];
		
		for (i=0; i<n; i++){	
			Random gerador = new Random();
			int num = gerador.nextInt(4) + 1;
			v1[i] = num;
		}
		
		for (i = 0; i<n; i++){
			System.out.println(v1[i]);
			System.out.println("Valor: ");
			int num = entrada.nextInt();
			if (v1[i] != num){
				System.out.println("GAME OVER");
				return;
			}
//			System.out.println("Valor " + i + ": " + v1[i]);
		}
		
		
	}
}
