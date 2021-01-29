package com.task1a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class ApiFileManager {

    public void writeToFile(String fileToGet, int[] arrayToWrite) {
        Path path = Paths.get(fileToGet);
        ArrayList<String> lines = new ArrayList<>();
        for (int i:arrayToWrite) {
            lines.add(Integer.toString(i));
        }
        lines.add("\n");
        try {
            Files.write(path, lines, StandardOpenOption.CREATE, APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String fileToGet, String output) {
        Path path = Paths.get(fileToGet);
        ArrayList<String> lines = new ArrayList<>();
        lines.add(output);
        try {
            Files.write(path, lines, StandardOpenOption.CREATE, APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readIntFile(String fileName, int[] readNums) {

        java.io.FileInputStream inFile = null;
        //int readInt = 0;
        try {
            inFile = new java.io.FileInputStream(fileName);
            Scanner reader = new Scanner(inFile);
            int i = 0;
            while (reader.hasNext() && i < readNums.length) {
                readNums[i] = reader.nextInt();
                i++;
            }
            //System.out.println(readInt);
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readStringFile(String fileName, ArrayList<String> lines) {
        java.io.FileInputStream inFile = null;
        try {
            inFile = new java.io.FileInputStream(fileName);
            Scanner reader = new Scanner(inFile);
            while(reader.hasNext()) {
                lines.add(reader.nextLine());
            }
            //System.out.println(readString);
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
