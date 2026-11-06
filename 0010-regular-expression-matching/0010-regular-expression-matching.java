class Solution {
    public boolean isMatch(String s, String p) {
        int t = s.length(), q = p.length();
        Boolean[][] dp = new Boolean[t+1][q];// additional space for dealing with situation where String runs out and pattern p is left out
        return isMatch(s, p, 0, 0, dp);
    }
    private boolean isMatch(String s, String p, int i, int j, Boolean[][] dp){
        //breaking condition for recurssion
        if(i == s.length() && j == p.length()){
            return true;
        }
        if(j>=p.length()){
            return false;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean currentMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean nextIsStar = j+1 < p.length() && p.charAt(j+1) == '*';
        boolean isMatch;

        if(currentMatch){
            if(nextIsStar){
                isMatch = isMatch(s,p,i,j+2,dp) // not taking the star i.e * is 0 characters
                    || isMatch(s,p,i+1,j,dp); // considering the * and moving string index to check if more charcters in String needs to be accomodated in the *("Or more") 
            }else{
                isMatch = isMatch(s,p,i+1,j+1,dp);//comparison moves forward
            }
        }else{//if characters don't match or when string ran out before paattern
            if(nextIsStar){// if string ran out, here it makes sure that left pattern is all *(zero character situation applied)
                isMatch = isMatch(s,p,i,j+2,dp); // not taking the star i.e * is 0 characters
            }else{// nothing applies and every condotion fails
                isMatch = false;
            }
        }
        dp[i][j] = isMatch;
        return isMatch;
    }
}