package cn.zxr;

public class Sorting {
    public static void swap(int A[], int i, int j){
        int temp;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void bubbleSort(int A[]){
        for(int j = 0; j < A.length - 1; j++)
            for(int i = 0; i < A.length - 1; i++){
                if(A[i] > A[i + 1])
                    swap(A, i, i + 1);
            }
    }

    public static void cocktailSort(int A[]){
        int left = 0;
        int right = A.length - 1;
        while(left < right){
            //最左扫到最右, 最大的放在最右边
            for(int i = left; i < right; i++){
                if(A[i] > A[i + 1]){
                    swap(A, i, i + 1);
                }
            }
            right--;
            //最右扫到最左,最小的 放在最左边
            for (int i = right; i > left; i--){
                if(A[i - 1] > A[i]){
                    swap(A, i, i - 1);
                }
            }
            left++;
        }
    }

    public static void selectionSort(int A[]){
        for(int i = 0; i < A.length - 1; i++){
            int min = i;
            //每次选出最小的，并交换
            for(int j = i + 1; j < A.length; j++){
                if(A[min] > A[j])
                    min = j;
            }
            if(min != i)
                swap(A, min, i);
        }
    }

    public static void insertionSort(int A[]){
       for(int i = 1; i < A.length; i++) {
           int get = A[i];         //打扑克抽到的牌查入排好序的手牌
           int j = i - 1;
           while(j >= 0 && A[j] > get){
              A[j + 1] = A[j];     //牌大的放在手牌的右边
              j--;
           }
           A[j + 1] = get;         //牌小的放手牌的左边
       }
    }
    //二分插入排序
    public static void insertionSortDichotomy(int A[]){
        int left;
        int right;
        int mid;
        int get;
       for(int i = 1; i < A.length; i++) {
           left = 0;
           right = i - 1;
           get = A[i];
           while (left < right){
               mid = (left + right) / 2;
               if(A[mid] > get)
                   right = mid - 1;
               else
                   left = mid + 1;
           }
           for(int j = i - 1; j >= left; j--){ //将欲查入新牌位置右边的牌整体向右移动一个单位
              A[j + 1]  = A[j];
           }
           A[left] = get;
       }
    }



    public static void main(String[] args) {
        int A[] = {8, 7, 6, 5, 4, 3, 2, 1};
//        bubbleSort(A);
//        cocktailSort(A);
//        selectionSort(A);
//        insertionSort(A);
        insertionSortDichotomy(A);
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + ",");
        }
    }
}
