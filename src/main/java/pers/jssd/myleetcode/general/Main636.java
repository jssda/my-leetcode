package pers.jssd.myleetcode.general;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author root
 */
public class Main636 {

    public static void main(String[] args) {
//        int n = 2;
//        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
//        int n = 1;
//        List<String> logs = Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
//        int n = 2;
//        List<String> logs = Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
//        int n = 2;
//        List<String> logs = Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8");
        int n = 1;
        List<String> logs = Arrays.asList("0:start:0","0:end:0");
        Solution solution = new Solution();
        int[] res = solution.exclusiveTime(n, logs);
        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));

    }

    private static class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            Deque<Program> queue = new LinkedList<>();
            int[] res = new int[n];
            for (String log : logs) {
                String[] split = log.split(":");
                if ("start".equals(split[1])) {
                    int timestamp = Integer.parseInt(split[2]);
                    Program program = new Program(Integer.parseInt(split[0]), timestamp);
                    if (!queue.isEmpty()) {
                        Program first = queue.getFirst();
                        first.time += timestamp - first.timestamp;
                    }
                    queue.addFirst(program);
                } else {
                    Program program = queue.removeFirst();
                    int id = Integer.parseInt(split[0]);
                    int time = Integer.parseInt(split[2]) + 1;
                    if (!queue.isEmpty()) {
                        Program first = queue.getFirst();
                        first.timestamp = time;
                    }

                    program.time += time - program.timestamp;
                    res[id] = res[id] += program.time;
                }

            }
            return res;
        }

        private static class Program {
            int id;

            int timestamp;

            int time;

            public Program(int id, int timestamp) {
                this.id = id;
                this.timestamp = timestamp;
            }
        }
    }

}
