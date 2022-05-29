
public class Ex5 {
    public static void main(String[] args) {
        int i;
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        int size = list.length;
        System.out.print("정렬할 원소 : ");
        for(i = 0; i<size; i++){
            System.out.print("  " + list[i]);
        }

        System.out.println("\n <<<<<<<<< 삽입 정렬 수행 >>>>>>>>>");
        insertionSort(list, size);
    }

    public static void insertionSort(int[] a, int size){
        int i, j, t, temp;

        for(i = 1; i<size; i++){
            temp = a[i];
            j = i;
            while((j > 0)&&(a[j - 1] > temp)){
                a[j] = a[j - 1];
                j -= 1;
            }
            a[j] = temp;
            System.out.print("\n" + i + "단계 : ");
            for(t = 0; t<size; t++){
                System.out.print("  " + a[t]);
            }
        }
    }
}
