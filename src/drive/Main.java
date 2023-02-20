package drive;

public class Main
{
	public static void main(String[] args) {
		String output = PosInt2Bin(35);//100011
		System.out.println(output);
		String flipped = Flip(output);
		System.out.println(flipped);
		String complimentary = Increment(flipped);
		System.out.println(complimentary);
		System.out.println(TwosComplimentaryConversion(-35));
		System.out.println(TwosComplimentaryConversion(35));
	}

	public static String PosInt2Bin(int input){
		String res = "";
		while(input > 1){
			res = input % 2 + res;
			input = input / 2;
		}
			res = input % 2 + res;
		return res;
	}

	public static String Flip(String str){
		String output = "";
		for(int i = 0; i < str.length(); i++){
			char curr = str.charAt(i);
			if (curr == '1'){
				output += '0';
			} else {
				output += '1';
			}
		}
		return output;
	}

	public static String Increment(String input){
		int carrier = 0;
		String output = "";
		for(int i = input.length() - 1; i >= 0; i--){
			char curr = input.charAt(i);
			if (i == input.length() - 1){
				if (curr == '0'){
					carrier = 0;
					output = '1' + output;
				} else {
					carrier = 1;
					output = '0' + output;
				}
			} else {
				if (curr == '0' && carrier == 0){
					output = '0' + output;
					carrier = 0;
				} else if (curr == '0' && carrier == 1){
					output = '1' + output;
					carrier = 0;
				} else if (curr == '1' && carrier == 0){
					output = '1' + output;
					carrier = 0;
				} else {
					output = '0' + output;
					carrier = 1;
				}
			}
		}
		if (carrier == 1){
			output = carrier + output;
		}
		return output;
	}
	
	public static String TwosComplimentaryConversion(int val) {
		char pad = '0';
		String output = "";
		if (val > 0) {
			output = PosInt2Bin(val);
		} else {
			pad = '1';
			output = Increment(Flip(PosInt2Bin(val * -1)));
		}
		int len = output.length();
		int cap = 2;
		while(len > cap) {
			cap *= 2;
		}
		for(int i = len; i < cap; i++) {
			output = pad + output;
		}
		return output;
	}
}
