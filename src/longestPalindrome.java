import java.util.Arrays;

public class longestPalindrome {
    /**
     * 最⻓回⽂⼦串
     */


    public static void main(String[] args) {
        String s = "abcbaabcabba";
        int[] check = check(s);
        System.out.println(Arrays.toString(check));
    }


    public static int[] check(String s) {
        int len = s.length();
        int mid = len / 2;
        //左递归
        int maxLength = 0;
        int index = 0;
        while (mid > 0) {
            int left = mid - 1;
            int right = mid + 1;

            int count = 0;
            while (left >= 0 && right < len) {
                if(s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                }
                else
                    break;
            }
            if((2*count+1)>maxLength){
                maxLength = 2*count+1;
                index = mid;
            }
            mid--;
        }


        mid = len / 2;
        //右递归
        int R_maxLength = 0;
        int R_index = 0;

        while (mid <len-1) {
            int left = mid - 1;
            int right = mid + 1;

            int count = 0;
            while (left >= 0 && right < len) {
                if(s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                }
                else
                    break;
            }
            if((2*count+1)>R_maxLength){
                R_maxLength = 2*count+1;
                R_index = mid;
            }
            mid++;
        }

        return new int[]{index,maxLength,R_index,R_maxLength};

    }
}
