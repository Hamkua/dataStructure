def insertionSort(a, size):

    for i in range(1,size):
        tmp = a[i]
        j = i
        while((j>0)and (a[j-1]> tmp)):
            a[j] = a[j-1]
            j -= 1

        a[j] = tmp
        print("\n {}단계 : ".format(i), end="")
        for t in range(size):
            print("  {}".format(a[t]),end ="")

li = [69, 10, 30, 2, 16, 8, 31, 22]
size = len(li)

print("\n정렬할 원소",end="")
for i in range(size):
    print("  {}".format(li[i]), end="")

print("\n\n <<<<<<<<<<<< 삽입 정렬 수행 >>>>>>>>>>> ")
insertionSort(li, size)