class Solution {

    public String encode(List<String> strs) {
        // encoded string: 3(length) + # + rawstring
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();        
    }

    public List<String> decode(String str) {
        // till we hit the end
        // 1. since we start i at 0, get location of next hashtag
        // 2. use that to get length to read starting from i
        // 3. add rawstring (a substring from # + 1 to len) to sb

        List<String> res = new ArrayList<>();
        
        int i = 0;
        while (i < str.length()) {
            int nextHashtag = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, nextHashtag));
            int start = nextHashtag + 1;

            res.add(str.substring(start, start + len));
            
            i = start + len;
        }

        return res;
    }
}
