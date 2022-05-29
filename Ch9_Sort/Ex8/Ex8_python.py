from collections import deque

RADIX = 10
DIGIT = 2

def radixSort(a, n):
    Q = list()
    factor = 1
    for bucket in range(RADIX):
        Q.append(deque())

    for d in range(DIGIT):
        for i in range(n):
            Q[(a[i]//factor) % RADIX].append(a[i])

        i = 0
        for bucket in range(RADIX):
            while(len(Q[bucket]) > 0):
                a[i] = Q[bucket].popleft()
                i += 1

        print("\n\n {} 단계 : ".format(d + 1), end="")
        for i in range(n):
            print("  {}".format(a[i]), end="")

        factor *= RADIX 

li = [69, 10, 30, 2, 16, 8, 31, 22]
size = len(li)

print("정렬할 원소 : ", end ="")
for i in range(size):
    print("  {}".format(li[i]), end = "")

print("\n <<<<<<<<<<<<<<<<< 기수 정렬 수행 >>>>>>>>>>>>>>>>>>>")
radixSort(li, size)

