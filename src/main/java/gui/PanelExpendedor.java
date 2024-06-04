package main.java.gui;

import javax.swing.*;

import main.java.logic.*;

import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Expendedor exp;

    public PanelExpendedor(Expendedor exp){
        this.setBounds(0,0,600,800);
        this.setBackground(Color.black);
        this.setLayout(null);
        this.exp = exp;
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
}
