
public class Ex2 {
    public static void main(String[] args) {
        int i;
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        int size = list.length;
        System.out.print("정렬할 원소 : ");
        for(i = 0; i<size; i++){
            System.out.print("  " + list[i]);
        }

        System.out.println("\n <<<<<<<<< 버블 정렬 수행 >>>>>>>>>");
        bubbleSort(list, size);

    }

    public static void bubbleSort(int[] a, int size){
        int i,j,t,temp;
        for(i = size - 1; i>0; i--){
            System.out.print("\n" + (size - 1) + "단계>>");
            for(j = 0; j<i; j++){
                if(a[j] > a[j + 1]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                System.out.print("\n\t");
                for(t = 0; t<size; t++){
                    System.out.print("  " + a[t]);
                }
            }
        }
    }
}
