package Izziv3;

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
        String line;
        switch (token) {
            case "push":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                line = sc.nextLine().trim();
                if (line.charAt(0) == '"')
                    line = line.substring(1, line.length() - 1);
                sklad.push(line);
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
            case "count":
                result = String.valueOf(sklad.size());
                break;
            case "isTop":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                line = sc.nextLine().trim();
                if (line.charAt(0) == '"')
                    line = line.substring(1, line.length() - 1);
                try {
                    if (line.equals(sklad.top()))
                        break;
                    return "Error: wrong element";
                } catch (NoSuchElementException e) {
                    return "Error: stack is empty";
                }
            case "search":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                line = sc.nextLine().trim();
                if (line.charAt(0) == '"')
                    line = line.substring(1, line.length() - 1);
                Sklad<String> tmpSklad = new Sklad<>();
                int count = 0;
                while (!sklad.isEmpty()) {
                    tmpSklad.push(sklad.pop());
                    if (line.equals(tmpSklad.top()))
                        return String.valueOf(count);
                    count++;
                }
                while (!tmpSklad.isEmpty())
                    sklad.push(tmpSklad.pop());
                return "-1";
        }
        return result;
    }

}
