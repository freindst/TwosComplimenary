package drive;

/******************************************************************************

Online Java Compiler.
Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
public static void main(String[] args) {
System.out.println("Hello World");
String output = PosInt2Bin(35);//100011
System.out.println(output);
String flipped = Flip(output);
System.out.println(flipped);
String complimentary = Increment(flipped);
System.out.println(complimentary);
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
//System.out.println(i);
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
}
