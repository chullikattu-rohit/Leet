class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int nd = 0; // non digit flag: becomes 1 when first digit is read to break when any non digit is read after
        int sign = 1; // to preserve the sign before any digit into the res
        int n = s.length();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == ' ' || c == '+'){
                if(nd == 1)
                    break;
                else if(c == '+')
                    nd = 1;
                continue;
            }
            if(c == '-'){
                if(nd == 1){
                    break;}
                sign = -1;
                nd = 1;
                continue;
            }
            if( c-'0' <10 && c-'0' >=0){
                res = (res*10) + (c-'0');
                nd = 1;
                // rounding
                if(sign==1 && res>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(sign==-1 && -res<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                continue;
            }
            break;
        }

        // adding the sign to the result
        res *= sign; 

        return (int) res;
    }
}