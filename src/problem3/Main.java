package problem3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the path you want to check:");
            String pathString = scanner.nextLine();

            Path path = Paths.get(pathString);
            System.out.println(Files.exists(path));
        }


    }
}
