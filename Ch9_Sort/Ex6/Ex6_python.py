list = [69, 10, 30, 2, 16, 8, 31, 22]


def intervalSort(a, begin, end, interval):
    
    for i in range(begin + interval, end + 1, interval):
        item = a[i]
        j = i - interval
        while(j >= begin and item < a[j]):
            a[j + interval] = a[j]
            j -= interval
          
        a[j + interval] = item



def shellSort(a, size):
    interval = size // 2
    while(interval >= 1):
        for i in range(interval):
            intervalSort(a, i, size - 1, interval)
        print("\n interval = {} >>".format(interval), end="")
        for i in range(size):
            print("{} ".format(a[i]), end="")
        print()
        interval = interval // 2
    

        

print("정렬할 원소 : ",end="")
i = 0
for j in range(len(list)):
    print("  {}".format(list[j]), end="")

print("\n <<<<<<<<<<<<<< 셸 정렬 수행 >>>>>>>>>>>>>>> ")
shellSort(list,len(list))