import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int [] arr = {32,12,44,25,55,15};
        int n = arr.length;

        HeapSort heapSort = new HeapSort();

        System.out.println(Arrays.toString(arr));

        heapSort.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    void sort(int[] arr){
        int n=arr.length;
        for(int i=(n-1)/2;i>=0;i--){
            maxHeap(arr,n,i);
        }

        for(int i=n-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeap(arr,i,0);
        }
    }
    void maxHeap(int[] arr,int n,int i){
        int largest = i; // root as largest element
        int left = (2*i)+1; //left node
        int right= (2*i)+2; //right node

        if(left<n && arr[left]>arr[largest]){
            largest = left;
        }
        if(right<n && arr[right]>arr[largest]){
            largest = right;
        }

        //if largest is not root
        if(largest!=i){
            int temp = arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;

            maxHeap(arr,n,largest);
        }
    }
}
