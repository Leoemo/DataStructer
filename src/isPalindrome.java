public class isPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean check = check(s);
        System.out.println(check);
    }

    public static boolean check(String str) {
        if (str.length() == 0) {
            return true;
        }
        int l = str.length();
        int left = 0;
        int right = l - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            if (Character.toUpperCase(str.charAt(left)) != Character.toUpperCase(str.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
