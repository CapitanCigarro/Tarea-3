package main.java.gui.Comprador;

import main.java.logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel {
    //Comprador comprador = new Comprador()
    private JComboBox<String> listaElecciones;
    private String[] elecciones  = {ListProd.COCACOLA.getSabor() + " : " + String.valueOf(ListProd.COCACOLA.getPrecio()),
                                    ListProd.FANTA.getSabor() + " : " + String.valueOf(ListProd.FANTA.getPrecio()),
                                    ListProd.SPRITE.getSabor() + " : " + String.valueOf(ListProd.SPRITE.getPrecio()),
                                    ListProd.SNICKERS.getSabor() + " : " + String.valueOf(ListProd.SNICKERS.getPrecio()),
                                    ListProd.SUPER8.getSabor() + " : " + String.valueOf(ListProd.SUPER8.getPrecio())
    };
    private JButton moneda100, moneda500, moneda1000;
    private JButton comprar, retirarProducto, retirarVuelto;
    private Expendedor exp;


    public PanelComprador(Expendedor exp){
        this.exp = exp;
        this.setBackground(Color.blue);

        this.setBounds(600,0,600,800);

        iniciarLista();
        iniciarBotonesMoneda();
        iniciarBotonesAccion();

        //TEMP
        ActionListener del_listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exp.getCoca().getLista().removeLast();
                getParent().repaint();
            }
        };
        JButton del = new JButton();
        del.setBounds(100,400,50,50);
        del.setText("DEL");
        del.addActionListener(del_listener);
        this.add(del);
    }

    public void iniciarLista() { 
        this.listaElecciones = new JComboBox<String>(this.elecciones);
        this.listaElecciones.setBounds(0, 0, 100, 100); // TODO
        this.add(this.listaElecciones);

    }

    public void iniciarBotonesAccion() {
        this.comprar = new JButton();
        this.retirarProducto = new JButton();
        this.retirarVuelto = new JButton();

        this.comprar.setText("Comprar");
        this.retirarProducto.setText("Retirar Producto");
        this.retirarVuelto.setText("Retirar vuelto");



    }

    public void addMoneda(Moneda m) {
        this.exp.addMoneda(m);

    }

    public void iniciarTextos() {
        

    }

    public void  iniciarBotonesMoneda() {
        this.moneda100 = new JButton();
        this.moneda500 = new JButton();
        this.moneda1000 = new JButton();

        this.moneda100.setText("Moneda 100");
        this.moneda500.setText("Moneda 500");
        this.moneda1000.setText("Moneda 1000");

        this.moneda100.setBounds(100, 100, 50, 50);
        this.moneda500.setBounds(100, 200, 50, 50);
        this.moneda1000.setBounds(100, 300, 50, 50);

        ActionListener m100 = new ActionListener() {
            @Override 

            public  void  actionPerformed(ActionEvent ae) {
                addMoneda(new Moneda100());


            }

        };

        ActionListener m500 = new ActionListener() {
            @Override 

            public  void  actionPerformed(ActionEvent ae) {
                addMoneda(new Moneda500());

            }

        };

        ActionListener m1000 = new ActionListener() {
            @Override 

            public  void  actionPerformed(ActionEvent ae) {
                addMoneda(new Moneda1000());

            }

        };

        this.moneda100.addActionListener(m100);
        this.moneda500.addActionListener(m500);
        this.moneda1000.addActionListener(m1000);

        this.add(this.moneda100);
        this.add(this.moneda500);
        this.add(this.moneda1000);


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
}

