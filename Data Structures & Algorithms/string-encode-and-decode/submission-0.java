class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        String delimiter = "#";

        for (String s : strs) {
            builder.append(s.length()).append(delimiter).append(s);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> resultList = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            // i is at the number part
            int length = Integer.parseInt(str.substring(i, j));
            // move i to the string part
            i = j + 1;
            j = i + length;
            resultList.add(str.substring(i, j));

            // move i again to the next number part
            i = j;
        }
        return resultList;
    }
}
