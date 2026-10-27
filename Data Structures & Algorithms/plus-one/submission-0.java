class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    carry = false;
                }
            }
        }

        if (carry) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }

        return digits;
    }
}
