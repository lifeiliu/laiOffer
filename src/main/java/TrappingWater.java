public class TrappingWater {
    private static int trap(int[] height){
        //preMax of left and right
        if(height == null || height.length < 2)
            return 0;
        int len = height.length;
        int left[] = new int[len];
        int right[] = new int[len];
        int leftMax = height[0];
        left[0] = leftMax;
        int rightMax = height[len - 1];
        right[len - 1] = rightMax;
        for(int i = 1; i < height.length; i++){
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for(int i = len - 2; i >= 0; i--){
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int sum = 0;
        for(int i = 1; i < len - 2; i++){
            int temp = Math.min(left[i], right[i]) - height[i];
            sum += temp > 0 ? temp : 0;
        }
        return sum;
    }

}
