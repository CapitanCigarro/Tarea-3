package main.java.logic;

/** Representa a un comprador que usa una cantidad de dinero para intentar comprar un producto del expendedor.
 * @author Benjamin Molina
 * @author Nícholas García
 */
public class Comprador {
    private String sonido = null;
    private int vuelto = 0;

    public Comprador(Moneda m, ListProd cualProducto, Expendedor exp) throws Exception {
        Producto b = exp.comprarProducto(m, cualProducto);
        
        if (b != null) {
            sonido = b.consumir();

        }
        
        while(true) {
            Moneda vu = exp.getVuelto();
            if (vu == null) {
                break;

            }

            vuelto += vu.getValor();

        }

    }

    public int cuantoVuelto() {
        return vuelto;

    }

    public String queConsumiste() {
        return sonido;

    }

}