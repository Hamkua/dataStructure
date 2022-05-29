#include<stdio.h>


void insertionSort(int a[], int size);

int main(void){
    
    int i, list[8] = {69, 10, 30,2,16,8, 31, 22};
    int size = sizeof(list)/ sizeof(list[0]);
    printf("\n정렬할 원소");
    for(i = 0; i<size; i++){
        printf("%3d", list[i]);
    }
    printf("\n\n<<<<<<<<<삽입 정렬 수행>>>>>>>>>>\n");
    insertionSort(list, size);

    getchar(); return 0;
}

void insertionSort(int a[], int size){
    int i,j,t,temp;
    for(i = 1; i< size; i++){
        temp = a[i];
        j = i;
        while((j>0)&&(a[j-1]>temp)){
            a[j] = a[j-1];
            j = j-1;
        }
        a[j] = temp;
        printf("\n %d단계 : ", i);
        for(t = 0; t< size; t++){
            printf("%3d", a[t]);
        }
    }
}