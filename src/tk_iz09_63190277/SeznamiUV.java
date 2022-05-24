package tk_iz09_63190277;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SeznamiUV {

    private HashMap<String, Seznam<String>> seznami;
    Seznam<String> seznam;
    String currSeznam;

    private final String memoryError = "Error: not enough memory, operation failed";

    public SeznamiUV() {
        this.seznami = new HashMap<>();
    }

    public void addImpl(String key, Seznam<String> seznam) {
        this.seznami.put(key, seznam);
    }

    public String processInput(String input) {
        Scanner sc = new Scanner(input);
        String token = sc.next();
        String result = "OK";
        String line;
        try {
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
                            result = "Error: IO error";
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

            }
        } catch (OutOfMemoryError e) {
            System.err.println(memoryError);
            return memoryError;
        }
        return result;
    }
}
