
import java.util.Scanner;


public class Incentivo {
    //sistema de incentivo de acordo com notas de alunos
    private int quantidade; // quantidade de alunos
    private double[] nota; // array para armazenar as notas
    private int[] alunos; // array para armazenar os números dos alunos
    private Scanner scanner = new Scanner(System.in);

    public void getPupils(){
        //registra quantos alunos estao realizaram o exame
        
        System.out.print("Quantos alunos realizaram o exame? ");
        quantidade = scanner.nextInt();
        
        if (quantidade <= 0) {
            System.out.println("Erro: A quantidade de alunos deve ser maior que zero.");
            scanner.close();
            return;
        }

        alunos = new int[quantidade];
        nota = new double[quantidade];
    }


    public void getGrades(){
        //associa nota com aluno
        for (int i = 0; i < quantidade; i++){
            System.out.print("Digite o número do aluno " + (i + 1) + ": ");
            alunos[i] = scanner.nextInt();
     
            System.out.print("Digite a nota do aluno " + alunos[i] + ": ");
            nota[i] = scanner.nextDouble();

            while (nota[i] < 0 || nota[i] > 10){
                System.out.print("Erro: a nota deve estar entre 0 e 10.");
                System.err.print("Digite a nota do aluno " + alunos[i] + " novamente: ");
                nota[i] = scanner.nextDouble();
            }
        }
    }


    public void getAnalise(){
        //analisa notas evidenciando maior e menor
        int maiorNota = 0;
        int menorNota = 0;

        for (int i = 1; i < quantidade; i++) {
            if (nota[i] > nota[maiorNota]) {
                maiorNota = i;
            }
            if (nota[i] < nota[menorNota]) {
                menorNota = i;
            }
        }
    
        //mostra resultado da menor e maior nota
        System.out.println("\n=== Resultados ===");
        System.out.println("\nBônus de Desempenho:");
        System.out.printf("O aluno %d receberá um bônus por ter alcançado a maior nota: %.2f\n", 
                         alunos[maiorNota], nota[maiorNota]);
        
        System.out.println("\nIncentivo de Estudo:");
        System.out.printf("O aluno %d receberá incentivo de estudo por ter a nota: %.2f\n", 
                         alunos[menorNota], nota[menorNota]);
    }


    public static void main(String[] args) {
        Incentivo incentivo = new Incentivo();
        incentivo.getPupils();
        if (incentivo.quantidade > 0) {
            incentivo.getGrades();
            incentivo.getAnalise();
        }
        incentivo.scanner.close();
    }
}