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
    private Deposito<Moneda> depMon;
    private Producto producto;
    private int valortotal = 0;

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
        if (this.depMon.isEmpty()) {
            throw new PagoIncorrectoException("No hay monedas");

        }

        if(this.valortotal >= seleccion.getPrecio()) {
           this.valortotal -= seleccion.getPrecio();
            switch (seleccion) {
                case COCACOLA:
                    b = this.coca.getElemento();
                    break;
                
                case SPRITE:
                    b = this.sprite.getElemento();
                    break;

                case FANTA:
                    b = this.fanta.getElemento();
                    break;

                case SNICKERS:
                    b = this.snickers.getElemento();
                    break;
                
                case SUPER8:
                    b = this.super8.getElemento();
                    break;

            }

        } else {
            throw new PagoInsuficienteException("Pago Insuficiente");

        }

        if(b == null) {
            throw new NoHayProductoException("No hay producto");

        }

        this.producto = b;

    }

    public int getValorTotal() {
        return this.valortotal;

    }

    /**Extrae una moneda de monVu
     * @return Una Moneda de monVu, o null si monVu esta vacio.
     */
    public Moneda getVuelto() {
        for (int i = 0; i < this.depMon.getSize(); i++) {
            Moneda m = this.depMon.verElemento(i);
            if (m.getValor() >= this.valortotal) {
                depMon.quitarElemento(i);
                for (int j = 0; j < this.valortotal / 100; j++) {
                    this.monVu.addElemento(new Moneda100());

                }


            } else {
                this.valortotal -= m.getValor();

            }

            
        }

        while (depMon.isEmpty() == false) {
            monVu.addElemento(depMon.getElemento());

        }

        this.valortotal = 0;

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
        this.valortotal += m.getValor();

    }

    public Deposito<Moneda> getDepMon() {
        return this.depMon;

    }

    public void rellenar() {
        boolean coca, sprite, fanta, snickers, super8;
        coca = this.coca.isEmpty();
        sprite = this.sprite.isEmpty();
        fanta = this.fanta.isEmpty();
        snickers = this.snickers.isEmpty();
        super8 = this.super8.isEmpty();

        for(int i = 0; i < 5; i++) {
            if(coca) {
                this.coca.addElemento(new CocaCola(i));

            }

            if(sprite) {
                this.sprite.addElemento(new Sprite(i));

            }

            if(fanta) {
                this.fanta.addElemento(new Fanta(i));

            }

            if(snickers) {
                this.snickers.addElemento(new Snickers(i));

            }

            if(super8) {
                this.super8.addElemento(new Super8(i));

            }

        }

    }
    public Deposito<Bebida> getCoca() {
        return coca;
    }

    public Deposito<Bebida> getSprite() {
        return sprite;
    }

    public Deposito<Bebida> getFanta() {
        return fanta;
    }

    public Deposito<Dulce> getSnickers() {
        return snickers;
    }

    public Deposito<Dulce> getSuper8() {
        return super8;
    }
}
