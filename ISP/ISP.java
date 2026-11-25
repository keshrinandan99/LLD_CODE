interface TwoDimensionalShape{
    double area();
}
interface ThreeDimensionalShape{
    double area();
    double volume();
}
 class Rectangle implements TwoDimensionalShape{
    private double length,breadth;
    public Rectangle(double length,double breath){
        this.length=length;
        this.breadth=breadth;
    }
    @Override 
    public double area(){
        return length*breadth;
    }
}
class Sqaure implements TwoDimensionalShape{
    private double side;
    public Sqaure(double s){
        this.side=s;
    }
    @Override 
    public double area(){
        return side*side;
    }
}
class Cube implements ThreeDimensionalShape{
    private double side;
    public Cube(double s){
        this.side=s;
    }
    @Override 
    public double area(){
        return 6*side*side;
    }
    @Override 
    public double volume(){
        return side*side*side;  
      }
}
public class ISP{
    public static void main(String[] args) {
        TwoDimensionalShape rectange=new Rectangle(10,20 );
        TwoDimensionalShape sqaure=new Sqaure(5);
        ThreeDimensionalShape cube=new Cube(5);
        System.out.println("Area of rectangle:"+rectange.area());
        System.out.println("Area of Square:"+sqaure.area());
        System.out.println("Area of Cube:"+cube.area());
        System.out.println("Volume of Cube:"+cube.volume());
    }
}