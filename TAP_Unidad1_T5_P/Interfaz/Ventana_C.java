package Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ventana_C extends JFrame {

    private JPanel panel;
    private Panel_1 vista;

    public Ventana_C() {
        ventana();
        initcomponents();
        Panel();
    }

    private void ventana() {
        setTitle("Calculadora");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initcomponents() {
        vista = new Panel_1();
    }

    private void Panel() {
        panel = new JPanel(null);
        panel.add(vista);
        setContentPane(panel);
    }

}
