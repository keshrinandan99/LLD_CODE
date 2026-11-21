import java.util.ArrayList;
import java.util.List;

class Product{
    String name;
    double price;

    public Product(String name,double price){
        this.name=name;
        this.price=price;
    }
}
class ShoppingCart{
    private List <Product>products=new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }
    public List<Product> getProducts(){
        return products;
    }
    public double calculateTotal(){
        double total=0;
        for(Product p:products){
            total+=p.price;
        }
        return total;
    }

}

class ShoppingCartPrinter{
    private ShoppingCart cart;
    public ShoppingCartPrinter(ShoppingCart cart){
        this.cart=cart;
    }
    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

interface Persistance{
    void save(ShoppingCart cart);
}
class MongoPersistance implements  Persistance{
    public void save(ShoppingCart cart){
        System.out.println("Saving to Mongodb...");
    }
}
class SqlPersistance implements  Persistance{
    public void save(ShoppingCart cart){
        System.out.println("Saving to SQL...");
    }
}
class FilePersistance implements Persistance{
    public void save(ShoppingCart cart){
        System.out.println("Saving to file ... ");
    }
}

/**
 * OCP
 */
public class OCP {

    public static void main(String[] args) {
        ShoppingCart cart=new ShoppingCart();
        cart.addProduct(new Product("laptop",150000));
        cart.addProduct(new Product("mobile",15000));
        ShoppingCartPrinter printer=new ShoppingCartPrinter(cart);
        printer.printInvoice();
        Persistance db=new SqlPersistance();
        Persistance mongo=new MongoPersistance();
        Persistance file=new FilePersistance();
        db.save(cart);
        mongo.save(cart);
        file.save(cart);

    }
}
