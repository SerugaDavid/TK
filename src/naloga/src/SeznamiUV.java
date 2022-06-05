package naloga.src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class SeznamiUV {

    Seznam<Oseba> seznamPoImenu;
    Seznam<Oseba> seznamPoEmso;

    static String memoryError = "Error: not enough memory, operation failed";

    public SeznamiUV() {
        this.seznamPoImenu = new BinomskaKopica<>(new OsebaIme());
        this.seznamPoEmso = new BinomskaKopica<>(new OsebaEmso());
    }

    public String processInput(String input) {
        String token;
        String result = "OK";
        String[] params = input.split(" ");


        //moramo preverjati za primer praznega Niza
        if (params.length == 0) {
            return "Error: enter command";
        } else {
            token = params[0];
        }
        try {

//            if (token.equals("use")) {
//                if (params.length > 1) {
//                    String structType = params[1];
//                    seznamPoImenu = seznamiPoImenu.get(structType);
//                    seznamPoEmso = seznamiPoTelSt.get(structType);
//                    if (null == seznamPoImenu) {
//                        result = "Error: please specify a correct data structure type {pv|sk|bst}";
//                    }
//
//                } else {
//                    result = "Error: please specify a data structure type {pv|sk|bst}";
//                }
//            } else if (token.equals("add")) { // done
//                if (params.length == 4) {
//                    seznamPoImenu.add(new Prijatelj(params[1], params[2], params[3]));
//                    seznamPoEmso.add(new Prijatelj(params[1], params[2], params[3]));
//                } else
//                    result = "Error: please specify three strings";
//            } else if (token.equals("removefirst")) { // done
//                Prijatelj tmp = seznamPoImenu.removeFirst();
//                result = tmp.toString();
//                seznamPoEmso.remove(tmp);
//            } else if (token.equals("remove")) { // done
//                if (params.length == 3) {
//                    Prijatelj tmp = seznamPoImenu.remove(new Prijatelj(params[1], params[2], ""));
//                    seznamPoEmso.remove(tmp);
//                } else
//                    result = "Error: please specify two strings";
//            } else if (token.equals("getfirst")) {
//                result = seznamPoImenu.getFirst().toString();
//            } else if (token.equals("count")) {
//                result = seznamPoImenu.size() + "";
//            } else if (token.equals("depth")) { // done
//                result = "Po imenu: " + seznamPoImenu.depth() + "\n";
//                result += "Po tel. številki: " + seznamPoEmso.depth() + "";
//            } else if (token.equals("reset")) { // done
//                while (!seznamPoImenu.isEmpty()) {
//                    seznamPoImenu.removeFirst();
//                }
//                while (!seznamPoEmso.isEmpty()) {
//                    seznamPoEmso.removeFirst();
//                }
//            } else if (token.equals("exists")) {
//                result = "No";
//                if (params.length == 3) {
//                    if (seznamPoImenu.exists(new Prijatelj(params[1], params[2], "")))
//                        result = "Yes";
//                } else if (params.length == 2) {
//                    if (seznamPoEmso.exists(new Prijatelj("", "", params[1])))
//                        result = "Yes";
//                } else {
//                    result = "Error: please specify two strings";
//                }
//            } else if (token.equals("print")) { // done
//                seznamPoImenu.print();
//                seznamPoEmso.print();
//            } else if (token.equals("save")) { // done
//                if (params.length == 3) {
//                    seznamPoImenu.save(new FileOutputStream(params[1]));
//                    seznamPoEmso.save(new FileOutputStream(params[2]));
//                } else {
//                    result = "Error: please specify both file names";
//                }
//            } else if (token.equals("restore")) { // done
//                if (params.length == 3) {
//                    seznamPoImenu.restore(new FileInputStream(params[1]));
//                    seznamPoEmso.restore(new FileInputStream(params[2]));
//                } else {
//                    result = "Error: please specify both file names";
//                }
//            } else {
//                result = "Error: invalid command";
//            }
//

        } catch (UnsupportedOperationException e) {
            result = "Error: Operation not supported";
        } catch (IllegalArgumentException e) {
            result = "Error: Duplicated entry";
        } catch (java.util.NoSuchElementException e) {
            result = "Error: structure is empty";
        } catch (IOException e) {
            result = "Error: IO error " + e.getMessage();
        } catch (ClassNotFoundException e) {
            result = "Error: Unknown format";
        } catch (OutOfMemoryError e) {
            return memoryError;
        }

        return result;
    }
}
