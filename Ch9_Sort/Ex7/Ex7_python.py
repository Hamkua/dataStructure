MAX = 30
sorted = [None]*MAX 
size = 0

def merge(a,m,middle,n):
    i = m
    j = middle + 1
    k = m

    while(i<= middle and j <= n):
        if(a[i] <= a[j]):
            sorted[k] = a[i]
            k += 1
            i += 1
        
        else:
            sorted[k] = a[j]
            k += 1
            j +=1

    if(i>middle):
        for t in range(j,n+1):
            sorted[k] = a[t]
            k += 1

    else:
        for t in range(i,middle + 1):
            sorted[k] = a[t]
            k += 1

    for t in range(m,n+1):
        a[t] = sorted[t]

    print("\n병합 정렬 >> ", end="")
    for t in range(size):
        print("   {}".format(a[t]), end="")


def mergeSort(a,m,n):
    if(m < n):
        middle = (m+n)//2
        mergeSort(a,m,middle)
        mergeSort(a,middle+1, n)
        merge(a,m,middle,n)


list = [69, 10, 30, 2, 16, 8, 31, 22]
size = len(list)

print("\n정렬할 원소 >> ",end="")
for i in range(size):
    print("  {}".format(list[i]), end="")

print("\n\n <<<<<<<<<<< 병합 정렬 수행 >>>>>>>>>>>")
mergeSort(list,0,size-1)
