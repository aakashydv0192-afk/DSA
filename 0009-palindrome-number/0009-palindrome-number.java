class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x>0 && x%10==0 )){
            return false;
        }
        int org = x;
        int y = 0;
        while( x != 0){
        y=y*10+x%10;
        x=x/10;
        }

         return org == y;
    }
}