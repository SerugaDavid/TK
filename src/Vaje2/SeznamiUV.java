package Vaje2;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SeznamiUV {

    private Sklad<String> sklad;

    public SeznamiUV() {
        sklad = new Sklad<String>();
    }

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String result = "OK";
        switch (token) {
            case "push":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                sklad.push(sc.next());
                break;
            case "pop":
                try {
                    result = sklad.pop();
                } catch (NoSuchElementException e) {
                    return "Error: stack is empty";
                }
                break;
            case "reset":
                while (!sklad.isEmpty())
                    sklad.pop();
                break;
        }
        return result;
    }

}
