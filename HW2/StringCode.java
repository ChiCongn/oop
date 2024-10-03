package HW2;
import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A run is a series of adjacent chars that are the same.
	 * @param str a string
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int maxLength = 0;
		int len = str.length();
		int i = 1;
		while (i < len) {
			int currentLen = 1;
			while (i < len && str.charAt(i - 1) == str.charAt(i)) {
				currentLen++;
				i++;
			}
			maxLength = Math.max(maxLength, currentLen);
			i++;
		}
		return maxLength;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str a string
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder res = new StringBuilder();
		int len = str.length();
		if (len == 0) return str;
		for (int i = 0; i < len - 1; i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				char next = str.charAt(i + 1);
				for (int j = 0; j < (c - '0'); j++) {
					res.append(next);
				}
			} else {
				res.append(c);
			}
		}
		if (!Character.isDigit(str.charAt(len - 1))){
			res.append(str.charAt(len - 1));
		}
		return res.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if (a == null || b == null) {
			throw new NullPointerException("String is null");
		}
		if (len > a.length() || len > b.length()) return false;
		HashSet<String> substringsA = new HashSet<>();

		for (int i = 0; i <= a.length() - len; i++) {
			substringsA.add(a.substring(i, i + len));
		}
		for (int i = 0; i <= b.length() - len; i++) {
			String substringB = b.substring(i, i + len);
			if (substringsA.contains(substringB)) {
				return true;
			}
		}
		return false;
	}
}
