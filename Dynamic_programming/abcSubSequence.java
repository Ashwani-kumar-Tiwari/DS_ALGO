public class abcSubSequence {
    
    public static int countABCSubSequence(String str){
        int a_count = 0;
        int b_count = 0;
        int c_count = 0;

        for(int i = 0;i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == 'a'){
                a_count = 2 * a_count + 1;
            } else if (ch == 'b'){
                b_count = 2 * b_count + a_count;
            } else {
                c_count = 2 * c_count + b_count;
            }
        }

        return c_count;
    }
    public static void main(String[] args){
        String str = "abcabc";
        int res = countABCSubSequence(str);
        System.out.println(res);
    }
}
