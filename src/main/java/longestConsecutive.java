import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    public int longestConsecutive(int[] num) {
        // write your code here
        if(num == null)
            return 0;

        Set<Integer> set = new HashSet<>();
        for(int n : num){
            set.add(n);
        }

        int ans = 0;
        for(int i : num){
            if(set.contains(i)){
                set.remove(i);
                int l = i - 1;
                int r = i + 1;
                while(set.contains(l)){
                    l--;
                    set.remove(l);
                }
                while(set.contains(r)){
                    r++;
                    set.remove(r);
                }
                ans = Math.max(ans, r - l - 1);
            }

        }
        return ans;

    }
}
