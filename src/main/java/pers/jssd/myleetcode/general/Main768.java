package pers.jssd.myleetcode.general;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author root
 */
public class Main768 {

    public static void main(String[] args) {
//        int[] arr = new int[]{5, 4, 3, 2, 1};
//        int[] arr = new int[]{2,1,3,4,4};
//        int[] arr = new int[]{1, 0, 1, 3, 2};
        int[] arr = new int[]{1, 1, 0, 0, 1};
        Solution solution = new Solution();
        int res = solution.maxChunksToSorted(arr);
        System.out.println("res = " + res);
    }

    private static class Solution {
        public int maxChunksToSorted(int[] arr) {
            int start = 0;
            int end = 0;
            List<Integer> sort = Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());

            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                int e = arr[i];
                int index = start + sort.subList(start, arr.length).indexOf(e);
                if (index > end) {
                    end = index;
                }
                if (end == i) {
                    if (check(arr, sort, start, end)) {
                        res++;
                        start = i + 1;
                        end = start;
                    } else {
                        end ++;
                    }
                }
            }

            return res;
        }

        private boolean check(int[] arr, List<Integer> sort, int start, int end) {
            List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
            List<Integer> list = collect.subList(start, end + 1);
            list.sort(Comparator.comparingInt(value -> value));
            for (int i = start; i <= end; i++) {
                if (!list.get(i - start).equals(sort.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
