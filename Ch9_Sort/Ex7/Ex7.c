#include<stdio.h>
#define MAX 30

int sorted[MAX];
int size;

void merge(int a[], int m, int middle, int n){
    int i, j, k, t;
    i = m;
    j = middle + 1;
    k = m;

    while(i <= middle && j <=n){
        if(a[i] <= a[j]){
            sorted[k++] = a[i++];
        }
        else{
            sorted[k++] = a[j++];
        }
    }

    if(i > middle){
        for(t = j; t<=n; t++, k++){
            sorted[k] = a[t];
        }
    }
    else{
        for(t = i; t<=middle; t++, k++){
            sorted[k] = a[t];
        }
    }
    for(t = m; t<=n; t++){
        a[t] = sorted[t];
    }

    printf("\n병합 정렬 >> ");
    for(t=0; t<size; t++){
        printf("%4d", a[t]);
    }
}

void mergeSort(int a[], int m, int n){
    int middle;
    if(m < n){
        middle = (m+n)/2;
        mergeSort(a,m,middle);
        mergeSort(a,middle+1, n);
        merge(a, m, middle, n);
    }
}


int main(void){

    int i, list[8] = {69, 10, 30, 2, 16, 8, 31, 22};
    size = sizeof(list)/sizeof(list[0]);
    printf("\n 정렬할 원소 >> ");
    for(i = 0; i<size; i++){
        printf("%3d", list[i]);
    }
    printf("\n\n <<<<<<<<<< 병합 정렬 수행 >>>>>>>>>>\n");
    mergeSort(list, 0, size-1);
    
    getchar(); return 0;
}