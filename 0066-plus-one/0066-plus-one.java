class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and process carry
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // No carry needed
                return digits;
            }
            digits[i] = 0; // Set current digit to 0 and carry over to next
        }

        // If all digits were 9 (e.g., 999 → 1000)
        int[] result = new int[n + 1];
        result[0] = 1; // First digit is 1, rest are 0 by default
        return result;
    }
}
