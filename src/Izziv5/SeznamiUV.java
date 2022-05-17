package Izziv5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SeznamiUV {

    private Sklad<String> sklad;
    private PrioritetnaVrsta<String> vrsta;

    private HashMap<String, Seznam<String>> seznami;
    Seznam<String> seznam;
    String currSeznam;

    public SeznamiUV() {
        this.sklad = new Sklad<String>();
        this.vrsta = new PrioritetnaVrsta<String>();

        this.seznami = new HashMap<>();
        this.seznami.put("pv", new PrioritetnaVrsta<>());
        this.seznami.put("sk", new Sklad<>());
        this.seznami.put("bst", new BST<>());
        this.seznami.put("bk", new BinomskaKopica<>());
    }

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String result = "OK";
        String line;
        switch (token) {
            case "use":
                if (sc.hasNext()) {
                    this.currSeznam = sc.next();
                    this.seznam = this.seznami.get(this.currSeznam);
                    if (this.seznam == null)
                        return "Error: please specify a correct data structure type (pv, sk, bst)";
                } else
                    return "Error: please specify a data structure type (pv, sk, bst)";
                break;
            // used with use
            case "add":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                line = sc.nextLine().trim();
                if (line.charAt(0) == '"')
                    line = line.substring(1, line.length() - 1);
                try {
                    this.seznam.add(line);
                } catch (java.util.InputMismatchException e) {
                    return "Error: element already exists";
                }
                break;
            case "removeFirst":
                try {
                    result = this.seznam.removeFirst();
                } catch (Exception e) {
                    return "Error: data structure is empty";
                }
                break;
            case "getFirst":
                try {
                    result = this.seznam.getFirst();
                } catch (Exception e) {
                    return "Error: data structure is empty";
                }
                break;
            case "size":
                result = String.valueOf(this.seznam.size());
                break;
            case "depth":
                result = String.valueOf(this.seznam.depth());
                break;
            case "isEmpty":
                result = String.valueOf(this.seznam.isEmpty());
                break;
            case "remove":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                line = sc.nextLine().trim();
                if (line.charAt(0) == '"')
                    line = line.substring(1, line.length() - 1);
                try {
                    result = this.seznam.remove(line);
                } catch (Exception e) {
                    if (e instanceof NoSuchElementException)
                        return "Error: element not found";
                    else if (e instanceof EmptyStackException)
                        return "Error: data structure is empty";
                }
                break;
            case "exists":
                if (!sc.hasNext())
                    return "Error: please specify a string";
                line = sc.nextLine().trim();
                if (line.charAt(0) == '"')
                    line = line.substring(1, line.length() - 1);
                try {
                    if (this.seznam.exists(line))
                        return "Element exists in data structure";
                    return "Element does not exist in data structure";
                } catch (EmptyStackException e) {
                    return "Error: data structure is empty";
                }
            case "asList":
                result = String.valueOf(this.seznam.asList());
                break;
            case "print":
                seznam.print();
                break;
            case "save":
                if (sc.hasNext()) {
                    try {
                        seznam.save(new FileOutputStream(sc.next()));
                    } catch (FileNotFoundException e) {
                        result = "Error: file not found";
                    } catch (IOException e) {
                        result = "Error: IO error " + e.getMessage();
                    }
                } else {
                    result = "Error: please specify a file name";
                }
                break;
            case "restore":
                if (sc.hasNext()) {
                    try {
                        seznam.restore(new FileInputStream(sc.next()));
                    } catch (IOException e) {
                        result = "Error: IO error " + e.getMessage();
                    } catch (ClassNotFoundException e) {
                        result = "Error: Unknown format";
                    }

                } else {
                    result = "Error: please specify a file name";
                }
                break;
            case "reset":
                switch (this.currSeznam) {
                    case "pv" -> this.seznami.put("pv", new PrioritetnaVrsta<>());
                    case "sk" -> this.seznami.put("sk", new Sklad<>());
                    case "bst" -> this.seznami.put("bst", new BST<>());
                    case "bk" -> this.seznami.put("bk", new BinomskaKopica<>());
                }
                this.seznam = this.seznami.get(this.currSeznam);
                break;
            case "exit":
                return "Have a nice day.";

//            // for all other cases
//            case "s_add":
//                if (!sc.hasNext())
//                    return "Error: please specify a string";
//                line = sc.nextLine().trim();
//                if (line.charAt(0) == '"')
//                    line = line.substring(1, line.length() - 1);
//                this.sklad.add(line);
//                break;
//            case "s_removeTop":
//                try {
//                    result = this.sklad.removeFirst();
//                } catch (NoSuchElementException e) {
//                    return "Error: stack is empty";
//                }
//                break;
//            case "s_reset":
//                while (!this.sklad.isEmpty())
//                    this.sklad.removeFirst();
//                break;
//            case "s_size":
//                result = String.valueOf(sklad.size());
//                break;
//            case "s_isTop":
//                if (!sc.hasNext())
//                    return "Error: please specify a string";
//                line = sc.nextLine().trim();
//                if (line.charAt(0) == '"')
//                    line = line.substring(1, line.length() - 1);
//                try {
//                    if (line.equals(this.sklad.getFirst()))
//                        break;
//                    return "Error: wrong element";
//                } catch (NoSuchElementException e) {
//                    return "Error: stack is empty";
//                }
//            case "s_search":
//                if (!sc.hasNext())
//                    return "Error: please specify a string";
//                line = sc.nextLine().trim();
//                if (line.charAt(0) == '"')
//                    line = line.substring(1, line.length() - 1);
//                Sklad<String> tmpSklad = new Sklad<>();
//                int count = 0;
//                while (!this.sklad.isEmpty()) {
//                    tmpSklad.add(this.sklad.removeFirst());
//                    if (line.equals(tmpSklad.removeFirst()))
//                        return String.valueOf(count);
//                    count++;
//                }
//                while (!tmpSklad.isEmpty())
//                    this.sklad.add(tmpSklad.removeFirst());
//                return "-1";
//            case "s_remove":
//                if (!sc.hasNext())
//                    return "Error: Please specify a string";
//                line = sc.nextLine().trim();
//                if (line.charAt(0) == '"')
//                    line = line.substring(1, line.length() - 1);
//                try {
//                    String tmp = this.sklad.remove(line);
//                    return tmp;
//                } catch (Exception e) {
//                    if (e instanceof NoSuchElementException)
//                        return "Error: Element not found";
//                    return "Error: Data structure is empty";
//                }
//            case "s_exists":
//                if (!sc.hasNext())
//                    return "Error: Please specify a string";
//                line = sc.nextLine().trim();
//                if (line.charAt(0) == '"')
//                    line = line.substring(1, line.length() - 1);
//                try {
//                    if (this.sklad.exists(line))
//                        return "Element exists in data structure";
//                    return "Element does not exist in data structure";
//                } catch (EmptyStackException e) {
//                    return "Error: Data structure is empty";
//                }
//                // prioritetna vrsta
//            case "pq_add": // brez elementov z več nizi “"
//                if (sc.hasNext()) {
//                    String val = sc.next();
//                    this.vrsta.add(val);
//                } else
//                    result = "Error: please specify a string";
//                break;
//            case "pq_remove_first":
//                if (!this.vrsta.isEmpty())
//                    result = this.vrsta.removeFirst();
//                else
//                    result = "Error: priority queue is empty";
//                break;
//            case "pq_get_first":
//                if (!this.vrsta.isEmpty())
//                    result = this.vrsta.getFirst();
//                else
//                    result = "Error: priority queue is empty";
//                break;
//            case "pq_size":
//                result = String.valueOf(this.vrsta.size());
//                break;
//            case "pq_isEmpty":
//                result = String.valueOf(this.vrsta.isEmpty());
//                break;
//            case "pq_depth":
//                result = String.valueOf(this.vrsta.depth());
//                break;
//            case "pq_remove":
//                if (!sc.hasNext())
//                    return "Error: Please specify a string";
//                line = sc.nextLine().trim();
//                if (line.charAt(0) == '"')
//                    line = line.substring(1, line.length() - 1);
//                try {
//                    String tmp = this.vrsta.remove(line);
//                    return tmp;
//                } catch (Exception e) {
//                    if (e instanceof NoSuchElementException)
//                        return "Error: Element not found";
//                    return "Error: Data structure is empty";
//                }
//            case "pq_exists":
//                if (!sc.hasNext())
//                    return "Error: Please specify a string";
//                line = sc.nextLine().trim();
//                if (line.charAt(0) == '"')
//                    line = line.substring(1, line.length() - 1);
//                try {
//                    if (this.vrsta.exists(line))
//                        return "Element exists in data structure";
//                    return "Element does not exist in data structure";
//                } catch (EmptyStackException e) {
//                    return "Error: Data structure is empty";
//                }
        }
        return result;
    }
}
