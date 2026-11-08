class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        
        for (String s : strs) {
            int[] freq = new int[26];
            
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            
            String key = Arrays.toString(freq);
            res.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(res.values());
    }
}
