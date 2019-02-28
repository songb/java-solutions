public class Strstr {

    public int strStr(final String A, final String B) {
        for(int i=0; i<=A.length()-B.length();i++){
            if(A.charAt(i) == B.charAt(0)){
                int j=1;
                for(; j<B.length(); j++){
                    if(A.charAt(i+j) != B.charAt(j))
                        break;
                }
                if(j==B.length())
                    return i;
            }
        }
        return -1;
    }

    public String reverseWords(String a) {
        String[] words = a.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=words.length-1; i>0; i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        Strstr s = new Strstr();
        s.strStr("b", "b");
    }

}
