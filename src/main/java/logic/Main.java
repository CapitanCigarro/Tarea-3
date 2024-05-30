package main.java.logic;

public class Main {
    public static void main(String[] args) {
        Bebida b = new CocaCola(1);
        Expendedor exp = new Expendedor(2);
        Moneda m = null;
        Comprador c = null;
        for (int i = 0; i < 3; i++) {
            try {                
                switch (i) {
                    case 0:
                    c = new Comprador(m,ListProd.COCACOLA,exp);
                    System.out.println(c.cuantoVuelto() + c.queConsumiste());
                        
                        break;
                    
                    case 1:
                        m = new Moneda100();
                        c = new Comprador(m, ListProd.SNICKERS, exp);
                        System.out.println(c.cuantoVuelto() + c.queConsumiste());
                        break;
                        
                    default:
                        m = new Moneda1000();
                        c = new Comprador(m, ListProd.SNICKERS, exp);
                        System.out.println(c.cuantoVuelto() + c.queConsumiste());
                        c = new Comprador(m, ListProd.SNICKERS, exp);
                        System.out.println(c.cuantoVuelto() + c.queConsumiste());
                        c = new Comprador(m, ListProd.SUPER8, exp);
                        System.out.println(c.cuantoVuelto() + c.queConsumiste());
                        c = new Comprador(m, ListProd.SNICKERS, exp);
                        System.out.println(c.cuantoVuelto() + c.queConsumiste());
                        break;

                }
            

            } catch (Exception e) {
                System.out.println(e);
    
            } 


        }
    }
}
