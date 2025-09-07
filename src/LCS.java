public class LCS {
    public static String lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];

        // Build dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Backtrack to get LCS string
        int i = m, j = n;
        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        return lcs.reverse().toString(); // Reverse the result
    }

    public static void main(String[] args) {
        String str1 = "KLPA";
        String str2 = "KPATB";
        String result = lcs(str1, str2);
        System.out.println("LCS: " + result);
    }
}
