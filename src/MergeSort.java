import java.util.Arrays;

public class MergeSort{

    static void merge(int[] arr,int s,int e){
        int mid = (s+e) /2;  // s +(e-s) /2;
        if(s<e){
            merge(arr,s,mid);
            merge(arr,mid+1,e);
            sort(arr,s,mid,e);
        }
    }
    static void Merge(int[] arr,int s,int e){
        int mid = (s+e) /2;  // s +(e-s) /2;
        if(s<e){
            merge(arr,s,mid);
            merge(arr,mid+1,e);

            Sort(arr,s,mid,e);
        }
    }
    static void sort(int[] arr,int s,int m,int e){
        int n1 = m-s+1;
        int n2 = e-m;
        int[] l = new int[n1];
        int[] r = new int[n2];

        for(int i=0;i<n1;i++){
            l[i]=arr[s+1];
        }
        for(int j=0;j<n2;j++){
            r[j]=arr[m+1+j];
        }
        int i=0,j=0;
        int k=s;
        while(i<n1 && j<n2){
            if(l[i]<= r[j]){
                arr[k] = l[i];
                i++;
            }else{
                arr[k]=r[j];
                j++;
            }k++;
        }
        //copy remaining data to main array(if any)
        while(i<n1){
            arr[k++]=l[i++];
        }
        while(j<n2){
            arr[k++]=r[j++];
        }
    }
    static void Sort(int[]arr,int s,int m,int e){
        int n1=s;
        int n2=m+1;
        while(n1<=m && n2<=e){
            if(arr[n1]<=arr[n2]){
                n1++; // Already sorted
            }else{
                int temp=arr[n2];
                int index=n2;
                while(index>n1){
                    arr[index]=arr[index-1];
                    index--;
                }
                arr[n1]=temp;
                n1++;m++;n2++;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr ={15,8,25,10,11,16};
        System.out.println(Arrays.toString(arr));
        //merge(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));

        //merge sort without using temp arrays.....
        Merge(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}