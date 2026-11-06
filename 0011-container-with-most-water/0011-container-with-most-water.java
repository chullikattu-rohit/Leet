class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length-1;

        while(i < j){
            int cur =(height[i] > height[j])? (height[j] * (j-i)):(height[i] * (j-i));// finding the lowest height among i th and j th height and multiplying by distance j-i
            if(cur > max){
                max = cur;
            }
            //updating the lower height among two
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}