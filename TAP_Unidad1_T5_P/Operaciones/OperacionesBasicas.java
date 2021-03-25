package Operaciones;

public class OperacionesBasicas {

    private double op;

    public OperacionesBasicas() {
        this.op = 0;
    }

    public double getOp() {
        return op;
    }

    public void setOp(double op) {
        this.op = op;
    }

    public void suma(double a) {
        op += a;
    }

    public void resta(double a) {
        op -= a;
    }

    public void multiplicacion(double a) {
        op *= a;
    }

    public void divicion(double a) {
        op /= a;
    }

    public double raiz(double a) {
        return Math.sqrt(a);
    }

    public void exp(double e) {
        op *= e;
    }

    public double sen(double a) {
        return Math.sin(a);
    }

    public double cos(double a) {
        return Math.cos(a);
    }

    public double tan(double a) {
        return Math.tan(a);
    }

}
