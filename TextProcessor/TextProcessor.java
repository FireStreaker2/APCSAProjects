public class TextProcessor {

	public static void main(String[] args) {
		System.out.println(isLowerCase('c'));
		System.out.println(toUpperCase('a'));
		System.out.println(toUpperCase("hE iS COOl"));
		System.out.println(compareToIgnoreCase("hello", "hellos"));
	}
	
	public static boolean isLowerCase(char c) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		for (int i = 0; i < alphabet.length(); i++) {
			if (alphabet.charAt(i) == c) {
				return true;
			}
		}
		
		return false;
	}
	
	public static char toUpperCase(char c) {
		String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for (int i = 0; i < lowerCaseAlphabet.length(); i++) {
			if (lowerCaseAlphabet.charAt(i) == c) {
				return upperCaseAlphabet.charAt(i);
			}
		}
		
		return c;
	}
	
	public static String toUpperCase(String s) {
		String result = "";
		
		for (int i = 0; i < s.length(); i++) {
			result += toUpperCase(s.charAt(i));
		}
			
		return result;
	}
	
	
	public static int compareToIgnoreCase(String s, String t) {
		int smallest = 0;
		
		if (s.length() > t.length()) smallest = t.length();
		else smallest = s.length();
		
		
		for (int i = 0; i < smallest; i++) {
			if (s.charAt(i) > t.charAt(i)) {
				return 1;
			} else if (s.charAt(i) < t.charAt(i)) {
				return -1;
			}
		}
		
		if (s.length() > t.length()) return 1;
		
		if (s.length() < t.length()) return -1;
		
		return 0;
	}

}
