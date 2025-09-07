import java.util.Arrays;

class Merge{

    static void merge(int[]arr,int s,int e){
        if(s<e){
            int m=(s+e)/2;
            merge(arr,s,m);
            merge(arr,m+1,e);
        sort(arr,s,m,e);
        }
    }
    static void sort(int[]a,int s,int m,int e){
        int n1=m-s+1;
        int n2=e-m;
        int[] left=new int[n1];
        int[] right=new int[n2];


        for(int i=0;i<n1;i++){
            for(int j=m+1;j<n2;j++){
                if(a[i]>a[j]){
                    left[i]=a[j];
                    i++;
                }else{
                    right[j]=a[i];
                    j++;
                }
            }
        }

    }
    public static void main(String[] args) {
        int[] a={8,3,5,1,2};
        merge(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }
}