/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	if(isSubString(br.readLine(),br.readLine())){
        		System.out.println("YES");
        	}else{
        		System.out.println("NO");
        	}
        }
    }
    
	public static boolean isSubString(String pattern, String text){
		if(pattern.length() > text.length()){
			return false;
		}
		
		int[] phash = new int[26];
		int[] hash = new int[26];
		
		for(int i = 0; i < pattern.length(); i++){
			phash[pattern.charAt(i)-97]++;
		}
		
		for(int i = 0; i < text.length(); i++){
			hash[text.charAt(i)-97]++;
			if(i >= pattern.length()){
				hash[text.charAt(i-pattern.length())-97]--;
			}
			boolean isSub = true;
			for(int j = 0; j < 26; j++){
				if(phash[j] != hash[j]){
					isSub = false;
					break;
				}
			}
			if(isSub){
				return true;
			}
		}
		//System.out.println(hash);
		return false;
	}
}
