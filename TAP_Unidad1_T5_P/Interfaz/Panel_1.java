package Interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//
import Operaciones.OperacionesBasicas;
import Operaciones.OperacionesTrigonometricas;

@SuppressWarnings("serial")
public class Panel_1 extends JPanel implements ActionListener {

    private JPanel jplPantalla, jplBotones;
    private JTextField Dato;
    private JTextArea Texto;
    private JButton[] jbtOperadores;
    private JButton[] jbtNumeros;
    private boolean punto, igual;
    private OperacionesBasicas opb;
    private OperacionesTrigonometricas opt;

    public Panel_1() {
        setLayout(null);
        setSize(500, 500);
        setBackground(Color.black);
        //
        initcomponents();
        Pantalla();
        Botones();
    }

    private void initcomponents() {
        //
        punto = false;
        igual = false;
        opb = new OperacionesBasicas();
        opt = new OperacionesTrigonometricas();
        //Panel 1
        Texto = new JTextArea("");
        Texto.setBounds(0, 5, getSize().width, 40);
        Texto.setEditable(false);
        Texto.setBackground(Color.yellow);
        //
        Dato = new JTextField("");
        Dato.setBounds(0, 55, getSize().width, 40);
        Dato.setEditable(false);
        Dato.setBackground(Color.red);
        //Panel 2
        jbtOperadores = new JButton[13];
        jbtNumeros = new JButton[10];
        teclado_Numerico();
        teclado_Operadores();
    }

    private void Pantalla() {
        jplPantalla = new JPanel(null);
        jplPantalla.setBackground(Color.white);
        jplPantalla.setSize(500, 100);
        jplPantalla.setLocation(0, 0);
        jplPantalla.add(Texto);
        jplPantalla.add(Dato);
        this.add(jplPantalla);
    }

    private void Botones() {
        jplBotones = new JPanel(null);
        jplBotones.setBackground(Color.lightGray);
        jplBotones.setSize(500, this.getMaximumSize().height - 100);
        addBotonesNumericos();
        addOperadores();
        this.add(jplBotones);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventosNumericos(e);
        EventosOperativos(e);
    }

