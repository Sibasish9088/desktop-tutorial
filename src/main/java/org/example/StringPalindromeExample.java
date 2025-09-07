package org.example;

public class StringPalindromeExample {

    public static void main(String[] args) {
        final String word = "wototow";
        final int WARMUP = 10_000;     // warm-up iterations for JIT
        final int ITERS = 100_000;     // measured iterations per test
        final double NANO_TO_MICRO = 1000.0; // divide nanos by this to get μs

        // Print the boolean results (single-run) so you can see the logical equality
        System.out.println("Single-run results (logic check):");
        System.out.println("  reversedNaive says :     " + (word.equalsIgnoreCase(reversedNaive(word)) ? "Palindrome" : "Not a palindrome"));
        System.out.println("  reversedEfficient says : " + (word.equalsIgnoreCase(reversedEfficient(word)) ? "Palindrome" : "Not a palindrome"));
        System.out.println("  isPalindrome says :      " + (isPalindrome(word) ? "Palindrome" : "Not a palindrome"));
        System.out.println();

        // --- Warm up: call each implementation many times to let the JVM optimize hot code ---
        for (int i = 0; i < WARMUP; i++) {
            reversedNaive(word);
            reversedEfficient(word);
            isPalindrome(word);
        }

        // --- Measure reversedNaive ---
        long t0 = System.nanoTime();
        for (int i = 0; i < ITERS; i++) {
            reversedNaive(word);
        }
        long t1 = System.nanoTime();
        double avgNaiveUs = (t1 - t0) / (ITERS * NANO_TO_MICRO);

        // --- Measure reversedEfficient ---
        t0 = System.nanoTime();
        for (int i = 0; i < ITERS; i++) {
            reversedEfficient(word);
        }
        t1 = System.nanoTime();
        double avgEfficientUs = (t1 - t0) / (ITERS * NANO_TO_MICRO);

        // --- Measure isPalindrome ---
        t0 = System.nanoTime();
        for (int i = 0; i < ITERS; i++) {
            isPalindrome(word);
        }
        t1 = System.nanoTime();
        double avgIsPalUs = (t1 - t0) / (ITERS * NANO_TO_MICRO);

        System.out.println("Average times over " + ITERS + " iterations (μs):");
        System.out.printf("  reversedNaive     : %.6f μs (expected slow for long strings due to O(n²))%n", avgNaiveUs);
        System.out.printf("  reversedEfficient : %.6f μs (StringBuilder.reverse(), O(n))%n", avgEfficientUs);
        System.out.printf("  isPalindrome      : %.6f μs (two-pointer check, O(n) with minimal allocations)%n", avgIsPalUs);

        System.out.println();
        System.out.println("Notes:");
        System.out.println(" - reversedNaive uses repeated String concatenation inside a loop. In Java, Strings are immutable.");
        System.out.println("   Each concatenation creates a new String and copies characters: that leads to O(n²) behavior in practice.");
        System.out.println(" - reversedEfficient uses StringBuilder, which appends to a mutable buffer and reverses in O(n).");
        System.out.println(" - isPalindrome doesn't allocate a large new String at all — it only reads characters.");
        System.out.println(" - Measured averages are more stable because we warmed up the JVM and ran many iterations.");
    }

    // ---------------------------- Implementations ----------------------------

    /**
     * Naive reversed implementation using String concatenation inside the loop.
     * This is easy to write but performs poorly for long strings because each
     * concatenation copies the characters into a brand-new String object.
     * <p>
     * Complexity: roughly O(n²) in practice due to repeated copying.
     */
    static String reversedNaive(String word) {
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            // Each concat creates a new String under the hood -> expensive
            reversedWord = reversedWord.concat(String.valueOf(word.charAt(i)));
        }
        return reversedWord;
    }

    /**
     * Efficient reversed implementation using StringBuilder.
     * Complexity: O(n) time and O(n) extra space for the builder's buffer (which is expected).
     */
    static String reversedEfficient(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    /**
     * Two-pointer palindrome check that ignores non-alphanumeric characters and is case-insensitive.
     * Complexity: O(n) time, O(1) extra space.
     */
    private static boolean isPalindrome(String word) {

        int length = word.length();
        int left  = 0, right = length - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(word.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(word.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(word.charAt(left)) != Character.toLowerCase(word.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
