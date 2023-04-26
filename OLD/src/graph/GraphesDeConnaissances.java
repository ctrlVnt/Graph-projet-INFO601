package graph;

import java.util.HashMap;
import java.io.BufferedReader;
import java.util.Map;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.lang.Double;
import java.util.Scanner;
import graphlibrary.*;

public class GraphesDeConnaissances {

  private static Graph<String, String> graphtest;

  private static Graph<String, String> test() throws GraphException{

    graphtest = new Graph<>(false);

    String a, b, c, d, e, f, g, h, i;
    a = "Elisa";
    b ="Student";
    c = "Enrico";
    e ="Age";
    f ="Riccardo";
    g = "fac";
    h ="23";
    i = "USMB";

    Node<String, String> a1;
    Node<String, String> c1;
    Node<String, String> f1;
    Node<String, String> i1;

    graphtest.addNode(a1);


    return graphtest;
  }
    

  private static void printPath(Node<String, Double> element) {
    if (element != null) {
      printPath(element.getNodeFather());
      System.out.println("-> " + element.getNodeName() + " ->");
    }
  }

  private static void printAllMinimalPaths(Graph<String, String> S) {
    for (Map.Entry<String, Node<String, String>> entry : S.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }


  public static void main(String[] args) throws GraphException, IOException, Exception {
    Graph<String, String> test = test();
    boolean printAll = false;

    if (printAll == true) {
      printAllMinimalPaths(test);
    }

    System.out.println("\nFINE\n");

  }
}
