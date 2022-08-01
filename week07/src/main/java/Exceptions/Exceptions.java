package Exceptions;

import java.io.*;

class Exceptions {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader
                    (new File("data1.txt")));
            String line;
            int i = 0, ct = 1;

            while ((line = br.readLine()) != null) {
                i = Integer.parseInt(line);
                System.out.println("Div result for record = " + ct + " -> " + (5 / i));
                ct++;
            }
        } catch (ArithmeticException e) {
            System.out.println("Invalid operation: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File exception: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("File exception: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //do something with the exception
                }
            }
            System.out.println("--- File End ---\n");
        }

    }
}
