package ch04;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 编辑距离
 * 1 dp[i][j] = dp[i - 1][j] + insertCost;
 * 2 dp[i][j] = dp[i][j - 1] + deleteCost;
 * 3 if chars1[i - 1] == chars2[j - 1] :
 *      dp[i][j] = dp[i - 1][j - 1];
 *   else:
 *      dp[i][j] = dp[i -1][j - 1] + replaceCost;
 *
 * @author 王涵威
 * @date 2020/9/22 12:07
 */
public class Pro09EditCost {

    /**
     *
     * @return 编辑距离
     */
    public int solution0WithCost(String s1, String s2, int insertCost, int deleteCost, int replaceCost) {
        if (null == s1 || null == s2) {
            throw new IllegalArgumentException("s1 or s2 is not allow null.");
        } else if (s1.length() == 0 && s2.length() != 0) {
            return s2.length() * insertCost;
        } else if (s1.length() != 0 && s2.length() == 0) {
            return s1.length() * deleteCost;
        }

        int l1 = s1.length();
        int l2 = s2.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            dp[0][i] = i * insertCost;
        }

        for (int i = 1; i <= l2; i++){
            dp[i][0] = i * deleteCost;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int tmp1;
                if (c1[i - 1] == c2[j - 1]) {
                    tmp1 = dp[i - 1][j - 1];
                } else {
                    tmp1 = dp[i - 1][j - 1] + replaceCost;
                }
                int tmp2 = Math.min(dp[i][j - 1] + deleteCost, dp[i - 1][j] + insertCost);
                dp[i][j] = Math.min(tmp1, tmp2);
            }
        }
        return dp[l1][l2];
    }

    /**
     *
     * @return
     */
    public int solution1WithCost(String s1, String s2, int insertCost, int deleteCost, int replaceCost) {
        if (null == s1 || null == s2) {
            throw new IllegalArgumentException("s1 or s2 is not allow null.");
        } else if (s1.length() == 0 && s2.length() != 0) {
            return s2.length() * insertCost;
        } else if (s1.length() != 0 && s2.length() == 0) {
            return s1.length() * deleteCost;
        }

        int l1 = s1.length();
        int l2 = s2.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            dp[0][i] = i * insertCost;
        }

        for (int i = 1; i <= l2; i++){
            dp[i][0] = i * deleteCost;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int tmp1;
                if (c1[i - 1] == c2[j - 1]) {
                    tmp1 = dp[i - 1][j - 1];
                } else {
                    tmp1 = dp[i - 1][j - 1] + replaceCost;
                }
                int tmp2 = Math.min(dp[i][j - 1] + deleteCost, dp[i - 1][j] + insertCost);
                dp[i][j] = Math.min(tmp1, tmp2);
            }
        }
        return dp[l1][l2];
    }

    /**
     * 没有具体代价的编辑距离
     * https://leetcode-cn.com/problems/edit-distance/
     * @return 编辑距离
     */
    public int solution2(String s1, String s2) {
        if (null == s1 || null == s2) {
            throw new IllegalArgumentException("s1 or s2 is not allow null.");
        } else if (s1.length() == 0 && s2.length() != 0) {
            return s2.length();
        } else if (s1.length() != 0 && s2.length() == 0) {
            return s1.length();
        }

        int l1 = s1.length();
        int l2 = s2.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= l2; i++){
            dp[0][i] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int tmp1;
                if (c1[i - 1] == c2[j - 1]) {
                    tmp1 = dp[i - 1][j - 1];
                } else {
                    tmp1 = dp[i - 1][j - 1] + 1;
                }
                int tmp2 = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                dp[i][j] = Math.min(tmp1, tmp2);
            }
        }
        return dp[l1][l2];
    }


}
