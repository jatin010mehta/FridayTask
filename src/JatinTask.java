import java.util.PriorityQueue;

public class JatinTask {
    public static void main(String[] args) {
       String output = findOccurences("aaabbcddeeee");
        System.out.println(output);
        System.out.println(maxSum(new int[]{-1,2,4,2,5,-7,3}));
    }
    public static String findOccurences(String str){
        //“aaabbcddeeee” should return a3b2c1d2e4
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length()-1; i++) {
            int count = 1;
            while (i<str.length()-1&&str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            sb.append(count);
        }
        return sb.toString();
    }

    public static int maxSum(int[] input){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int val :input) {
            if (sum>=0){
                sum+=val;
                max=Math.max(max,sum);
            }else {
                sum=0;
                sum+=val;
            }
        }
        return max;
    }
    public static int[] mergeTwoArray(int[] array1,int[] array2){
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
        for(int val:array1)
            queue.add(val);
        for (int val :array2) {
            queue.add(val);
        }
        int size = queue.size();
        int[] output = new int[size];
        for (int i = 0; i < size; i++) {
            output[i]=queue.poll();
        }
        return output;
    }
}
