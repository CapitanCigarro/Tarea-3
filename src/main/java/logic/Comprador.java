package main.java.logic;

/** Representa a un comprador que usa una cantidad de dinero para intentar comprar un producto del expendedor.
 * @author Benjamin Molina
 * @author Nícholas García
 */
public class Comprador {
    private String sonido = null;
    private int vuelto;
    private Producto b;
    private ListProd cualProducto;
    

    

    public Comprador() { }

    /**
     * Funcion para comprar producto seleccionado
     * @param exp Expendedor que se le comprara
     * @throws Exception Posibles exceptions que tire 
     */

    public void comprar(Expendedor exp) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        exp.comprarProducto(cualProducto);

    }

    public void setProducto(ListProd cualProducto) {
        this.cualProducto = cualProducto;

    }

    /**
     * Funcion que retira producto del expendedor una vez comprado
     * @param exp Expendedor del que se retira producto comprado
     */

    public void retirarProducto(Expendedor exp) {
        this.b = exp.getProducto();
        if(b != null) {
            this.sonido = this.b.consumir();

        }
        

    }

    /**
     * Funcion que te devuelve el vuelto y lo cuenta, objetos Moneda se iran eliminando,
     * despues de cada compra se reinicia el vuelto
     * @param exp Expendedor a retirar vuelto
     */

    public void retirarVuelto(Expendedor exp) {
        this.vuelto = 0;
        while (true) {
            Moneda m = exp.getVuelto();
            if (m == null){
                break;

            }

            this.vuelto += m.getValor();

        }

    }

    public int getVueltoTotal() {
        return this.vuelto;

    }

    public void setVuelto (int i) {
        this.vuelto = i;

    }

    /**
     * Funcion que devuelve cuanto vuelto tiene comprador
     * @return Vuelto
     */

    public int cuantoVuelto() {
        return vuelto;

    }

    public String queConsumiste() {
        return sonido;

    }

}