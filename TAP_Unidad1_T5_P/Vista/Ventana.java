package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ventana extends JFrame {

    private int Ancho, Alto;
    private JPanel panel;
    //Panels
    private Panel_1 vista;

    public Ventana() {
        this.Ancho = 355;
        this.Alto = 500;
        ventana();
        initcomponents();
        Panel();
    }

    private void ventana() {
        setTitle("Calculadora");
        setSize(Ancho, Alto);
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
