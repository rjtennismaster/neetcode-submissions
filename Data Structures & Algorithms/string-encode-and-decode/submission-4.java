class Solution {

    // str.length() + '#' + str
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();

        while (i < str.length()) {
            int indexOfNextHashtag = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, indexOfNextHashtag));
            int start = indexOfNextHashtag + 1;

            res.add(str.substring(start, start + len));
            i = start + len;
        }

        return res;
    }
}
