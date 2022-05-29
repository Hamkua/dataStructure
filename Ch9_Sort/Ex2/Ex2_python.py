list = [69, 10, 30, 2, 16, 8, 31, 22]

def bubbleSort(a,size):
    for i in range(size,1,-1):
        i -= 1
        print("\n {} 단계 >>".format(size - i), end ="")
        for j in range(i):
            if(a[j] > a[j + 1]):
                a[j],a[j + 1] = a[j + 1], a[j]

            print("\n\t", end="")
            for t in range(size):
                print("  {} ".format(a[t]), end="")

        

print("정렬할 원소 : ",end="")
for i in range(len(list)):
    print("  {}".format(list[i]), end="")

print("\n <<<<<<<<<<<<<< 버블 정렬 수행 >>>>>>>>>>>>>>> ")
bubbleSort(list, len(list))

