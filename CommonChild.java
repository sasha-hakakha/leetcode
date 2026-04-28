//HackerRank Common Child 
class Result {

    public static int commonChild(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
		if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
		else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[s1.length()][s2.length()];
    }
}

public class CommonChild {
    public static void main(String[] args) {

        String[][] tests = {
            {"HARRY", "SALLY"},          
            {"AA", "BB"},                
            {"SHINCHAN", "NOHARAAA"},    
            {"ABCDEF", "FBDAMN"}         
        };

        for (int i = 0; i < tests.length; i++) {
            String s1 = tests[i][0];
            String s2 = tests[i][1];

            int result = Result.commonChild(s1, s2);
            System.out.println("Test " + (i + 1) + ": " + result);
        }
    }
}
