class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();

        for (String word : wordList) {
            set.add(word);
        }

        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;

            if (word.equals(endWord)) {
                return steps;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] wordChar = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordChar[i] = ch;
                    String w = new String(wordChar);

                    if (set.contains(w)) {
                        set.remove(w);
                        q.offer(new Pair(w, steps + 1));
                    }
                }
            }
        }

        return 0;
    }

    private class Pair {
        String word;
        int steps;

        public Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}
