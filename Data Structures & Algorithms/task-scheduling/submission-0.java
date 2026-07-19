class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair> q = new LinkedList<>();
        int[] freq = new int[26];
        int time = 0;

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        for (int num : freq) {
            if (num != 0) {
                maxHeap.add(num);
            }
        }

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int task = maxHeap.poll() - 1;
                if (task != 0) {
                    q.offer(new Pair(task, time + n));
                }
            }
            if (!q.isEmpty() && q.peek().time == time) {
                Pair p = q.poll();
                maxHeap.add(p.task);
            }
        }

        return time;
    }
}

class Pair {
    int task;
    int time;

    public Pair(int task, int time) {
        this.task = task;
        this.time = time;
    }
}
