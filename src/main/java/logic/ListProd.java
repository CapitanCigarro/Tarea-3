package main.java.logic;

/** Lista de productos
 * @author Nícholas García
 */
public enum ListProd {
    COCACOLA(300, "COCACOLA"),
    SPRITE(100, "SPRITE"), 
    FANTA(200, "FANTA"),  
    SNICKERS(300, "SNICKERS"), 
    SUPER8(200, "SUPER8");
    
    private final int precio;
    private final String sabor;

    ListProd(int precio, String sabor) {
        this.precio = precio;
        this.sabor = sabor;

    }

    public int getPrecio() {
        return precio;
    }

    public String getSabor() {
        return sabor;

    }

}


