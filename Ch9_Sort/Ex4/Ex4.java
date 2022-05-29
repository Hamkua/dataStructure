public class Ex4 {
    static int i = 0;
    public static void main(String[] args) {
        int i;
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        int size = list.length;
        System.out.print("정렬할 원소 : ");
        for(i = 0; i<size; i++){
            System.out.print("  " + list[i]);
        }

        System.out.println("\n <<<<<<<<< 퀵 정렬 수행 >>>>>>>>>");
        quickSort(list, 0, size -1, size);
    }

    public static void quickSort(int[] a, int begin, int end, int size){
        int p;
        if(begin < end){
            p = partition(a, begin, end, size);
            quickSort(a, begin, p - 1, size);
            quickSort(a, p + 1, end, size);
        }
    }

    public static int partition(int[] a, int begin, int end, int size){
        int pivot, L, R, t, temp;
        L = begin;
        R = end;
        pivot = begin;
        System.out.print("\n [" + (++i) + "단계 : pivot = " + a[pivot] + " ] \n");
        while(L < R){
            while((a[L] < a[pivot]) && (L < R)){
                L++;
            }
            while((a[R] >= a[pivot]) && (L < R)){
                R--;
            }
            if(L < R){
                temp = a[L];
                a[L] = a[R];
                a[R] = temp;

                if(L == pivot){
                    pivot = R;
                }
            }
        }
        temp = a[pivot];
        a[pivot] = a[R];
        a[R] = temp;
        for(t = 0; t<size; t++){
            System.out.print("   " + a[t]);
        }
        System.out.println();
        return R;
    }
}
