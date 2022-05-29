
public class Ex6 {
    public static void main(String[] args) {
        int i;
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        int size = list.length;
        System.out.print("정렬할 원소 : ");
        for(i = 0; i<size; i++){
            System.out.print("  " + list[i]);
        }

        System.out.println("\n <<<<<<<<< 셸 정렬 수행 >>>>>>>>>");
        shellSort(list, size);


    }

    public static void shellSort(int[] a, int size){
        int i, interval;
        interval = size / 2;
        while(interval >= 1){
            for(i = 0; i<interval; i++){
                intervalSort(a, i, size - 1, interval);
            }
            System.out.print("\n interval = " + interval + " >> ");
            for(i = 0; i<size; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println();
            interval /= 2;
        }
    }

    public static void intervalSort(int[] a, int begin, int end, int interval){
        int i, j, item;
        for(i = begin + interval; i<= end; i += interval){
            item = a[i];
            for(j = i - interval; j >= begin && item < a[j]; j-= interval){
                a[j + interval] = a[j];
            }
            a[j + interval] = item;
        }
    }
}
