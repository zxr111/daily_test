package cn.zxr;

import java.util.LinkedList;
import java.util.List;

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

    //和插入排序差不多，只是每次移动h,h在不停的变化,也就是将手牌分为两部分，然后互相插入
    public static void shellSort(int A[]){
        int h = 0;
        while (h < A.length){
            h = h * 3 + 1;
        }
        while (h >= 1){
            for(int i = h; i < A.length; i++){
                int j = i - h;
                int get = A[i];
                while(j >= 0 && A[j] > get){
                    A[j + h] = A[j];
                    j -= h;
                }
                A[j + h] = get;
            }
            h = (h - 1) / 3;
        }
    }

//    public static void merge(int A[], int left, int mid, int right){
//           int len = right - left + 1;
//           int[] stock = new int[len];
//           int index = 0;
//           int i = left;
//           int j = mid + 1;
//           while (i == right){
//               stock[index++] = A[i];
//           }
//           while (i < mid){
//               stock[index++] = A[i++];
//           }
//           while (j < right){
//               stock[index++] = A[j++];
//           }
//           for (int k = 0; k < len; k++){
//               A[left++] = stock[k];
//           }
//        }
//
//    public static void mergeSortRecursion(int A[], int left, int right){
//        if(left == right)
//            return;
//        int mid = (left + right) / 2;
//        mergeSortRecursion(A, left, mid);
//        mergeSortRecursion(A, mid + 1, right);
//        merge(A, left, mid, right);
//    }
//
//    public static void mergeSortIteration(int A[], int len){
//        int left, mid, right;
//        for(int i = 1; i < len; i *= 2){
//            left = 0;
//            while (left + i < len){
//                mid = left + i - 1;
//                right = mid + i + 1;
//                merge(A, left, mid, right);
//                left = right + 1;
//            }
//        }
//    }

    int partition(int A[], int len){}


    public static void main(String[] args) {
        int A[] = {8, 7, 6, 5, 4, 3, 2, 1};
//        bubbleSort(A);
//        cocktailSort(A);
//        selectionSort(A);
//        insertionSort(A);
//        insertionSortDichotomy(A);
//        shellSort(A);
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + ",");
        }
    }
}
