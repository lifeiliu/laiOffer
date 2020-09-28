
import java.util.ArrayList;
import java.util.List;

public class test {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        helper(result, nums, new ArrayList<Integer>());
        return result;

    }

    private void helper(List<List<Integer>> result, int[] nums, List<Integer> permutation){
        if(nums.length == permutation.size()){
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(permutation.contains(nums[i]))
                continue;
            permutation.add(nums[i]);
            helper(result, nums, permutation);
            permutation.remove(permutation.size() - 1);

        }
    }

    public static void main(String[] args) {
        test t1 = new test();

        System.out.println(t1.permute(new int[]{1,2,3,4}));
    }
}