class Solution {
    public String multiply(String num1, String num2) {
        // edge case
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        // result arr
        int[] res = new int[num1.length() + num2.length()];

        // reverse strings
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        // multiply strings
        for (int s1 = 0; s1 < num1.length(); s1++) {
            for (int s2 = 0; s2 < num2.length(); s2++) {
                res[s1 + s2] += (num1.charAt(s1) - '0') * (num2.charAt(s2) - '0');
                res[s1 + s2 + 1] += res[s1 + s2] / 10;
                res[s1 + s2] = res[s1 + s2] % 10;
            }
        }

        // find leading zeroes
        int i = res.length - 1;

        while (i >= 0 && res[i] == 0) i--;

        StringBuilder sb = new StringBuilder();

        while (i >= 0) sb.append(res[i--]);

        return sb.toString();
    }
}
