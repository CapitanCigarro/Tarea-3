package main.java.logic;

/** Lista de productos
 * @author Nícholas García
 */
public enum ListProd {
    COCACOLA(300),
    SPRITE(100), 
    FANTA(200),  
    SNICKERS(300), 
    SUPER8(200);
    
    private final int precio;

    ListProd(int precio) {
        this.precio = precio;

    }

    public int getPrecio() {
        return precio;
    }

}


