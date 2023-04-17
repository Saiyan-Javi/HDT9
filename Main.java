import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> dictionary;

        System.out.println("Seleccione el tipo de árbol a utilizar:");
        System.out.println("1. Red Black Tree");
        System.out.println("2. Splay Tree");
        System.out.println("3. Binary Search Tree");

        int option = scanner.nextInt();

        if (option == 1) {
            dictionary = new RedBlackTree<>();
        } else if (option == 2) {
            dictionary = new SplayTree<>();
        } else {
            dictionary = new BinarySearchTree<>();
        }

        try {
            Scanner fileScanner = new Scanner(new File("spanish.txt"));
            while (fileScanner.hasNextLine()) {
                String[] line = fileScanner.nextLine().split("=");
                dictionary.put(line[0].trim(), line[1].trim());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
            return;
        }

        scanner.nextLine(); // Clear scanner buffer

        System.out.println("Seleccione una opción:");
        System.out.println("1. Leer archivo");
        System.out.println("2. Ingresar oración");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear scanner buffer

        if (choice == 1) {
            System.out.println("Ingrese el nombre del archivo:");
            String fileName = scanner.nextLine();

            try {
                Scanner fileScanner = new Scanner(new File(fileName));
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        String translatedWord = dictionary.get(word.toLowerCase());
                        if (translatedWord == null) {
                            translatedWord = "*" + word.toLowerCase() + "*";
                        }
                        System.out.print(translatedWord + " ");
                    }
                    System.out.println();
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo.");
                return;
            }

        } else if (choice == 2) {
            System.out.println("Ingrese la oración a traducir:");
            String sentence = scanner.nextLine();
            String[] words = sentence.split("\\s+");

            for (String word : words) {
                String translatedWord = dictionary.get(word.toLowerCase());
                if (translatedWord == null) {
                    translatedWord = "*" + word.toLowerCase() + "*";
                }
                System.out.print(translatedWord + " ");
            }
            System.out.println();
        }
    }
}
