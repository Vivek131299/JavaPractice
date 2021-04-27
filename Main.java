public class Main {
	public static void main(String[] args) {
		final int myNum = 15; // you can add the final keyword if you don't want others (or yourself) to
								// overwrite existing values (this will declare the variable as "final" or
								// "constant", which means unchangeable and read-only)
		String name = "John";
		/*
		 * The String type is so much used and integrated in Java, that some call it
		 * "the special ninth type". A String in Java is actually a non-primitive data
		 * type, because it refers to an object. The String object has methods that are
		 * used to perform certain operations on strings.
		 */

		Long myLongNum = 15000000000L; // Note that you should end the value with an "L"
		float myFloatNum = 5.75f; // Note that you should end the value with an "f"
		double myDoubleNum = 19.99d; // Note that you should end the value with a "d"
		/*
		 * Use float or double? The precision of a floating point value indicates how
		 * many digits the value can have after the decimal point. The precision of
		 * float is only six or seven decimal digits, while double variables have a
		 * precision of about 15 digits. Therefore it is safer to use double for most
		 * calculations.
		 */

		float f1 = 35e3f;
		double d1 = 12E4d;
		/*
		 * Scientific Numbers A floating point number can also be a scientific number
		 * with an "e" to indicate the power of 10:
		 */

		char grade = 'B';
		/*
		 * The char data type is used to store a single character. The character must be
		 * surrounded by single quotes, like 'A' or 'c'
		 */
		char a = 65; // Alternatively, you can use ASCII values to display certain characters
		char b = '\u0044'; // Alternatively, you can use unicode values to display certain characters
		System.out.println("Hello World from " + name);
		name = name + "Tim";
		/*
		 * In JAVA, String is immutable, we can delete characters out of a string but
		 * that's not strictly true. This means you can't change a String after it's
		 * created. Instead, what happens is a new String is created.
		 */
		System.out.println("This is appended string to variable name: " + name); // output: JohnTim15
		name = name + myNum; // Adding String and int, number gets appended after string as datatype of
								// variable 'name' is String.
		System.out.println("Value of String after adding int to it: " + name);
		System.out.println("Value of final int myNum variable = " + myNum);
		System.out.println("Value of long myLongNum variable = " + myLongNum);
		System.out.println("Value of float myFloatNum variable = " + myFloatNum);
		System.out.println("Value of double myDoubleNum variable = " + myDoubleNum);
		System.out.println("Value of float scientific number f1 variable = " + f1);
		System.out.println("Value of double scientific number d1 variable = " + d1);
		System.out.println("Value of char grade variable = " + grade);
		System.out.println("Value of char a variable by using ASCII value = " + a);
		System.out.println("Value of char b variable by using unicode value = " + b);

	}
}