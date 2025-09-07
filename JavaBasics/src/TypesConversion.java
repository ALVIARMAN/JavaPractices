class MyConvertion{
    int num1=12;
    double num2=15.5;
    float num3=3.3f;
    String num4="5";
    void display(){
        //convert double --> int
        Integer numberInt = (int) num2; //explicit casting
        System.out.println(numberInt);
        // convert int --> double
        double numberDouble= (double) num1; //explicit casting
        System.out.println(numberDouble);
        //convert int/double/float --> String
        String numberString = String.valueOf(num3);
        System.out.println(numberString);

    }
}

public class TypesConversion {
    public static void main(String[] args) {
        MyConvertion myConvertion = new MyConvertion();
        myConvertion.display();
    }
}
