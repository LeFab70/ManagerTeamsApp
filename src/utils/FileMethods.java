package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileMethods {

    public static void writeFile(final String fichier,final String msg) throws FileNotFoundException {
        try {
            File monFichier = new File(fichier);
            FileWriter fileWriter=new FileWriter(monFichier,true); // permet de faire ajout sans écraser ancien contenu
            PrintWriter pw = new PrintWriter(fileWriter);
            pw.append(msg);

            pw.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static List<String> readFile(final String fileName) throws FileNotFoundException {
        Scanner scanner = null;
        try
        {
            List<String> allLines=new ArrayList<>();

            File file=new File(fileName);
            if (!file.exists()) {
                System.out.println("Le fichier n'existe pas");
                return allLines;
            }

            scanner=new Scanner(file);
            while (scanner.hasNextLine())
            {
                allLines.add(scanner.nextLine());
            }
            return allLines;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        finally {
            if(scanner != null)
                scanner.close();
        }
    }


}
