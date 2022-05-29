list = [69, 10, 30, 2, 16, 8, 31, 22]

def partition(a, begin, end, size):
    global i
    L = begin
    R = end
    pivot = begin
    
    i += 1
    print("\n [{}단계 : pivot = {} ]".format(i, a[pivot]))
    while(L < R):
        while((a[L] < a[pivot])and(L < R)):
            L += 1
        while((a[R] >= a[pivot])and(L < R)):
            R -= 1
        if(L < R):
            a[L], a[R] = a[R], a[L]
            if(L == pivot):
                pivot = R

    a[pivot], a[R] = a[R], a[pivot]
    for t in range(size):
        print("   {}".format(a[t]), end = "")
    print()
    return R

def quickSort(a, begin, end, size):
    if(begin < end):
        p = partition(a, begin, end, size)
        quickSort(a, begin, p - 1, size)
        quickSort(a, p + 1, end, size)

    

        

print("정렬할 원소 : ",end="")
i = 0
for j in range(len(list)):
    print("  {}".format(list[j]), end="")

print("\n <<<<<<<<<<<<<< 퀵 정렬 수행 >>>>>>>>>>>>>>> ")
quickSort(list,0 ,len(list) - 1, len(list))