package naloga.src;

import java.util.Scanner;

public class Aplikacija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tvoje ime: ");
        String ime = sc.nextLine();
        System.out.println(ime);
    }
}
