import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.io.*;
public class main{
/**
 * 
 * @param args
 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Dictionary dict = new Dictionary("diccionario.txt");
        int op = 0;
        while (op == 0) {
            System.out.println("¿Que tipo de arbol desea utilizar?\n1. BinarySearchTree \n2. RedBlackTree");
            int option0 = Integer.parseInt(in.nextLine());
            switch(option0){
                case 1:
                    System.out.println("----------Bienvenido a mi propio diccionario----------\n 1. Traducir palabra\n 2. Traducir oracion\n 3. Detectar idioma \n 4. salir");
                    int option = Integer.parseInt(in.nextLine());
                    Scanner palabras = new Scanner(System.in);
                    switch (option){
                        case 1: 
                            System.out.println("¿De que idioma quiere traducir?: \n 1. Inglés\n 2. Español\n 3. Francés");
                            int languageOption1 = Integer.parseInt(in.nextLine());
                            String language1;
                            switch (languageOption1) {
                                case 1:
                                    language1 = "english";
                                    break;
                                case 2:
                                    language1 = "spanish";
                                    break;
                                case 3:
                                    language1 = "french";
                                    break;
                                default:
                                    language1 = "";
                                    break;
                            }
                            System.out.println("Ingrese la palabra que quiera traducir, para ver las palabras que tiene el diccionario revise el archivo txt");
                            String word = palabras.next();
                            System.out.println("Seleccione el idioma que desea traducir:\n 1. Inglés\n 2. Español\n 3. Francés");
                            int languageOption = Integer.parseInt(in.nextLine());
                            String language;
                            switch (languageOption) {
                                case 1:
                                    language = "english";
                                    break;
                                case 2:
                                    language = "spanish";
                                    break;
                                case 3:
                                    language = "french";
                                    break;
                                default:
                                    language = "";
                                    break;
                            }
                            String translation = dict.translate(word, language, language1);
                            if (translation == null) {
                                System.out.println("La palabra no se encontró en el diccionario.");
                            } else {
                                System.out.println(word + " -> " + translation);
                            }
                            break;
                        case 2:
                            System.out.println("¿De qué idioma quiere traducir?: \n 1. Inglés\n 2. Español\n 3. Francés");
                            int languageOption2 = Integer.parseInt(in.nextLine());
                            String language2;
                            switch (languageOption2) {
                                case 1:
                                    language2 = "english";
                                    break;
                                case 2:
                                    language2 = "spanish";
                                    break;
                                case 3:
                                    language2 = "french";
                                    break;
                                default:
                                    language2 = "";
                                    break;
                            }
                            System.out.println("Ingrese la oración que quiera traducir:");
                            String sentence = in.nextLine();
                            String[] words = sentence.split(" ");
                            System.out.println("¿A que idioma quieres traducirla?: \n 1. Inglés\n 2. Español\n 3. Francés");
                            int languageOption3 = Integer.parseInt(in.nextLine());
                            String language3;
                            switch (languageOption3) {
                                case 1:
                                    language3 = "english";
                                    break;
                                case 2:
                                    language3 = "spanish";
                                    break;
                                case 3:
                                    language3 = "french";
                                    break;
                                default:
                                    language3 = "";
                                    break;
                            }
                            ArrayList<String> translatedWords = new ArrayList<String>();
                            for (String word2 : words) {
                                String translation2 = dict.translate(word2, language3, language2); 
                                if (translation2 == "Translation no found") {
                                    translatedWords.add("\"" + word2 + "\"");
                                } else {
                                    translatedWords.add(translation2);
                                }
                            }
                            String translatedSentence = String.join(" ", translatedWords);
                            System.out.println(translatedSentence);
                            break;
                        case 3:
                            System.out.println("Ingrese la palabra");
                            String palabra = in.nextLine();
                            String lenguage2002 = dict.detectLenguage(palabra);
                            System.out.println(lenguage2002);
                            break;
                        case 4:
                            op = 1;
                            System.out.println("Gracias por usar este diccionario :)");
                    break;
            }
                    break;
                case 2:
                    break;
            }
         }
        }
    }

