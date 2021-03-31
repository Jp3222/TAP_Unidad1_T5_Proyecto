package Vista;

import Controlador.E_Teclado_Numerico;
import Controlador.E_Teclado_Operativo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Panel_1 extends JPanel {

    //Ventana
    //Altura
    private int Ancho, Alto;
    //
    public JTextField jtfNumero;
    public JTextArea jtaResultado;
    //Contenedores
    private JPanel jplPantalla, jplBotones;
    //Botones
    private JButton[] jbtOperadores;
    private JButton[] jbtNumeros;
    //Controladores
    private E_Teclado_Numerico EDT;
    private E_Teclado_Operativo EDO;

    //Contructor
    public Panel_1() {
        this.Ancho = 350;
        this.Alto = 500;
        setLayout(null);
        setSize(Ancho, Alto);
        setBackground(Color.black);
        //
        initcomponents();
        Pantalla();
        Teclado();
    }

    //Metodo que inicia todos los componentes
    private void initcomponents() {
        Font F = new Font("Tw Cen MT", 0, 15);
        Border B = new BevelBorder(1, Color.CYAN, Color.BLACK);
        //Componentes de Texto
        jtaResultado = new JTextArea("");
        jtaResultado.setBounds(6, 5, getSize().width - 26, 40);
        jtaResultado.setEditable(false);
        jtaResultado.setBackground(new Color(7, 22, 133));
        jtaResultado.setForeground(new Color(0, 255, 151));
        jtaResultado.setFont(F);
        jtaResultado.setBorder(B);
        //
        jtfNumero = new JTextField("");
        jtfNumero.setBounds(6, 55, getSize().width - 26, 40);
        jtfNumero.setEditable(false);
        jtfNumero.setBackground(new Color(7, 22, 133));
        jtfNumero.setForeground(new Color(0, 255, 151));
        jtfNumero.setFont(F);
        jtfNumero.setBorder(B);

        //Botones
        jbtOperadores = new JButton[13];
        jbtNumeros = new JButton[12];
        teclado_Numerico(jbtNumeros);
        teclado_Operadores(jbtOperadores);
        //
        //Controladores
        EDT = new E_Teclado_Numerico(this, jbtNumeros);
        EDO = new E_Teclado_Operativo(this, jbtOperadores);

    }

    //Metodo encargado de la vista de la pantalla
    private void Pantalla() {
        jplPantalla = new JPanel(null);
        jplPantalla = new JPanel(null);
        jplPantalla.setBackground(new Color(7, 22, 133));
        jplPantalla.setSize(400, 100);
        jplPantalla.setLocation(0, 0);
        jplPantalla.add(jtaResultado);
        jplPantalla.add(jtfNumero);
        this.add(jplPantalla);
    }

    //Metodo encargado de la vista del teclado
    private void Teclado() {
        jplBotones = new JPanel(null);
        jplBotones.setBackground(new Color(2, 14, 95));
        jplBotones.setSize(400, this.getMaximumSize().height - 100);
        addTecladoNumerico();
        addOperadores();
        this.add(jplBotones);
    }
//<------------------Añadiendo Botones----------------->//

    public void addTecladoNumerico() {
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
        jplBotones.add(jbtNumeros[10]);
        jplBotones.add(jbtNumeros[11]);
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
        jplBotones.add(jbtOperadores[8]);
        jplBotones.add(jbtOperadores[9]);
        jplBotones.add(jbtOperadores[10]);
        jplBotones.add(jbtOperadores[11]);
        jplBotones.add(jbtOperadores[12]);
    }
//<------------------Iniciando Botones----------------->//

    /*
    
    Iniciando el teclado de operadores
    xS = xA + ancho + espacio
    yS = yA + alto + espacio
    
     */
    public void teclado_Operadores(JButton jbtOperadores[]) {
        //Size
        int btnAncho = 50, btnAlto = 50;
        //Posicion
        int btnX = 170, btnY = 10;
        //
        int espX = 5;
        int espY = 20;
        //propiedades
        Border B = new BevelBorder(1, Color.CYAN, Color.BLACK);
        Font F = new Font("Tw Cen MT", 0, 12);
        Color CF = new Color(0, 255, 151);
        Color CB = new Color(7, 22, 133);
        //Botones
        jbtOperadores[0] = new JButton("+");
        jbtOperadores[0].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[0].setFont(F);
        jbtOperadores[0].setBackground(CB);
        jbtOperadores[0].setForeground(CF);
        jbtOperadores[0].setBorder(B);
        jbtOperadores[0].setBorderPainted(true);
        btnY += btnAlto + espY;
        jbtOperadores[1] = new JButton("-");
        jbtOperadores[1].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[1].setFont(F);
        jbtOperadores[1].setBackground(CB);
        jbtOperadores[1].setForeground(CF);
        jbtOperadores[1].setBorder(B);
        jbtOperadores[1].setBorderPainted(true);
        btnY += btnAlto + espY;
        jbtOperadores[2] = new JButton("*");
        jbtOperadores[2].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[2].setFont(F);
        jbtOperadores[2].setBackground(CB);
        jbtOperadores[2].setForeground(CF);
        jbtOperadores[2].setBorder(B);
        jbtOperadores[2].setBorderPainted(true);
        btnY += btnAlto + espY;
        jbtOperadores[3] = new JButton("/");
        jbtOperadores[3].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[3].setFont(F);
        jbtOperadores[3].setBackground(CB);
        jbtOperadores[3].setForeground(CF);
        jbtOperadores[3].setBorder(B);
        jbtOperadores[3].setBorderPainted(true);
        //
        btnY = 10;
        btnX += btnAncho + espX;
        jbtOperadores[4] = new JButton("√");
        jbtOperadores[4].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[4].setFont(F);
        jbtOperadores[4].setBackground(CB);
        jbtOperadores[4].setForeground(CF);
        jbtOperadores[4].setBorder(B);
        jbtOperadores[4].setBorderPainted(true);
        btnY += btnAlto + espY;
        jbtOperadores[5] = new JButton("^2");
        jbtOperadores[5].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[5].setFont(F);
        jbtOperadores[5].setBackground(CB);
        jbtOperadores[5].setForeground(CF);
        jbtOperadores[5].setBorder(B);
        jbtOperadores[5].setBorderPainted(true);
        btnY += btnAlto + espY;
        jbtOperadores[6] = new JButton("^n");
        jbtOperadores[6].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[6].setFont(F);
        jbtOperadores[6].setBackground(CB);
        jbtOperadores[6].setForeground(CF);
        jbtOperadores[6].setBorder(B);
        jbtOperadores[6].setBorderPainted(true);
        btnY += btnAlto + espY;
        jbtOperadores[7] = new JButton("!");
        jbtOperadores[7].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[7].setFont(F);
        jbtOperadores[7].setBackground(CB);
        jbtOperadores[7].setForeground(CF);
        jbtOperadores[7].setBorder(B);
        jbtOperadores[7].setBorderPainted(true);
        //
        btnY = 10;
        btnX += btnAncho + espX;
        jbtOperadores[8] = new JButton("sen");
        jbtOperadores[8].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[8].setFont(F);
        jbtOperadores[8].setBackground(CB);
        jbtOperadores[8].setForeground(CF);
        jbtOperadores[8].setBorder(B);
        jbtOperadores[8].setBorderPainted(true);
        btnY += btnAlto + espY;
        jbtOperadores[9] = new JButton("cos");
        jbtOperadores[9].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[9].setFont(F);
        jbtOperadores[9].setBackground(CB);
        jbtOperadores[9].setForeground(CF);
        jbtOperadores[9].setBorder(B);
        jbtOperadores[9].setBorderPainted(true);
        //
        btnY += btnAlto + espY;
        jbtOperadores[10] = new JButton("tan");
        jbtOperadores[10].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[10].setFont(F);
        jbtOperadores[10].setBackground(CB);
        jbtOperadores[10].setForeground(CF);
        jbtOperadores[10].setBorder(B);
        jbtOperadores[10].setBorderPainted(true);
        //
        btnY += btnAlto + espY;
        jbtOperadores[11] = new JButton("<-");
        jbtOperadores[11].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtOperadores[11].setFont(F);
        jbtOperadores[11].setBackground(CB);
        jbtOperadores[11].setForeground(CF);
        jbtOperadores[11].setBorder(B);
        jbtOperadores[11].setBorderPainted(true);
        //
        btnY += btnAlto + espY;
        btnX = 5;
        jbtOperadores[12] = new JButton("=");
        jbtOperadores[12].setBounds(btnX, btnY, btnAncho + 275, btnAlto);
        jbtOperadores[12].setFont(F);
        jbtOperadores[12].setBackground(CB);
        jbtOperadores[12].setForeground(CF);
        jbtOperadores[12].setBorder(B);
        jbtOperadores[12].setBorderPainted(true);
    }

    /*
   Iniciando_Teclado_Numerico
     */
    public void teclado_Numerico(JButton jbtNumeros[]) {
        //Size
        int btnAncho = 50, btnAlto = 50;
        //Posicion
        int btnX = 5, btnY = 10;
        //
        int espX = 5;
        int espY = 20;
        //propiedades
        Font F = new Font("Tw Cen MT", 1, 14);
        Color CF = new Color(0, 255, 151);
        Color CB = new Color(7, 22, 133);
        //Botones
        jbtNumeros[0] = new JButton("1");
        jbtNumeros[0].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[0].setBackground(CB);
        jbtNumeros[0].setForeground(CF);
        jbtNumeros[0].setFont(F);
        jbtNumeros[0].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[0].setBorderPainted(true);
        btnX += btnAncho + espX;
        jbtNumeros[1] = new JButton("2");
        jbtNumeros[1].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[1].setBackground(CB);
        jbtNumeros[1].setForeground(CF);
        jbtNumeros[1].setFont(F);
        jbtNumeros[1].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[1].setBorderPainted(true);
        btnX += btnAncho + espX;
        jbtNumeros[2] = new JButton("3");
        jbtNumeros[2].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[2].setBackground(CB);
        jbtNumeros[2].setForeground(CF);
        jbtNumeros[2].setFont(F);
        jbtNumeros[2].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[2].setBorderPainted(true);
        //
        btnX = 5;
        btnY += btnAlto + espY;
        jbtNumeros[3] = new JButton("4");
        jbtNumeros[3].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[3].setBackground(CB);
        jbtNumeros[3].setForeground(CF);
        jbtNumeros[3].setFont(F);
        jbtNumeros[3].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[3].setBorderPainted(true);
        btnX += btnAncho + espX;
        jbtNumeros[4] = new JButton("5");
        jbtNumeros[4].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[4].setBackground(CB);
        jbtNumeros[4].setForeground(CF);
        jbtNumeros[4].setFont(F);
        jbtNumeros[4].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[4].setBorderPainted(true);
        btnX += btnAncho + espX;
        jbtNumeros[5] = new JButton("6");
        jbtNumeros[5].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[5].setBackground(CB);
        jbtNumeros[5].setForeground(CF);
        jbtNumeros[5].setFont(F);
        jbtNumeros[5].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[5].setBorderPainted(true);
        //
        btnX = 5;
        btnY += btnAlto + espY;
        jbtNumeros[6] = new JButton("7");
        jbtNumeros[6].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[6].setBackground(CB);
        jbtNumeros[6].setForeground(CF);
        jbtNumeros[6].setFont(F);
        jbtNumeros[6].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[6].setBorderPainted(true);
        btnX += btnAncho + espX;
        jbtNumeros[7] = new JButton("8");
        jbtNumeros[7].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[7].setBackground(CB);
        jbtNumeros[7].setForeground(CF);
        jbtNumeros[7].setFont(F);
        jbtNumeros[7].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[7].setBorderPainted(true);
        btnX += btnAncho + espX;
        jbtNumeros[8] = new JButton("9");
        jbtNumeros[8].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[8].setBackground(CB);
        jbtNumeros[8].setForeground(CF);
        jbtNumeros[8].setFont(F);
        jbtNumeros[8].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[8].setBorderPainted(true);
        //
        btnX = 5;
        btnY += btnAlto + espY;
        jbtNumeros[9] = new JButton("0");
        jbtNumeros[9].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[9].setBackground(CB);
        jbtNumeros[9].setForeground(CF);
        jbtNumeros[9].setFont(F);
        jbtNumeros[9].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[9].setBorderPainted(true);
        btnX += btnAncho + espX;
        jbtNumeros[10] = new JButton(".");
        jbtNumeros[10].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[10].setBackground(CB);
        jbtNumeros[10].setForeground(CF);
        jbtNumeros[10].setFont(F);
        jbtNumeros[10].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[10].setBorderPainted(true);
        btnX += btnAncho + espX;
        jbtNumeros[11] = new JButton("C");
        jbtNumeros[11].setBounds(btnX, btnY, btnAncho, btnAlto);
        jbtNumeros[11].setBackground(CB);
        jbtNumeros[11].setForeground(CF);
        jbtNumeros[11].setFont(F);
        jbtNumeros[11].setBorder(new BevelBorder(1, Color.CYAN, Color.BLACK));
        jbtNumeros[11].setBorderPainted(true);
    }
}
