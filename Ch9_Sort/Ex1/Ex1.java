

public class Ex1 {
    public static void main(String[] args) {
        int i;
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        int size = list.length;
        System.out.print("정렬할 원소 : ");
        for(i = 0; i<size; i++){
            System.out.print("  " + list[i]);
        }

        System.out.println("\n <<<<<<<<< 선택 정렬 수행 >>>>>>>>>");
        selectionSort(list, size);

    }

    public static void selectionSort(int[] a, int size){
        int i,j,t,min,temp;
        for(i = 0; i < size - 1 ; i++){
            min = i;
            for(j = i + 1; j < size; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            System.out.print("\n" + (i+1) + "단계 : ");
            for(t = 0; t<size; t++){
                System.out.print("  " + a[t]);
            }
        }
    }
}
