list = [69, 10, 30, 2, 16, 8, 31, 22]

def selectionSort(a,size):
    for i in range(size -1):
        min = i
        for j in range(i,size):
            if( a[min] > a[j]):
                min = j

        
        a[min], a[i] = a[i], a[min]

        print("\n{}단계 : ".format(i), end="")
        for t in range(size):
            print("  {}".format(a[t]),end="")

print("정렬할 원소 : ",end="")
for i in range(len(list)):
    print("  {}".format(list[i]), end="")

print("\n <<<<<<<<<<<<<< 선택 정렬 수행 >>>>>>>>>>>>>>> ")
selectionSort(list, len(list))

