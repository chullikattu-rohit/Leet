class Solution {
    public int reverse(int x) {
        long rx = 0;
        // reversing the x into rx
        while(x != 0){
            rx = (rx * 10) + (x % 10);
            x /= 10;
        }
        // checking if the long value is actually gretaer than the Integer boundaries
        if(rx > Integer.MAX_VALUE || rx < Integer.MIN_VALUE)
            return 0;
        return (int) rx;
    }
}