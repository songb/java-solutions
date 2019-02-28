public class RegExp {

    char[] sca;
    char[] pca;

    boolean chart[][];


    public boolean isMatch(String s, String p) {
        sca = s.toCharArray();
        pca = p.toCharArray();
        chart = new boolean[sca.length + 1][pca.length + 1];
        chart[0][0] = true;
        for (int i = 1; i <= sca.length; i++) {
            chart[i][0] = false;
        }
        for (int i = 1; i <= pca.length; i++) {
            if (pca[i - 1] == '*')
                if (i > 1)
                    chart[0][i] = chart[0][i - 2];
                else
                    chart[0][i] = true;
        }

        for (int i = 1; i <= sca.length; i++) {
            for (int j = 1; j <= pca.length; j++) {
                if (sca[i - 1] == pca[j - 1] || pca[j - 1] == '.') {
                    chart[i][j] = chart[i - 1][j - 1];
                } else if (pca[j - 1] == '*') {
                    if(pca[j-2]=='.' || pca[j-2]==sca[i-1]){
                        chart[i][j] = chart[i][j-2]||chart[i-1][j];
                    }else{
                        chart[i][j] = chart[i][j-2];
                    }
                }else{
                    chart[i][j]=false;
                }
            }
        }

        return chart[sca.length][pca.length];
    }

    public static void main(String[] args) {
        RegExp r = new RegExp();
        boolean b = r.isMatch("aa", "a*");
    }
}
