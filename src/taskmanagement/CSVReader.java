package taskmanagement;

import java.io.*;

public abstract class CSVReader {


    public static String csvToString(String filePath){

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = null;
            StringBuilder fileString = new StringBuilder();
            boolean isValidLine = false;
            do {
                line = br.readLine();
                isValidLine = line != null && !line.equals("\n") && !line.equals("");
                if (isValidLine) {
                    fileString.append(line).append("\n");
                }

            } while (isValidLine);

            br.close();
            return fileString.toString();

        } catch (Exception e){
            System.out.println("Error: FileIO failed.");
            System.out.println(e);
            System.exit(0);
            return null;
        }

    }

   public static String[][] csvToArray(String filePath){
        String fileString = csvToString(filePath);
        String[] arrayOfLines = fileString.split("\n");
        String[][] csvArray = new String[arrayOfLines.length][];

        for (int i = 0; i < arrayOfLines.length; i++){
            csvArray[i] = arrayOfLines[i].split(",");
        }

        return csvArray;

   }

}


