import javax.xml.crypto.Data;

interface Database{
    void save(String data);
}

class MySQL implements Database{
    @Override 
    public void save(String data){
        System.out.println("Data saved to MySQL"+data);
    }
}
class MongoDB implements Database{
    @Override 
    public void save(String data){
        System.out.println("Data saved to mongodb"+data);
    }
}
class UserService{
    private final  Database db;
    public UserService(Database database){
        this.db=database;
    } 
    public void storeUser(String user){
        
        db.save(user);
    }
}
public class DIP{
    public static void main(String[] args) {
        MySQL mysql= new MySQL();
        MongoDB mongodb = new MongoDB();
        UserService service1=new UserService(mysql);
        UserService service2=new UserService(mongodb);
        service1.storeUser("Nandan");
        service2.storeUser("Keshri");

    }
}