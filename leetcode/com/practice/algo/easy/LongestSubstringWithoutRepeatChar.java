import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestSubstringWithoutRepeatChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		try {
		  BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			String s = bfr.readLine();
			LongestSubstringWithoutRepeatChar obj =new LongestSubstringWithoutRepeatChar();
			obj.lengthOfLongestSubstring(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
   	public int lengthOfLongestSubstring(String s) {
		int slen = s.length();

        
        if(slen == 0 ) return 0;
		boolean[] charExist = new boolean[256];
		int maxlen = 1;
		int len = 1;
		charExist[s.charAt(0)] = true;
		for(int i=0,j=i+1;i< slen-1&& j< slen; ) {
			if(!charExist[s.charAt(j)]) {                
				charExist[s.charAt(j++)] = true;
				len++; 
				if(len > maxlen)
					maxlen= len;
			} else {                
				charExist[s.charAt(i)] = false;
				i++;
				len--;
			}  

		}
		//System.out.println(maxlen);
		return maxlen;
	}


}
