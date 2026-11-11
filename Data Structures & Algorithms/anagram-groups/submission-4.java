class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // get freq of letters, save as key
        // put word in hashmap(freq -> word bucket)

        Map<String, List<String>> freqToWords = new HashMap<>();

        for (String str : strs) {
            char[] freq = new char[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = new String(freq);
            
            freqToWords.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> res = new ArrayList<>(freqToWords.values());

        return res;
    }
}
