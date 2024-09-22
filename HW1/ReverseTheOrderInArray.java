package HW1;

public class ReverseTheOrderInArray {
    public static void reverseOrder(String[] arr){
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            String temp = arr[n - i - 1];
            arr[n - i - 1] = arr[i];
            arr[i] = temp;
        }
    }

//    public static void main(String[] args) {
//        String[] s = new String[]{"a" , "b", "c", "d"};
//        reverseOrder(s);
//        for (String c : s){
//            System.out.println(c);
//        }
//    }
}
