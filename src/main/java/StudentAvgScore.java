import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StudentAvgScore {
    public static int bestAvg(String[][] grades){
        if(grades == null || grades[0].length == 0)
            return 0;
        Map<String, int[]> studentAvgScore= new HashMap<>();

        for(String[] grade : grades){
            String name = grade[0];
            int score = Integer.parseInt(grade[1]);
            if(!studentAvgScore.containsKey(name))
                studentAvgScore.put(name, new int[]{score, 1});
            else{
                int[] stat = studentAvgScore.get(name);
                int total = stat[0] + score;
                int times = stat[1] + 1;
                studentAvgScore.put(name, new int[]{total, times});
            }
        }
        int max = Integer.MIN_VALUE;
        for(int[] each : studentAvgScore.values()){
            int avg = (int) Math.floor(each[0] * 1.0 / each[1]);
            if(avg > max)
                max = avg;
        }
        return max;
    }

    public static void main(String[] args) {
        String[][] grades = {{"Tom", "88"}, {"Tom", "40"}, {"Jimmy", "100"}, {"Jimmy","55"}};
        System.out.println(bestAvg(grades));
    }
}
