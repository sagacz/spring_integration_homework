abstract class Figure {
    double dim1;
    double dim2;

    Figure(double dim1, double dim2){
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract double area();
}

class Rectangle extends Figure{
    Rectangle(double dim1, double dim2){
        super(dim1, dim2);
    }

    double area(){
        return dim1 * dim2;
    }
}

class Triangle extends Figure{
    Triangle(double dim1, double dim2){
        super(dim1, dim2);
    }

    double area(){
    return dim1 * dim2 / 2;
    }
}

class AbstractAreas{
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 10);
        Triangle triangle = new Triangle(5, 10);

        Figure figure;

        figure = rect;
        System.out.println("Pole rect: " + figure.area());
        figure = triangle;
        System.out.println("Pole triangle: " + figure.area());
    }
}

