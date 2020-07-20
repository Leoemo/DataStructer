public class strToInt {
    public static void main(String[] args) {
        String s = "-1234";
        System.out.println(Integer.valueOf(s));

        int solve = solve(s);
        System.out.println(solve);
    }


    public static int solve(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int result = 0;
        char[] c = s.toCharArray();
        int flag = 0;
        if (c[0] == '+')
            flag = 1;
        if (c[0] == '-')
            flag = 2;
        int start = flag == 0 ? 0 : 1;
        int end = len;
        for (int i = start; i < end; i++) {
            if (Character.isDigit(c[i])) {
                int temp = c[i] - '0';
                result = result * 10 + temp;
            } else
                return 0;
        }

        return flag == 2 ? -result : result;
    }
}
