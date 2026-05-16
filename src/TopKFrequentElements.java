// TopKFrequentElements.java

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num,
                    map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(
                        (a, b) -> map.get(a) - map.get(b)
                );

        for (int n : map.keySet()) {

            pq.add(n);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        TopKFrequentElements obj =
                new TopKFrequentElements();

        int[] result = obj.topKFrequent(
                new int[]{1,1,1,2,2,3},
                2
        );

        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
