import java.util.Arrays;

class Main{

    static void quick(int[] a,int low,int high){
        if(low<high){
            int pivotIndex=sort(a,low,high);
            quick(a,low,pivotIndex-1);
            quick(a,pivotIndex+1,high);
        }
    }
    static int sort(int[]a,int l,int h){
        int pivot=h;
        int j=l-1;
        for(int i=l;i<h;i++){
            if(a[i]<=a[pivot]){
                j++;
                swap(a,i,j);

            }
        }
        swap(a,j+1,pivot);
        return j+1;
    }
    static void swap(int[] a,int l,int h){
        int temp=a[l];
        a[l]=a[h];
        a[h]=temp;
    }

    public static void main(String[] args) {
        int[] arr={12,3,6,3,8};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}