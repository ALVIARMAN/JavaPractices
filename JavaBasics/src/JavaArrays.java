import java.util.Arrays;

class MyArrays {
    int[] oneDimension = {12, 11, 15};
    int[][] twoDimension = {{13, 14, 15}, {11, 13, 16}, {14, 15, 12}};
    int[][][] threeDimension = {{{4, 6, 5}}};
    String[] names={"Jhon","Rick","Ramond"};
    void display(){
        System.out.println(Arrays.toString(oneDimension));
        System.out.println(Arrays.deepToString(twoDimension));
        System.out.println(Arrays.deepToString(threeDimension));
        System.out.println(Arrays.toString(names));
    }
}

    public class JavaArrays {

    public static void main(String[]args){
        MyArrays myArrays=new MyArrays();
        myArrays.display();

    }
}
