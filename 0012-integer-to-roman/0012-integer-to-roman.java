class Solution {
    public String intToRoman(int num) {
        //mapping possible roman numeral sequence to values
        String[] rom = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] value = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder sb = new StringBuilder("");

        // iterating from largest to lowest values
        for(int i=12; i>=0; i--){
            while(num >= value[i]){
                sb = sb.append(rom[i]);
                num -= value[i];
            }
        }
        
        return sb.toString();
    }
}