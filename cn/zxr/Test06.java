package cn.zxr;

public class Test06 {
        public static int rotate_Array(int[] arr){
            if(arr == null){
                return 0;
            }
            int letf = arr[0];
            int next = 1;
            while(letf < arr[next]){
                letf = arr[next];
               next++;
            }
            return arr[next];
//            int index = arr.length / 2;
//            if(arr[index] > arr[index + 1]){
//                return arr[index + 1];
//            }
//            else if(arr[index] < arr[index + 1]){
//                int temp = index;
//                while(arr[temp] < arr[temp + 1]){
//                   temp++;
//                }
//                return arr[temp + 1];
//            }
//            //只有一个时
//            return arr[index];
        }

    public static void main(String[] args) {
            int[] arr = new int[]{4, 5, 1, 2, 3};
            System.out.print(rotate_Array(arr));

    }
}
