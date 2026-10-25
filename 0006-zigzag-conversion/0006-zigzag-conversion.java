class Solution {
    public String convert(String s, int numrows) {
        //StringBuilder for each rows 
       StringBuilder[] sb = new StringBuilder[numrows];
        for(int i=0;i<numrows;i++){
            sb[i] = new StringBuilder();
        }
        char[] c = s.toCharArray();
        int n = c.length;
        int cur = 0; // to track characters from 0 to the last character in the CharArray

        while(cur<n){
            for(int i=0;i<numrows && cur<n;i++){
                sb[i].append(c[cur++]);//downward appending to rows:i
            }
            for(int i=numrows-2;i>0 && cur<n;i--){
                sb[i].append(c[cur++]);//diagonal uppward appending from numrows-2 to >0
            }
        }
        //appending seperate rows of Sb into a single Stringbuilder(sb[0]) and returning as String
        for(int i=1;i<numrows;i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString(); 
    }
}