import java.util.*;

public class AlianDict {
    public String alienOrder(String[] words) {
        // Write your code here
        Map<Character, Set<Character>> orderMap = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // edges
        for(int i = 0; i < words.length - 1; i++ ){
            String before = words[i];
            String after = words[i + 1];

            for(int j = 0; j < before.length() && j < after.length(); j++ ){
                if(before.charAt(j) == after.charAt(j) )
                    continue;
                else{
                    orderMap.putIfAbsent(before.charAt(j), new HashSet<Character>() );
                    orderMap.get(before.charAt(j)).add(after.charAt(j));
                    break;
                }
            }
        }
        // get indegree
        for(Set<Character> value : orderMap.values() ){
            for(Character c : value){
                if(!indegree.containsKey(c))
                    indegree.put(c, 1);
                else
                    indegree.put(c, indegree.get(c) + 1 );
            }
        }

        Queue<Character> q = new PriorityQueue<>();

        for(Character key : orderMap.keySet()){
            if(indegree.get(key) == 0){
                q.offer(key);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Character c = q.poll();
            sb.append(c);
            for(Character n : orderMap.get(c)){
                indegree.put(n, indegree.get(n) - 1);
                if(indegree.get(n) == 0){
                    q.offer(n);
                }
            }
        }

        return sb.toString();
    }
}