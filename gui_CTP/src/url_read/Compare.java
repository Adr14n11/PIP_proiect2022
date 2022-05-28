package url_read;

/**
 * It compares two strings and returns 1 if they are equal, 0 otherwise
 */
public class Compare {
	/**
	 * It compares two strings and returns 1 if they are equal, 0 otherwise
	 *
	 * @param str1 The first string to be compared.
	 * @param str2 the string we want to compare with
	 * @return 1 if the strings are equal, 0 otherwise.
	 */
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