public class AtoI {

    public int atoi(final String A) {
        String l = A;
        int sign = 1;
        if (A.charAt(0) == '-' || A.charAt(0) == '+') {
            if (A.charAt(0) == '-') sign = -1;

            l = A.substring(1);
        }

        int r = 0;
        char[] ca = l.toCharArray();
        for (char c : ca) {
            if (c <= '9' && c >= '0') {
                int n = c - '0';
                if(r>Integer.MAX_VALUE/10){
                    if(sign==1) return Integer.MAX_VALUE;
                    return Integer.MIN_VALUE;
                }
                r = r * 10 + n;

            }else {
                return sign * r;
            }
        }
        return sign * r;
    }

    public static void main(String[] args) {
        AtoI a = new AtoI();
        int p = a.atoi("5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393");
        System.out.println(p);
    }

}