    public void EventosNumericos(ActionEvent e) {
        if (e.getSource() == jbtNumeros[0]) {
            Dato.setText(Dato.getText() + "1");
        } else if (e.getSource() == jbtNumeros[1]) {
            Dato.setText(Dato.getText() + "2");
        } else if (e.getSource() == jbtNumeros[2]) {
            Dato.setText(Dato.getText() + "3");
        } else if (e.getSource() == jbtNumeros[3]) {
            Dato.setText(Dato.getText() + "4");
        } else if (e.getSource() == jbtNumeros[4]) {
            Dato.setText(Dato.getText() + "5");
        } else if (e.getSource() == jbtNumeros[5]) {
            Dato.setText(Dato.getText() + "6");
        } else if (e.getSource() == jbtNumeros[6]) {
            Dato.setText(Dato.getText() + "7");
        } else if (e.getSource() == jbtNumeros[7]) {
            Dato.setText(Dato.getText() + "8");
        } else if (e.getSource() == jbtNumeros[8]) {
            Dato.setText(Dato.getText() + "1");
        } else if (e.getSource() == jbtNumeros[9]) {
            Dato.setText(Dato.getText() + "0");
        }
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
    [9] con
    [10] tan
    [11] .
    [12] =
     */
    public void EventosOperativos(ActionEvent e) {
        if (igual == true) {
            Texto.setText("");
            igual = false;
        }
        if (punto) {
            punto = false;
        }
        //Suma
        if (e.getSource() == jbtOperadores[0]) {
            //suma
            if (!Dato.getText().isEmpty()) {
                Texto.setText(Texto.getText() + "+" + Dato.getText());
                double a = Double.parseDouble(Dato.getText());
                opb.suma(a);
                Dato.setText("");
            }
        } else if (e.getSource() == jbtOperadores[1]) {
            //resta
            if (!Dato.getText().isEmpty()) {
                Texto.setText(Texto.getText() + "-" + Dato.getText());
                double a = Double.parseDouble(Dato.getText());
                opb.resta(a);
                Dato.setText("");
            }
        } else if (e.getSource() == jbtOperadores[2]) {
            //multiplicacion
        } else if (e.getSource() == jbtOperadores[3]) {
            //divicion
        } else if (e.getSource() == jbtOperadores[4]) {
            //raiz
        } else if (e.getSource() == jbtOperadores[5]) {
            if (Dato.getText().isEmpty()) {
                Texto.setText(Texto.getText() + Dato.getText() + "");
                double a = Double.parseDouble(Dato.getText());
                opb.setOp(a);
                opb.exp(2);
                System.out.println(opb.getOp());
                Dato.setText("");
            }
        } else if (e.getSource() == jbtOperadores[6]) {

        } else if (e.getSource() == jbtOperadores[7]) {

        } else if (e.getSource() == jbtOperadores[8]) {

        } else if (e.getSource() == jbtOperadores[9]) {

        } else if (e.getSource() == jbtOperadores[10]) {

        } else if (e.getSource() == jbtOperadores[11]) {
            if (!Dato.getText().isEmpty() && punto == false) {
                punto = true;
                Dato.setText(Dato.getText() + ".");
            }
        } else if (e.getSource() == jbtOperadores[12]) {
            if (!Texto.getText().isEmpty() && igual == false) {
                Texto.setText(" = " + opb.getOp());
                opb.setOp(0);
                igual = true;
            }
        }
    }

    public void addBotonesNumericos() {
        jplBotones.setLocation(0, 100);
        jplBotones.add(jbtNumeros[0]);
        jplBotones.add(jbtNumeros[1]);
        jplBotones.add(jbtNumeros[2]);
        jplBotones.add(jbtNumeros[3]);
        jplBotones.add(jbtNumeros[4]);
        jplBotones.add(jbtNumeros[5]);
        jplBotones.add(jbtNumeros[6]);
        jplBotones.add(jbtNumeros[7]);
        jplBotones.add(jbtNumeros[8]);
        jplBotones.add(jbtNumeros[9]);
    }

    public void addOperadores() {
        jplBotones.add(jbtOperadores[0]);
        jplBotones.add(jbtOperadores[1]);
        jplBotones.add(jbtOperadores[2]);
        jplBotones.add(jbtOperadores[3]);
        jplBotones.add(jbtOperadores[4]);
        jplBotones.add(jbtOperadores[5]);
        jplBotones.add(jbtOperadores[6]);
        jplBotones.add(jbtOperadores[7]);
        jplBotones.add(jbtOperadores[11]);
        jplBotones.add(jbtOperadores[12]);
    }

    public void teclado_Operadores() {
        jbtOperadores[0] = new JButton("+");
        jbtOperadores[0].setBounds(240, 0, 70, 80);
        jbtOperadores[1] = new JButton("-");
        jbtOperadores[1].setBounds(240, 80, 70, 80);
        jbtOperadores[2] = new JButton("*");
        jbtOperadores[2].setBounds(240, 160, 70, 80);
        jbtOperadores[3] = new JButton("/");
        jbtOperadores[3].setBounds(240, 240, 70, 80);
        jbtOperadores[4] = new JButton("√");
        jbtOperadores[4].setBounds(310, 0, 70, 80);
        jbtOperadores[5] = new JButton("n^2");
        jbtOperadores[5].setBounds(310, 80, 70, 80);
        jbtOperadores[6] = new JButton("n^n");
        jbtOperadores[6].setBounds(310, 160, 70, 80);
        jbtOperadores[7] = new JButton("!");
        jbtOperadores[7].setBounds(310, 240, 70, 80);
        jbtOperadores[8] = new JButton("sen");
        jbtOperadores[8].setBounds(310, 0, 70, 80);
        jbtOperadores[9] = new JButton("con");
        jbtOperadores[9].setBounds(310, 80, 70, 80);
        jbtOperadores[10] = new JButton("tan");
        jbtOperadores[10].setBounds(310, 80, 70, 80);
        jbtOperadores[11] = new JButton(".");
        jbtOperadores[11].setBounds(0, 240, 80, 80);
        jbtOperadores[12] = new JButton("=");
        jbtOperadores[12].setBounds(160, 240, 80, 80);
        //
        jbtOperadores[0].addActionListener(this);
        jbtOperadores[1].addActionListener(this);
        jbtOperadores[2].addActionListener(this);
        jbtOperadores[3].addActionListener(this);
        jbtOperadores[4].addActionListener(this);
        jbtOperadores[5].addActionListener(this);
        jbtOperadores[6].addActionListener(this);
        jbtOperadores[7].addActionListener(this);
        jbtOperadores[8].addActionListener(this);
        jbtOperadores[9].addActionListener(this);
        jbtOperadores[10].addActionListener(this);
        jbtOperadores[11].addActionListener(this);
        jbtOperadores[12].addActionListener(this);

    }

    private void teclado_Numerico() {
        jbtNumeros[0] = new JButton("1");
        jbtNumeros[0].setBounds(0, 0, 80, 80);
        jbtNumeros[1] = new JButton("2");
        jbtNumeros[1].setBounds(80, 0, 80, 80);
        jbtNumeros[2] = new JButton("3");
        jbtNumeros[2].setBounds(160, 0, 80, 80);
        jbtNumeros[3] = new JButton("4");
        jbtNumeros[3].setBounds(0, 80, 80, 80);
        jbtNumeros[4] = new JButton("5");
        jbtNumeros[4].setBounds(80, 80, 80, 80);
        jbtNumeros[5] = new JButton("6");
        jbtNumeros[5].setBounds(160, 80, 80, 80);
        jbtNumeros[6] = new JButton("7");
        jbtNumeros[6].setBounds(0, 160, 80, 80);
        jbtNumeros[7] = new JButton("8");
        jbtNumeros[7].setBounds(80, 160, 80, 80);
        jbtNumeros[8] = new JButton("9");
        jbtNumeros[8].setBounds(160, 160, 80, 80);
        jbtNumeros[9] = new JButton("0");
        jbtNumeros[9].setBounds(80, 240, 80, 80);
        //
        jbtNumeros[0].addActionListener(this);
        jbtNumeros[1].addActionListener(this);
        jbtNumeros[2].addActionListener(this);
        jbtNumeros[3].addActionListener(this);
        jbtNumeros[4].addActionListener(this);
        jbtNumeros[5].addActionListener(this);
        jbtNumeros[6].addActionListener(this);
        jbtNumeros[7].addActionListener(this);
        jbtNumeros[8].addActionListener(this);
        jbtNumeros[9].addActionListener(this);
    }

}
