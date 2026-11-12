class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // get freq of each letter in each word
        // put words in a bucket [freq[] -> word bucket]

        Map<String, List<String>> buckets = new HashMap<>();

        for (String str : strs) {
            char[] freq = new char[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = new String(freq);

            buckets.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> res = new ArrayList<>(buckets.values());

        return res;    
    }
}
