
public class Ex7 {

    static final int MAX = 30;
    static int[] sorted = new int[MAX];
    static int size;

    public static void main(String[] args) {
        int i;
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        size = list.length;
        System.out.print("정렬할 원소 : ");
        for(i = 0; i<size; i++){
            System.out.print("  " + list[i]);
        }

        System.out.println("\n <<<<<<<<< 병합 정렬 수행 >>>>>>>>>");
        mergeSort(list, 0, size - 1);

    }

    public static void mergeSort(int[] a, int m, int n){
        int middle;
        if(m < n){
            middle = (m + n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle + 1, n);
            merge(a, m, middle, n);
        }
    }

    public static void merge(int[] a, int m, int middle, int n){
        int i, j, k, t;
        i = m;
        j = middle + 1;
        k = m;

        while(i<= middle && j<=n){
            if(a[i] <= a[j]){
                sorted[k++] = a[i++];
            }else{
                sorted[k++] = a[j++];
            }
        }

        if(i > middle){
            for(t = j; t<=n; t++, k++){
                sorted[k] = a[t];
            }
        } else{
            for(t = i; t<=middle; t++, k++){
                sorted[k] = a[t];
            }
        }

        for(t = m; t<= n; t++){
            a[t] = sorted[t];
        }

        System.out.print("\n 병합 정렬 >> ");
        for(t = 0; t<size; t++){
            System.out.print("   " + a[t]);
        }
    }
}
