// ## Q.17) You are given two strings s1 and s2. Find the minimum number of operations required to convert s1 to s2.

// - Permitted Operations:

// 1: Insert a character

// 2: Delete a character

// 3: Replace a character

// 4: Strings s1 and s2 are composed of only lowercase English characters.

// Example:-

// - Input: 

// s1: "hello"

// s2: "seldom"

// - Output:

// Result: 3

// - Explanation:

// hello → sello (replace h with s)

// sello → seldo (replace l with d)

// seldo → seldom (insert m at end)

public class day17_Nikunj {

	public static void main(String[] args) {
		String word1="horse";
		String word2="rose";
		System.out.println(minDistance(word1, word2));
	}

	 public static int minDistance(String word1, String word2) {
	        int m = word1.length();
	        int n = word2.length();
	        
	        int[][] cost = new int[m + 1][n + 1];
	        for(int i = 0; i <= m; i++)
	            cost[i][0] = i;
	        for(int i = 1; i <= n; i++)
	            cost[0][i] = i;
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                if(word1.charAt(i) == word2.charAt(j))
	                    cost[i + 1][j + 1] = cost[i][j];
	                else {
	                    int a = cost[i][j];
	                    int b = cost[i][j + 1];
	                    int c = cost[i + 1][j];
	                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
	                    cost[i + 1][j + 1]++;
	                }
	            }
	        }
	        return cost[m][n];
	    }
}
