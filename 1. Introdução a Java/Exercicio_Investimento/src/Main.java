import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        System.out.println("Digite o capital: ");
        double capital = ent.nextDouble();

        System.out.println("Digite a taxa: ");
        double taxa = ent.nextDouble();

        System.out.println("Digite o tempo: ");
        int tempo = ent.nextInt();

        double montante = capital * Math.pow((1+taxa),tempo);
        System.out.printf("Montante: %.2f", montante);

    }
}