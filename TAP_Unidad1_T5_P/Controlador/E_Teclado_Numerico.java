package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Panel_1;
import javax.swing.JButton;

public class E_Teclado_Numerico implements ActionListener {

    private Panel_1 P;
    private JButton T[];
    private boolean punto;

    public E_Teclado_Numerico(Panel_1 P, JButton T[]) {
        punto = false;
        this.P = P;
        this.T = T;
        InciarBotones();
    }

    private void InciarBotones() {
        P.teclado_Numerico(T);
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String N = P.jtfNumero.getText();
        if (N.isEmpty()) {
            punto = false;
        }
        if (e.getSource() == T[0]) {
            P.jtfNumero.setText(N + "1");
        } else if (e.getSource() == T[1]) {
            P.jtfNumero.setText(N + "2");
        } else if (e.getSource() == T[2]) {
            P.jtfNumero.setText(N + "3");
        } else if (e.getSource() == T[3]) {
            P.jtfNumero.setText(N + "4");
        } else if (e.getSource() == T[4]) {
            P.jtfNumero.setText(N + "5");
        } else if (e.getSource() == T[5]) {
            P.jtfNumero.setText(N + "6");
        } else if (e.getSource() == T[6]) {
            P.jtfNumero.setText(N + "7");
        } else if (e.getSource() == T[7]) {
            P.jtfNumero.setText(N + "8");
        } else if (e.getSource() == T[8]) {
            P.jtfNumero.setText(N + "9");
        } else if (e.getSource() == T[9]) {
            P.jtfNumero.setText(N + "0");
        } else if (e.getSource() == T[10]) {
            if (!N.isEmpty() && punto == false) {
                P.jtfNumero.setText(N + ".");
                punto = true;
            }
        } else if (e.getSource() == T[11]) {
            E_Teclado_Operativo.Queue();
            P.jtaResultado.setText("");
            P.jtfNumero.setText("");
        }
    }

}
