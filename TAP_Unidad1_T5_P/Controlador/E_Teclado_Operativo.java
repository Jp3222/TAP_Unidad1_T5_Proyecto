package Controlador;

import Vista.Panel_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.util.ArrayDeque;
import java.util.Queue;
import Modelo.Operaciones;

public class E_Teclado_Operativo implements ActionListener {

    private Panel_1 P;
    private JButton T[];
    private boolean Igual;
    private static Queue<String> QueueOperation;
    private boolean ModBlack = false;
    private Operaciones operacion;

    public E_Teclado_Operativo(Panel_1 P, JButton T[]) {
        this.Igual = false;
        this.P = P;
        this.T = new JButton[T.length];
        this.T = T;
        operacion = new Operaciones();
        QueueOperation = new ArrayDeque<>();
        iniciarTeclado();
    }

    public void iniciarTeclado() {
        P.teclado_Operadores(T);
        T[0].addActionListener(this);
        T[1].addActionListener(this);
        T[2].addActionListener(this);
        T[3].addActionListener(this);
        T[4].addActionListener(this);
        T[5].addActionListener(this);
        T[6].addActionListener(this);
        T[7].addActionListener(this);
        T[8].addActionListener(this);
        T[9].addActionListener(this);
        T[10].addActionListener(this);
        T[11].addActionListener(this);
        T[12].addActionListener(this);
    }

    @Override
    @SuppressWarnings("UnusedAssignment")
    public void actionPerformed(ActionEvent e) {
        String N = P.jtfNumero.getText();

        if (e.getSource() == T[0]) {//Metodo de suma
            if (N.isEmpty() && P.jtaResultado.getText().isEmpty()) {
                return;
            }
            QueueOperation.add(N);
            QueueOperation.add("+");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[1]) {//Metodo de resta
            if (N.isEmpty() && P.jtaResultado.getText().isEmpty()) {
                return;
            }
            QueueOperation.add(N);
            QueueOperation.add("-");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[2]) {//Metodo de multiplicacion
            if (N.isEmpty() && P.jtaResultado.getText().isEmpty()) {
                return;
            }
            QueueOperation.add(N);
            QueueOperation.add("*");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[3]) {//Metodo de divicion
            if (N.isEmpty() && P.jtaResultado.getText().isEmpty()) {
                return;
            }
            QueueOperation.add(N);
            QueueOperation.add("/");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[4]) { //Raiz cuadrada
            if (N.isEmpty() && P.jtaResultado.getText().isEmpty()) {
                return;
            }
            QueueOperation.add(N);
            QueueOperation.add("√");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[5]) {//potencia al cuadrado
            if (N.isEmpty() && P.jtaResultado.getText().isEmpty()) {
                return;
            }
            QueueOperation.add(N);
            QueueOperation.add("^");
            QueueOperation.add("2");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[6]) {//potencia a la n
            if (N.isEmpty() && P.jtaResultado.getText().isEmpty()) {
                return;
            }
            QueueOperation.add(N);
            QueueOperation.add("^");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[7]) {//Factorial
            if (N.isEmpty() && P.jtaResultado.getText().isEmpty()) {
                return;
            }
            QueueOperation.add(N);
            QueueOperation.add("!");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[8]) {//seno
            P.jtfNumero.setText("sen");
            QueueOperation.add("sen");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[9]) {//coseno
            P.jtfNumero.setText("cos");
            QueueOperation.add("cos");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[10]) {//tangente
            P.jtfNumero.setText("tan");
            QueueOperation.add("cos");
            P.jtaResultado.setText(QueueOperation.toString());
            P.jtfNumero.setText("");
        } else if (e.getSource() == T[11]) {
            if (N.isEmpty()) {
                return;
            }
            String aux = "";
            for (int i = 0; i < N.length() - 1; i++) {
                aux += N.charAt(i);
            }
            N = aux;
            P.jtfNumero.setText(N);
        } else if (e.getSource() == T[12]) {
            if (!P.jtfNumero.getText().isEmpty()) {
                QueueOperation.add(P.jtfNumero.getText());
            }
            QueueOperation.add("=");
            double r = operacion.funcion(QueueOperation);
            P.jtfNumero.setText("");
            P.jtaResultado.setText("" + r);
            while (!QueueOperation.isEmpty()) {
                QueueOperation.poll();
            }
        }
    }

    public static void Queue() {
        QueueOperation = new ArrayDeque<>();
    }

    /*
    [0] + 
    [1] - 
    [2] * 
    [3] /
    [4] √
    [5] n^2
    [6] n^n
    [7] !
    [8] sen
    [9] cos
    [10] tan
    [11] <-
    [12] =
     */
}
