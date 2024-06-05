package main.java.gui;

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
    private PanelExpendedor pexp;
    private Comprador comprador;
    private JLabel mensaje;
    private boolean condicion;


    /**
     * Metodo constructor de clase, inicializa todo
     * @param exp Expendedor que se usara para "comprar"
     * @param pexp Referencia a panel expendedor para actualizar este
     */

    public PanelComprador(Expendedor exp, PanelExpendedor pexp){
        this.comprador = new Comprador();
        this.exp = exp;
        this.pexp = pexp;
        this.setBackground(Color.blue);
        setLayout(null);

        this.setBounds(600,0,600,800);

        iniciarLista();
        iniciarBotonesMoneda();
        iniciarBotonesAccion();
        iniciarTextos();

        //TEMP TODO delete this
        // ActionListener del_listener = new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         exp.getCoca().getLista().removeLast();
        //         getParent().repaint();
        //     }
        // };
        // JButton del = new JButton();
        // del.setBounds(100,400,100,50);
        // del.setText("DEL");
        // del.addActionListener(del_listener);
        // this.add(del);
        
    }

    /**
     * Metodo que inicializa lista de eleccion de productos
     */

    public void iniciarLista() { 
        this.listaElecciones = new JComboBox<String>(this.elecciones);
        this.listaElecciones.setBounds(100, 186, 140, 20);
        this.add(this.listaElecciones);

    }

    /**
     * Metodo que inicializa botones para comprar, retirar vuelto y producto
     */

    public void iniciarBotonesAccion() {
        this.comprar = new JButton();
        this.retirarProducto = new JButton();
        this.retirarVuelto = new JButton();

        this.comprar.setText("Comprar");
        this.comprar.setBounds(100, 400, 200, 20);
        
        ActionListener comp = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    switch (listaElecciones.getSelectedIndex()) {
                        case 0:
                            comprador.setProducto(ListProd.COCACOLA);
                            break;
                        
                        case 1:
                            comprador.setProducto(ListProd.FANTA);
                            break;

                        case 2:
                            comprador.setProducto(ListProd.SPRITE);
                            break;

                        case 3:
                            comprador.setProducto(ListProd.SNICKERS);
                            break;
                        
                        case 4:
                            comprador.setProducto(ListProd.SUPER8);
                            break;
                    
                    }

                    comprador.comprar(exp);
                    pexp.actualizar();
                    pexp.cambiarMensaje("Compra exitosa");
                    mensaje.setText("Deberia retirar mi compra");
                    retirarProducto.setVisible(true);
                    retirarVuelto.setVisible(true);
                    comprar.setVisible(false);
                    condicion = false;
                    moneda100.setVisible(condicion);
                    moneda500.setVisible(condicion);
                    moneda1000.setVisible(condicion);

                } catch (NoHayProductoException e) {
                    mensaje.setText("Se agoto el producto");
                    pexp.cambiarMensaje("Producto agotado");
                } catch (PagoIncorrectoException e) {
                    mensaje.setText("No hay monedas");
                    pexp.cambiarMensaje("No hay monedas");

                } catch (PagoInsuficienteException e) {
                    mensaje.setText("Deberia añadir mas monedas");
                    pexp.cambiarMensaje("Pago insuficiente");

                }

            }

        };

        this.comprar.addActionListener(comp);

        ActionListener retVuel = new ActionListener() {
            @Override
            public  void  actionPerformed(ActionEvent ae) {
                comprador.retirarVuelto(exp);
                mensaje.setText("Vuelto obtenido = " + comprador.getVueltoTotal());
                pexp.cambiarMensaje("Vuelto = " + comprador.getVueltoTotal());
                pexp.actualizar();
                if(condicion) {
                    comprar.setVisible(true);
                    moneda100.setVisible(condicion);
                    moneda500.setVisible(condicion);
                    moneda1000.setVisible(condicion);
                } else {
                    condicion = true;

                }

                retirarVuelto.setVisible(false);

            }
        };

        this.retirarVuelto.setText("Retirar vuelto");
        this.retirarVuelto.setBounds(100, 460,  200, 20);
        this.retirarVuelto.addActionListener(retVuel);
        this.retirarVuelto.setVisible(false);

        this.retirarProducto.setVisible(false);
        this.retirarProducto.setText("Retirar producto"); // TODO posiblemente cambiar por una imagen del producto
        this.retirarProducto.setBounds(100, 520, 200, 20);

        ActionListener retProd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                comprador.retirarProducto(exp);
                mensaje.setText("Obtuviste " + comprador.queConsumiste());
                pexp.cambiarMensaje("Producto retirado");

                retirarProducto.setVisible(false);

                if(condicion) {
                    comprar.setVisible(true);
                    moneda100.setVisible(condicion);
                    moneda500.setVisible(condicion);
                    moneda1000.setVisible(condicion);

                } else {
                    condicion = true;

                }

            }

        };

        this.retirarProducto.addActionListener(retProd);

        this.add(comprar);
        this.add(retirarProducto);
        this.add(retirarVuelto);

    }

    /**
     * Metodo para añadir monedas a expendedor
     * @param m Moneda a ser añadida
     */

    public void addMoneda(Moneda m) {
        this.exp.addMoneda(m);

    }

    /**
     * Metodo para inicializar barra de texto
     */

    public void iniciarTextos() {
        this.mensaje = new JLabel("Compra un producto");
        this.mensaje.setBounds(200, 600, 200, 20);
        this.mensaje.setBackground(Color.black);
        this.mensaje.setForeground(Color.white);
        this.add(mensaje);

    }

    /**
     * Metodo que inicializa botones para añadir monedas
     */

    public void  iniciarBotonesMoneda() {
        this.moneda100 = new JButton();
        this.moneda500 = new JButton();
        this.moneda1000 = new JButton();

        this.moneda100.setText("Moneda 100");
        this.moneda100.setBackground(Color.GREEN);
        this.moneda500.setText("Moneda 500");
        this.moneda500.setBackground(Color.MAGENTA);
        this.moneda1000.setText("Moneda 1000");
        this.moneda1000.setBackground(Color.CYAN);

        this.moneda100.setBounds(450, 100, 130, 30);
        this.moneda500.setBounds(450, 180, 130, 30);
        this.moneda1000.setBounds(450, 260, 130, 30);

        ActionListener m100 = new ActionListener() {
            @Override 

            public  void  actionPerformed(ActionEvent ae) {
                addMoneda(new Moneda100());
                pexp.actualizar();


            }

        };

        ActionListener m500 = new ActionListener() {
            @Override 

            public  void  actionPerformed(ActionEvent ae) {
                addMoneda(new Moneda500());
                pexp.actualizar();

            }

        };

        ActionListener m1000 = new ActionListener() {
            @Override 

            public  void  actionPerformed(ActionEvent ae) {
                addMoneda(new Moneda1000());
                pexp.actualizar();

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

