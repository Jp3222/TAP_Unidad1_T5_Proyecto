package Modelo;

import java.util.Queue;

public class Operaciones {
    
    public double r;
    
    public Operaciones() {
        this.r = 0;
    }
    
    public double expresion(Queue<String> P) {
        System.out.println(P);
        if (P.peek().equals("=")) {
            return r;
        } else if (P.peek().equalsIgnoreCase("+")) {
            P.poll();
            if (other(P.peek())) {
                r += expresion(P);
            } else if (other_3(P.peek())) {
                P.poll();
                r += Factorial(Double.parseDouble(P.poll()));
            } else if (other_2(P.peek())) {
                
            } else {
                r = suma(P.poll());
            }
        } else if (P.peek().equalsIgnoreCase("-")) {
            P.poll();
            if (other(P.peek())) {
                System.out.println("true");
                r -= expresion(P);
            } else if (other_3(P.peek())) {
                P.poll();
                r -= Factorial(Double.parseDouble(P.poll()));
            } else {
                r = resta(P.poll());
            }
            
        } else if (P.peek().equalsIgnoreCase("*")) {
            P.poll();
            if (other(P.peek())) {
                System.out.println("true");
                r *= expresion(P);
            } else if (other_3(P.peek())) {
                P.poll();
                r *= Factorial(Double.parseDouble(P.poll()));
            } else {
                r = multiplicacion(P.poll());
            }
        } else if (P.peek().equalsIgnoreCase("/")) {
            P.poll();
            if (other(P.peek())) {
                System.out.println("true");
                r /= expresion(P);
            } else if (other_3(P.peek())) {
                P.poll();
                r /= Factorial(Double.parseDouble(P.poll()));
            } else {
                r = divicion(P.poll());
            }
        } else if (P.peek().equalsIgnoreCase("√")) {
            r = Math.sqrt(r);
        } else if (P.peek().equalsIgnoreCase("^")) {
            P.poll();
            r = Math.pow(r, Double.parseDouble(P.poll()));
        } else if (P.peek().equalsIgnoreCase("!")) {
            P.poll();
            r = Factorial(Double.parseDouble(P.poll()));
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
        expresion(P);
        return r;
    }
    
    public boolean other(String p) {
        return p.equalsIgnoreCase("sen") || p.equalsIgnoreCase("cos") || p.equalsIgnoreCase("tan");
    }
    
    public boolean other_2(String p) {
        return p.equalsIgnoreCase("+") || p.equalsIgnoreCase("-");
    }
    
    public boolean other_3(String p) {
        return p.equalsIgnoreCase("!") || p.equalsIgnoreCase("^");
    }
    
    @SuppressWarnings("NestedAssignment")
    public double suma(String p) {
        return r += Double.parseDouble(p);
    }
    
    @SuppressWarnings("NestedAssignment")
    public double resta(String p) {
        return r -= Double.parseDouble(p);
    }
    
    @SuppressWarnings("NestedAssignment")
    public double multiplicacion(String p) {
        return r *= Double.parseDouble(p);
    }
    
    @SuppressWarnings("NestedAssignment")
    public double divicion(String p) {
        return r /= Double.parseDouble(p);
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
}
