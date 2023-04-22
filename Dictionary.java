import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class Dictionary {
    private BinarySearchTree englishTree;
    private BinarySearchTree spanishTree;
    private BinarySearchTree frenchTree;
    /**
     * 
     * @param filename
     */
    public Dictionary(String filename) {
        englishTree = new BinarySearchTree();
        spanishTree = new BinarySearchTree();
        frenchTree = new BinarySearchTree();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                String english = words[0];
                String spanish = words[1];
                String french = words[2];
                if (words.length == 3) {
                    englishTree.put(english, new Translation(english, spanish, french));
                    spanishTree.put(spanish, new Translation(english, spanish, french));
                    frenchTree.put(french, new Translation(english, spanish, french));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @param word
     * @param tolanguage
     * @param languaje
     * @return
     */
    public String translate(String word, String tolanguage, String languaje) {

        Translation translationen = null;
        Translation translationes = null;
        Translation translationfr = null;
            if (languaje == "english"){
                translationen =  englishTree.get(word);
                if (translationen == null){
                    return "Translation no found";
                } else{
                    switch (tolanguage) {
                        case "english":
                            return translationen.getEnglish();
        
                        case "spanish":
                            return translationen.getSpanish();
                        case "french":
                            return translationen.getFrench();
                        default:
                            return null;
                    }
                }
            } else if (languaje == "spanish"){
                translationes =  spanishTree.get(word);
                if (translationes == null){
                    return "Translation no found";
                } else{
                    switch (tolanguage) {
                        case "english":
                            return translationes.getEnglish();
        
                        case "spanish":
                            return translationes.getSpanish();
                        case "french":
                            return translationes.getFrench();
                        default:
                            return null;
                    }
                }
                } else if (languaje == "french");
                translationfr =  frenchTree.get(word);
                if (translationfr == null){
                    return "Translation no found";
                } else{
                    switch (tolanguage) {
                        case "english":
                            return translationfr.getEnglish();
        
                        case "spanish":
                            return translationfr.getSpanish();
                        case "french":
                            return translationfr.getFrench();
                        default:
                            return null;
                    }
                }
            }
            /**
             * 
             * @param filename
             */
    private void readDictionary(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length == 3) {
                    String english = words[0];
                    String spanish = words[1];
                    String french = words[2];
                    Translation translation = new Translation(english, spanish, french);
                    englishTree.put(english, translation);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @param lenguap
     * @return
     */
    public String detectLenguage(String lenguap){
        try {
            Scanner scanner = new Scanner(new File("diccionario.txt"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] palabras2 = linea.split(" ");
                if (palabras2[0].equals(lenguap)) {
                    // Hacer algo con la línea que empieza con "palabra"
                    return "Es Inglés";
                } else if (palabras2[1].equals(lenguap)){
                    return "Es Español";
                }else if (palabras2[2].equals(lenguap)){
                    return "Es Francés";
            }
        }
        scanner.close();
        } catch (FileNotFoundException e) {
            return "El archivo no se encontro";
        }
        return "idioma desconocido";
    }
}