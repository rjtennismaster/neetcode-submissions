class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int indexOfHashtag = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, indexOfHashtag));
            int start = indexOfHashtag + 1;

            res.add(str.substring(start, start + len));
            i = start + len;
        }

        return res;
    }
}
