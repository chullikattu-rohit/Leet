class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, o = m+n;
        int i=0, j=0, k=0;
        int[] a = new int[o];
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                a[k] = nums1[i++];
            }else{
                a[k] = nums2[j++];
            }k++;
        }
        while(i<m){
            a[k] = nums1[i++];k++;
        }
        while(j<n){
            a[k] = nums2[j++];k++;
        }
        int mid = o/2;
        double ans;
        if(o%2==1)
            ans = a[mid];
        else
            ans = (double)(a[mid] + a[mid-1]) / 2;
        return ans;
    }
}