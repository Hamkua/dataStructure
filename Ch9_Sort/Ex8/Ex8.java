

import java.util.LinkedList;

public class Ex8 {
    static final int RADIX = 10;
    static final int DIGIT = 2;
    static LinkedList[] Q = new LinkedList[RADIX];
    public static void main(String[] args) {
        int i;
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        int size = list.length;
        System.out.print("정렬할 원소 : ");
        for(i = 0; i<size; i++){
            System.out.print("  " + list[i]);
        }

        System.out.println("\n <<<<<<<<< 기수 정렬 수행 >>>>>>>>>");
        radixSort(list, size);

    }

    public static void radixSort(int[] a, int n){
        int bucket, i, d;
        int factor = 1;
        for(bucket = 0; bucket < RADIX; bucket++){
            Q[bucket] = new LinkedList<Integer>();
        }

        for(d = 0; d< DIGIT; d++){
            for(i = 0; i<n; i++){
                Q[(a[i]/factor) % RADIX].add(a[i]);
            }
            for(bucket = 0, i = 0; bucket<RADIX; bucket++){
                while(!Q[bucket].isEmpty()){
                    a[i++] = (Integer)Q[bucket].poll();

                }
            }
            System.out.print("\n\n " + (d + 1) + " 단계 : ");
            for(i = 0; i<n; i++){
                System.out.print("  " + a[i]);
            }
            factor *= RADIX;
        }
    }
}
