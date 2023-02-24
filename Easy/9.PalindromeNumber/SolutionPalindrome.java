class Solution {
    public boolean isPalindrome(int x) {
        boolean palindrome=true;
        char [] chars = String.valueOf(x).toCharArray();
        for(int i=0;i<chars.length;i++)
        {
            if(chars[i]==chars[(chars.length - 1)-i])
            {
            }else{
                palindrome=false;
            }
            
        }
        
        return palindrome;
    }
}