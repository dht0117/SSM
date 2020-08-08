package leetcode;

public class leetcode22 {
    public static void main(String[] args) {
        String a="abcda";
        String b="ll";
        System.out.println(a.charAt(2));
        Solution1 ss = new Solution1();
        int m=ss.strStr(a,b);
        System.out.println(m);
    }
}
class Solution1 {
    public int strStr(String haystack, String needle) {
        int m=0;
        if (needle==null) {
            m=0;
        }
        int N=haystack.length();
        char s=needle.charAt(0);
        int i=0;
        while (i<N-1){
            if (s==haystack.charAt(i)) {
                m=i;
                break;
            }
            else {
                i++;

            }
        }
        System.out.println(i);
        while (i==N-1){
            m=-1;
            break;
        }

        return m;
    }
}