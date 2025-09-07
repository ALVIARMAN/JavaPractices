import java.util.Scanner;

class Main{
    void Binary(int[] arr,int k){
        int s=0,e=arr.length-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==k) {
                System.out.println("Found at position: " + mid);
                return;
            }
            else if(arr[mid]>k){
                e=mid-1;}
            else {
                s=mid+1;}
        }
        System.out.println("Not found");
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Main m=new Main();
        int[] arr={12,13,15,17,19,22,25};
        System.out.print("Enter key value: ");
        int key=s.nextInt();
        m.Binary(arr,key);
    }
}