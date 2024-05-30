package main.java.logic;

/**Representa una maquina expendedora
 * @author Nícholas García
 */
public class Expendedor {
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulce> snickers;
    private Deposito<Dulce> super8;
    private Deposito<Moneda> monVu;
    private Producto producto;

    /**Crea un expendedor con i productos de cada tipo.
     * @param i Numero de productos de cada tipo que contendra el expendedor.
     */
    public Expendedor(int i) {
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        fanta = new Deposito<Bebida>();
        snickers = new Deposito<Dulce>();
        super8 = new Deposito<Dulce>();
        monVu = new Deposito<Moneda>();

        for (int j = 0; j < i; j++) {
            coca.addElemento(new CocaCola(j));
            sprite.addElemento(new Sprite(j));
            fanta.addElemento(new Fanta(j));
            snickers.addElemento(new Snickers(j));
            super8.addElemento(new Super8(j));

        }
    }
    /**Intenta comprar el producto especificado con la moneda especificada, y añade monedas de 100 equivalentes al vuelto a monVu.
     *
     * @param m Moneda con la que se va a intentar comprar.
     * @param seleccion Identificador del producto que se quiere comprar.
     * @return Objeto producto que fue comprado.
     *
     * @throws PagoIncorrectoException Cuando la moneda == null.
     * @throws PagoInsuficienteException Cuando el valor de la moneda es menor al del producto a comprar.
     * @throws NoHayProductoException Cuando el deposito del producto a comprar esta vacio.
     */
    public void comprarProducto(Moneda m, ListProd seleccion) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Producto b = null;
        if (m == null) {
            throw new PagoIncorrectoException("Moneda null");

        }

        int iterations = m.getValor() / 100; //Cantidad maxima de monedas de 100 para dar de vuelto.

        if(m.getValor() >= seleccion.getPrecio()) {
            switch (seleccion) {
                case COCACOLA:
                    b = coca.getElemento();
                    break;
                
                case SPRITE:
                    b = sprite.getElemento();
                    break;

                case FANTA:
                    b = fanta.getElemento();
                    break;

                case SNICKERS:
                    b = snickers.getElemento();
                    break;
                
                case SUPER8:
                    b = super8.getElemento();
                    break;

            }

        } else {
            throw new PagoInsuficienteException("Pago Insuficiente");

        }

        if(b == null) {
            throw new NoHayProductoException("No hay producto");

        }

        if (b != null) {
            iterations -= seleccion.getPrecio() / 100;

        }

        for (int j = 0; j < iterations; j++) {
            monVu.addElemento(new Moneda100());

        }


        this.producto = b;

    }

    /**Extrae una moneda de monVu
     * @return Una Moneda100 de monVu, o null si monVu esta vacio.
     */
    public Moneda getVuelto() {
        if (monVu != null) {
            return monVu.getElemento();

        }

        return null;

    }

    public Producto getProducto() {
        return this.producto;

    }
    
}
