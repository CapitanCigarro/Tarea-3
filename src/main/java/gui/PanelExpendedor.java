package main.java.gui;

import javax.swing.*;

import main.java.logic.*;

import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Expendedor exp;
    private JLabel dinero;
    private JLabel mensaje;
    private JButton expendedor;

    public PanelExpendedor(Expendedor exp){
        this.setBounds(0,0,600,800);
        this.setBackground(Color.black);
        this.setLayout(null);
        this.exp = exp;
        setLayout(null);
        iniciarTextos();
        iniciarBotones();
        this.add(new PanelDeposito(exp.getCoca())); ///TODO

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
    
    /**
     * Funcion para añadir moneda al expendedor
     * @param m Moneda a añadir
     */
    public void añadirMoneda(Moneda m) {
        this.exp.addMoneda(m);

    }

    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(mgr);
        

    }

    public void iniciarTextos() {
        this.mensaje = new JLabel();
        this.mensaje.setText("Elegir producto, añadir monedas y comprar");
        this.mensaje.setBounds(100, 700, 300, 15);
        this.mensaje.setForeground(Color.WHITE);
        this.dinero = new JLabel();
        this.dinero.setText("Dinero = 0");
        this.dinero.setForeground(Color.WHITE);
        this.dinero.setBounds(100, 0, 100, 100);
        this.add(dinero);
        this.add(mensaje);

    }

    /**
     * Cambia el mensaje que muestra el texto
     * @param s Mensaje a mostrar
     */

    public void cambiarMensaje(String s) {
        this.mensaje.setText(s);

    }

    public void iniciarBotones() {
        ImageIcon imagen = new  ImageIcon("Expendedor.png");        
        this.expendedor = new JButton(); 
        this.expendedor.setBounds(200, 100, 300, 500);
        this.expendedor.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(expendedor.getWidth(), expendedor.getHeight(), Image.SCALE_SMOOTH)));
        this.expendedor.setBackground(Color.DARK_GRAY);
        this.add(this.expendedor);

    }

    /**
     * Actualiza visuales
     */

    public void actualizar() {
        this.dinero.setText("Dinero = " + exp.getValorTotal());

    }

    public void comprarProducto(int i) {}
        

    public void getVuelto() {


    }

}
