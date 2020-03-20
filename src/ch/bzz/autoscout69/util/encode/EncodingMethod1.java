package ch.bzz.autoscout69.util.encode;

public class EncodingMethod1 implements EncodingMethod{

	@Override
	public String encode(String text) {
		String secretAddon = "234b80lbb3ll1bj2bfx79gxxh0kb0k86341";
		String newText = "";
		for(int i = 0; i < text.length(); i++) {
			int c = text.charAt(i);
			int secretChar = secretAddon.getBytes()[i>=secretAddon.length()?i-secretAddon.length():i];
			newText = newText + ((c*text.length()+secretChar)/(i+1)) + (i % 6 == 0 ? "-" : String.valueOf((char)c));
		}
		return newText;
	}

}
