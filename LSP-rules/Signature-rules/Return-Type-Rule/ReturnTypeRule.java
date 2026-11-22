class Animal{

}
class Dog extends Animal{

}
class Parent{
    public Animal getAnimal(){
        System.out.println("Parent:Running parent instance");
        return new Animal();
    }
}
class Child extends Parent{
    public Dog getAnimal(){
        System.out.println("Child: Running child instance");
        return new Dog();
    }
}

class Client{
    private Parent p;
    public Client(Parent p){
        this.p=p;
    }
    public void takeAnimal(){
        p.getAnimal();
    }
}
public class ReturnTypeRule{
    public static void main(String[] args) {
        Parent parent=new Parent();
        Child child=new Child();
        Client client=new Client(child);
        client.takeAnimal();
    }
}