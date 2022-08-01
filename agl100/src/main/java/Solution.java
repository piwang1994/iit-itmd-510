
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while (left<right){
            if (notYuan(chars[left])){
                left++;
            }
            else if(notYuan(chars[right])){
                right--;
            }
            else {
                char tmp=chars[left];
                chars[left]=chars[right];
                chars[right]=tmp;
                left++;
                right--;
            }

        }
        return new String(chars);
    }

    public boolean notYuan(char c){
        return  c != 'a' &&
                c != 'A' &&
                c != 'e' &&
                c != 'E' &&
                c != 'i' &&
                c != 'I' &&
                c != 'o' &&
                c != 'O' &&
                c != 'u' &&
                c != 'U';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.reverseVowels("aeiou");
        System.out.println(s);
    }
}