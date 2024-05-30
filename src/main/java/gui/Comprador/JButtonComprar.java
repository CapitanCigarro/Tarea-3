package main.java.gui.Comprador;

import javax.swing.JButton;

import main.java.logic.Comprador;
import main.java.logic.Expendedor;

public class JButtonComprar extends JButton{
    private Expendedor exp;
    private Comprador com;

    public JButtonComprar (Expendedor exp, Comprador com) {
        super();
        this.exp = exp;
        this.com = com;
        
    }



}
