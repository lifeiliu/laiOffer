public class least2 {
    private static int least2(int[] nums){
        if(nums == null || nums.length < 2)
            return -1;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int n : nums){
            if(n < first){
                second = first;
                first = n;
            }else if(n < second && n != first)
                second = n;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] n = {-1,-1,0, 1, 2};
        System.out.println(least2(n));
        int a = 7, b = 2;
        int c = a / b ;
        System.out.println(c);
    }
}
