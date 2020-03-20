package ch.bzz.autoscout69.util.encode;

public class EncodingMethod2 implements EncodingMethod {

	@Override
	public String encode(String text) {
		String newText = "123mk078sfdn";
		for(int i = 0; i < text.length(); i++) {
			int c = text.charAt(i);
			newText = newText + ((char)c) + ((char)c*i) + ((char)c*text.length()+c);
		}
		return newText;
	}

}
