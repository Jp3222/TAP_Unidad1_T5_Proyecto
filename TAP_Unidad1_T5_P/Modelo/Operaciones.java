package Modelo;

import java.util.Queue;

public class Operaciones {

    public double funcion(Queue<String> P) {
        double r = 0;
        for (int i = 0; i < P.size(); i++) {
            if (P.peek().equals("=")) {
                break;
            } else if (P.peek().equalsIgnoreCase("+")) {
                P.poll();
                r += Double.parseDouble(P.poll());
            } else if (P.peek().equalsIgnoreCase("-")) {
                P.poll();
                r -= Double.parseDouble(P.poll());
            } else if (P.peek().equalsIgnoreCase("*")) {
                P.poll();
                r *= Double.parseDouble(P.poll());
            } else if (P.peek().equalsIgnoreCase("/")) {
                P.poll();
                r /= Double.parseDouble(P.poll());
            } else if (P.peek().equalsIgnoreCase("√")) {
                r = Math.sqrt(r);
            } else if (P.peek().equalsIgnoreCase("^")) {
                P.poll();
                r = Math.pow(r, Double.parseDouble(P.poll()));
            } else if (P.peek().equalsIgnoreCase("!")) {
                r = Factorial(r);
            } else if (P.peek().equalsIgnoreCase("sen")) {
                P.poll();
                r = Math.sin(Double.parseDouble(P.poll()));
            } else if (P.peek().equalsIgnoreCase("cos")) {
                P.poll();
                r = Math.cos(Double.parseDouble(P.poll()));
            } else if (P.peek().equalsIgnoreCase("tan")) {
                P.poll();
                r = Math.tan(Double.parseDouble(P.poll()));
            } else {
                r = Double.parseDouble(P.poll());
            }
        }
        return r;
    }

    public boolean other(String p) {
        return p.equalsIgnoreCase("sen") || p.equalsIgnoreCase("con") || p.equalsIgnoreCase("tan");
    }

    public double Factorial(double n) {
        if (n < 0) {
            return 0;
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }
