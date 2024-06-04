package main.java.logic;

/**Representa una maquina expendedora
 * @author Nícholas García
 */
public class Expendedor {
    private Deposito<Bebida> coca;
    public Deposito getCoca(){
        return coca; ////TODO getters depositos
    }

    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulce> snickers;
    private Deposito<Dulce> super8;
    private Deposito<Moneda> monVu;
    private Deposito<Moneda> depMon;
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
        depMon = new Deposito<Moneda>();

        for (int j = 0; j < i; j++) {
            coca.addElemento(new CocaCola(j));
            sprite.addElemento(new Sprite(j));
            fanta.addElemento(new Fanta(j));
            snickers.addElemento(new Snickers(j));
            super8.addElemento(new Super8(j));

        }
    }
    /**Intenta comprar el producto especificado con la moneda especificada, y añade 
     * monedas de 100 y las sobrantes del deposito de monedas equivalentes al 
     * vuelto a monVu.
     * @param seleccion Identificador del producto que se quiere comprar.
     * @param iter variable auxiliar para obtener elemento de indice iter
     * @param valortotal Valor total de las monedas dentro del deposito de monedas
     * @return Objeto producto que fue comprado.
     *
     * @throws PagoIncorrectoException Cuando la moneda == null.
     * @throws PagoInsuficienteException Cuando el valor de la moneda es menor al del producto a comprar.
     * @throws NoHayProductoException Cuando el deposito del producto a comprar esta vacio.
     */
    public void comprarProducto(ListProd seleccion) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        Producto b = null;
        if (depMon.isEmpty()) {
            throw new PagoIncorrectoException("No hay monedas");

        }

        int valortotal = 0;
        int iter = 0;
        while (depMon.isEmpty() == false) {
            valortotal += depMon.verElemento(iter).getValor();
            if(valortotal >= seleccion.getPrecio()) {
                break;

            }

            iter +=1;

        }

        if(valortotal >= seleccion.getPrecio()) {
            valortotal -= seleccion.getPrecio();
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

        for (int i = 0; i < depMon.getSize(); i++) {
            Moneda m = depMon.getElemento();
            if (m.getValor() >= valortotal) {
                for (int j = 0; j < (m.getValor() - valortotal) / 100; j++) {
                    monVu.addElemento(new Moneda100());

                }

                break;

            } else {
                valortotal -= m.getValor();

            }

            
        }

        while (depMon.isEmpty() == false) {
            monVu.addElemento(depMon.getElemento());

        }



        this.producto = b;

    }

    /**Extrae una moneda de monVu
     * @return Una Moneda de monVu, o null si monVu esta vacio.
     */
    public Moneda getVuelto() {
        if (monVu != null) {
            return monVu.getElemento();

        }

        return null;

    }

    /**
     * @return Retorna producto comprado
     */

    public Producto getProducto() {
        return this.producto;

    }

    /**
     * Funcion para añadir moneda a deposito de monedas
     * @param m Moneda a añadir
     */

    public void addMoneda(Moneda m) {
        this.depMon.addElemento(m);

    }
    
}
