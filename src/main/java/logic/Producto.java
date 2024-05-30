package main.java.logic;

/**Representa un producto generico.
 * @author Nícholas García
 * @author Benjamin Molina
*/
public abstract class Producto {
    private int serie;

    private int  x,y;

    /**Crea un producto con el numero de serie especificado.
     * @param serie Numero de serie de producto
    */
    public Producto(int serie) {
        this.serie = serie;

    }

    /** Obtiene el numero de serie del producto
     * @return un int que representa el numero de serie del producto
    */
    public int getSerie() {
        return serie;

    }

    public void setX(int num){
        this.x = num;
    }
    public void setY(int num){
        this.y = num;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    /** Obtiene el sabor del producto
     * @return String "Sabor" del producto para poder identificarlo
    */
    public abstract String consumir();


}