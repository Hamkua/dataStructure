class HeapType:
    def __init__(self):
        heap = []*100
        heap_size = 0



def insertHeap(h, item):
    h.heap_size = h.heap_size + 1
    i = h.heap_size
    while((i!=1) and (item > h.heap[i / 2])):
        h.heap[i] = h.heap[i /2]
        i /= 2
    h.heap[i] = item


def deleteHeap(h):
    item = h.heap[1]
    temp = h.heap[h.heap_size]
    h.heap_size = h.heap_size - 1
    parent = 1
    child = 2
    while(child <= h.heap_size):
        if((child < h.heap_size) and (h.heap[child]) < h.heap[child +1]):
            child += 1
        
        if(temp >= h.heap[child]):
            break
        else:
            h.heap[parent] = h.heap[child]
            parent = child
            child = child * 2
    h.heap[parent] = temp
    return item

def printHeap(h):
    print("Heap : ", end="")
    for i in range(1, h.heap_size + 1):
        print("[" + h.heap[i] + "]", end="")
    




heap = HeapType()
insertHeap(heap, 10)
insertHeap(heap, 45)
insertHeap(heap, 19)
insertHeap(heap, 11)
insertHeap(heap, 96)

printHeap(heap)

n = heap.heap_size

for i in range(1, n+1):
    item = deleteHeap(heap)
    print("\n delete : [" + item + "]", end="")

