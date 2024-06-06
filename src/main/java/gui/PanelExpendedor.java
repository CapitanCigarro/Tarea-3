package main.java.gui;

import javax.swing.*;

import main.java.logic.*;

import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Expendedor exp;
    private JLabel dinero;
    private JLabel mensaje;

    private PanelDeposito panelCoca;
    private PanelDeposito panelFanta;
    private PanelDeposito panelSprite;
    private PanelDeposito panelSnickers;
    private PanelDeposito panelSuper8;
    private PanelDeposito panelMonedas;

    public PanelExpendedor(Expendedor exp){
        this.setBounds(0,0,600,800);
        this.setBackground(Color.black);
        this.setLayout(null);
        this.exp = exp;
        setLayout(null);
        iniciarTextos();
        iniciarPaneles(); ///TODO

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
        this.actualizar();

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
        this.dinero.setForeground(Color.white);
        this.dinero.setBounds(100, 400, 100, 100);
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

    /**
     * Actualiza visuales
     */

    public void actualizar() {
        this.dinero.setText("Dinero = " + exp.getValorTotal());
        this.panelCoca.reajustLabesl();
        this.panelFanta.reajustLabesl();
        this.panelSnickers.reajustLabesl();
        this.panelSprite.reajustLabesl();
        this.panelSuper8.reajustLabesl();
        this.panelMonedas.reajustLabesl();

    }

    public void iniciarPaneles(){
        panelCoca = new PanelDeposito(exp.getCoca(),"src\\main\\resources\\CocaCola1.png");
        panelCoca.setBounds(50,20,500,60);

        panelSprite = new PanelDeposito(exp.getSprite(),"src\\main\\resources\\Sprite1.png");
        panelSprite.setBounds(50,80,500,60);

        panelFanta = new PanelDeposito(exp.getFanta(),"src\\main\\resources\\Fanta1.png");
        panelFanta.setBounds(50,140,500,60);

        panelSnickers = new PanelDeposito(exp.getSnickers(),"src\\main\\resources\\Snickers1.png");
        panelSnickers.setBounds(50,200,500,60);

        panelSuper8 = new PanelDeposito(exp.getSuper8(),"src\\main\\resources\\Super81.png");
        panelSuper8.setBounds(50,260,500,60);

        panelMonedas = new PanelDepositoMonedas(exp.getDepMon(),"src\\main\\resources\\");
        panelMonedas.setBounds(50, 320, 500, 60);

        this.add(panelCoca);
        this.add(panelSprite);
        this.add(panelFanta);
        this.add(panelSnickers);
        this.add(panelSuper8);
        this.add(panelMonedas);

    }



    public void rellenar() {
        if(exp.rellenar()) {
            this.mensaje.setText("Depositos vacios rellenados");
            this.actualizar();

        }


    }
        
}
