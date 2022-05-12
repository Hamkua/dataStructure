package dataStructure;
class HeapType{
    int[] heap = new int[100];
    int heap_size;

    public static void insertHeap(HeapType h, int item){
        h.heap_size = h.heap_size + 1;
        int i = h.heap_size;
        while((i!=1)&&(item > h.heap[i / 2])){
            h.heap[i] = h.heap[i /2];
            i /= 2;
        }
        h.heap[i] = item;
    }

    public static int deleteHeap(HeapType h){
        int parent, child;
        int item, temp;
        item = h.heap[1];
        temp = h.heap[h.heap_size];
        h.heap_size = h.heap_size - 1;
        parent = 1;
        child = 2;
        while(child <= h.heap_size){
            if((child < h.heap_size) && (h.heap[child]) < h.heap[child +1]){
                child++;
            }
            if(temp >= h.heap[child]){
                break;
            }
            else{
                h.heap[parent] = h.heap[child];
                parent = child;
                child = child * 2;
            }
        }
        h.heap[parent] = temp;
        return item;
    }

    public static void printHeap(HeapType h){
        int i;
        System.out.print("Heap : ");
        for(i = 1; i <= h.heap_size; i++){
            System.out.print("[" + h.heap[i] + "]");
        }
    }
}
public class Ch7Ex6 {
    public static void main(String[] args) {
        int i, n, item;
        HeapType heap = new HeapType();
        HeapType.insertHeap(heap, 10);
        HeapType.insertHeap(heap, 45);
        HeapType.insertHeap(heap, 19);
        HeapType.insertHeap(heap, 11);
        HeapType.insertHeap(heap, 96);

        HeapType.printHeap(heap);

        n = heap.heap_size;
        for(i = 1; i <= n; i++){
            item = HeapType.deleteHeap(heap);
            System.out.print("\n delete : [" + item + "]");
        }
    }
}
