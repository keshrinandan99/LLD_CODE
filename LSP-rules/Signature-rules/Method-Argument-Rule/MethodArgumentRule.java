class Parent{
    public void printMessage(String msg){
        System.out.println("Message from parent:"+msg);
    }
}
class Child extends Parent{
    @Override 
    public void printMessage(String msg){
        System.out.println("Message from child:"+msg);
    }
}
class Client{
    private Parent p;
    public Client(Parent p){
        this.p=p;
    }
    public void printMsg(){
        p.printMessage("Hello");
    }   
}
class MethodArgumentRule{
    public static void main(String[] args) {
        Parent p=new Parent();
        Parent c=new Child();
        Client client=new Client(p);
        client.printMsg();
        Client cl=new Client(c);
        cl.printMsg();
    }
}