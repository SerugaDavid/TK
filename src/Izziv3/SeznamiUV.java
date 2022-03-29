package Izziv3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SeznamiUV {

    private Sklad<String> sklad;
    private PrioritetnaVrsta<String> vrsta;

    public SeznamiUV() {
        this.sklad = new Sklad<String>();
        this.vrsta = new PrioritetnaVrsta<String>();
    }

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String result = "OK";
        String line;
        switch (token) {
            case "s_add":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                line = sc.nextLine().trim();
                if (line.charAt(0) == '"')
                    line = line.substring(1, line.length() - 1);
                this.sklad.add(line);
                break;
            case "s_remove":
                try {
                    result = this.sklad.removeFirst();
                } catch (NoSuchElementException e) {
                    return "Error: stack is empty";
                }
                break;
            case "s_reset":
                while (!this.sklad.isEmpty())
                    this.sklad.removeFirst();
                break;
            case "s_size":
                result = String.valueOf(sklad.size());
                break;
            case "s_isTop":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                line = sc.nextLine().trim();
                if (line.charAt(0) == '"')
                    line = line.substring(1, line.length() - 1);
                try {
                    if (line.equals(this.sklad.getFirst()))
                        break;
                    return "Error: wrong element";
                } catch (NoSuchElementException e) {
                    return "Error: stack is empty";
                }
            case "s_search":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                line = sc.nextLine().trim();
                if (line.charAt(0) == '"')
                    line = line.substring(1, line.length() - 1);
                Sklad<String> tmpSklad = new Sklad<>();
                int count = 0;
                while (!this.sklad.isEmpty()) {
                    tmpSklad.add(this.sklad.removeFirst());
                    if (line.equals(tmpSklad.removeFirst()))
                        return String.valueOf(count);
                    count++;
                }
                while (!tmpSklad.isEmpty())
                    this.sklad.add(tmpSklad.removeFirst());
                return "-1";
            case "pq_add": // brez elementov z več nizi “"
                if (sc.hasNext()) {
                    String val = sc.next();
                    this.vrsta.add(val);
                }
                else
                    result = "Error: please specify a string";
                break;
            case "pq_remove_first":
                if (!this.vrsta.isEmpty())
                    result = this.vrsta.removeFirst();
                else
                    result = "Error: priority queue is empty";
                break;
            case "pq_get_first":
                if (!this.vrsta.isEmpty())
                    result = this.vrsta.getFirst();
                else
                    result = "Error: priority queue is empty";
                break;
            case "pq_size":
                result = String.valueOf(this.vrsta.size());
                break;
            case "pq_isEmpty":
                result = String.valueOf(this.vrsta.isEmpty());
                break;
            case "pq_depth":
                result = String.valueOf(this.vrsta.depth());
                break;
        }
        return result;
    }

}
