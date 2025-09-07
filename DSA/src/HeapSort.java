class Heap{
    public static void main(String[] args) {
        int[] arr={10,20,15,30,40};
        sort(arr);
        display(arr);
    }

    static void sort(int[] arr){

        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }

        //sort (Delete from max heap)
        for(int i=n-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp; // swap last node with first one because first one will delete baby....

            heapify(arr,i,0); // previously total node n-1 but it shirnks after delete so n becomes i 😅
        }
    }
    static void heapify(int[] arr,int n,int i){
        int large=i;
        int left=2*i+1;
        int right=2*i+2;

        //compair root with left child
        if(left<n && arr[left]>arr[large])  large=left;

        //compair large element with right child
        if(right<n && arr[right]>arr[large]) large=right;

        if(large!=i){
            int temp=arr[i];
            arr[i]=arr[large];
            arr[large]=temp;

            heapify(arr,n,large); // previously I used i insted of large here😂😅
        }
    }
    static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+", ");
        }
    }
}