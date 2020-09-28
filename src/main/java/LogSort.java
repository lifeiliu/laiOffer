import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LogSort {
    /**
     * @param logs: the logs
     * @return: the log after sorting
     */
    public static String[] logSort(String[] logs) {
        // Write your code here
        List<Log> numberLogs = new ArrayList<>();
        List<Log> letterLogs = new ArrayList<>();
        List<Log> res = new ArrayList<>();

        for(String log : logs){
            Log newLog = new Log(log);
            if(Character.isDigit(newLog.content.trim().charAt(0))){
                numberLogs.add(newLog);
            }else{
                letterLogs.add(newLog);
            }
        }

        res = letterLogs.stream()
                .sorted(Comparator.comparing(Log :: getContent)
                        .thenComparing(Log :: getId))
                .collect(Collectors.toList());

        res.addAll(numberLogs.stream()
                .sorted(Comparator.comparing(Log :: getContent)
                        .thenComparing(Log :: getId))
                .collect(Collectors.toList()));

        String[] result = new String[res.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = res.get(i).toString();
        }
        return result;

    }

    public static void main(String[] args) {
        String[] test = { "zo4 4 7",
                "a100 Actzoo",
                "a100 Act zoo",
                "Tac Bctzoo",
                "Tab Bctzoo",
                "g9 act car"};
        System.out.println(Arrays.toString(logSort(test)));
    }

}

class Log{
    String id;
    String content;

    public Log(){
    }

    public Log(String raw){
        int index = raw.indexOf(' ');
        this.id = raw.substring(0, index);
        this.content = raw.substring(index);
    }

    public String getId(){
        return this.id.trim();
    }

    public String getContent(){
        return this.content.trim();
    }

    @Override
    public String toString() {
        return this.id + this.content;
    }
}