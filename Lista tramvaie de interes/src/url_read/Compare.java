package url_read;

public class Compare {
	public static int stringCompare(String str1, String str2) //Functie cu care filtram tramvaiele dupa id. 2 intrari string
    {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
  
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);
  
            if (str1_ch != str2_ch) {
                return 0;
            }            
        }
        return 1;
    }

}
