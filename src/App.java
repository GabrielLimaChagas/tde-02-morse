import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MorseTree tree = new MorseTree();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Decodificador de Código Morse ---");
        System.out.print("Digite a sequencia de Código Morse (separada por espaco, e.g., .... . .-.. .-.. ---): ");
        String inputMorse = scanner.nextLine();

        String decodedResult = tree.decodeWord(inputMorse.toUpperCase());

        System.out.println("Palavra Decodificada: " + decodedResult);

        tree.printTree();

        scanner.close();
    }
}
