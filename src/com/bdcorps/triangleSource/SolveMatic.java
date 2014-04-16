import java.util.Scanner;

public class SolveMatic {
  
	public static double round(double x) { 
		double place = 10;
		x = Math.round(x*place)/place; //rounds number to 1 decimal place 
		return x;
	}
	public static double inputSide () {
		Scanner in = new Scanner(System.in);
		double side = -1; //holds the side length that the user enters for the triangle
		do {
			System.out.println("Enter a side length (in units):"); //prompts for value of side length of the chosen side length
			if (in.hasNextDouble()) { //ensures that the value entered by the user is a double
				side = in.nextDouble();
				if (side<0) //checks to see if the side length the user enters is negative
					System.out.println("Error! Side length cannot be negative.");
			}
			else {
				in.nextLine(); //skips the current line of invalid input
				System.out.println("Error! Input type must be a number.");
			}

		} while (side<0); //keeps prompting and getting side length from user until side length input is valid
		return side;
	}
	public static double inputAngle () {
		Scanner in = new Scanner(System.in);
		double angle = -1; //holds the angle that the user enters for the triangle
		do {
			System.out.println("Enter an angle (in degrees):"); //prompts for value of angle of the chosen angle
			if (in.hasNextDouble()) { //ensures that the value the user enters is a double
				angle = in.nextDouble();
				if (angle<=0||angle>=180) //checks if the angle is between 0 and 180 degrees
					System.out.println("Error! Angle must be between 0 and 180 degrees.");
			}
			else {
				in.nextLine(); //skips the current line of invalid input
				System.out.println("Error! Input type must be a number.");
			}
		} while (angle<=0||angle>=180); //keeps prompting and getting angle from user until it is valid
		return angle;
	}
	
	public static int inputMenu() {
		Scanner in = new Scanner(System.in);
		int option = -1; //holds the option that the user enters for their menu choice
		do {
			//outputs menu
			System.out.println("1 - Specifications\n2 - Perimeter\n3 - Area\n4 - Reset Specifications\n5 - Exit the program\nSelect option:");
			if (in.hasNextInt()) { //checks if the value the user enters is an integer
				option = in.nextInt();
				if (option<1 || option>5) //checks if the option entered is between 1 and 5
					System.out.println("Error! Option must be 1, 2, 3, 4, or 5.");
			}
			else {
				in.nextLine(); //skips the current line of invalid input
				System.out.println("Error! Option must be 1, 2, 3, 4, or 5.");	
			}

		} while (option<1 || option>5); //keeps looping prompt until a valid option is selected
		return option;
	}

	public static String inputLetter() {
		Scanner in = new Scanner(System.in);
		String x; //a temporary variable which will store the letter that the user enters
		do {
			System.out.println("Select a field (a, b, c, A, B, C): ");
			x = in.nextLine();
			if ((!x.equals("a") && !x.equals("b") && !x.equals("c") && !x.equals("A") && !x.equals("B") && !x.equals("C"))) //checks if the value that the user enters is a valid choice
				System.out.println("Error! Input is not a valid field.");
		} while((!x.equals("a") && !x.equals("b") && !x.equals("c") && !x.equals("A") && !x.equals("B") && !x.equals("C"))); //keeps looping until a valid input is entered
		return x;
	}

	public static boolean letterUsed (String x, String[] lettersUsed) {
		boolean temp = false; //true if the letter is already used
		for (int i = 0; i<lettersUsed.length; i++) {
			if (x.equals(lettersUsed[i])) { //checks to see if the value of index i in the array is already in the array 
				temp = true;
				System.out.println("Error! This letter is already used.");
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		boolean reset = false; //to check if the user wants to rest the specifications of the triangle or to exit the prorgram
		String[] lettersUsed = new String[6]; //array that holds the letters that are already have values
		int z; //index to keep track of lettersUsed array
		double A1, B1, C1; //the angles of the first solution of the triangle
		double a1, b1, c1; //the side lengths of the first solution of the triangle
		int angleCount; //number of angles counter
		int sideCount; //number of side lengths counter
		String letter; //holds the letter that denotes the field the user wants to enter values for
		double tempS; //a temporary variable that holds the side length that the user enters
		double tempA; //a temporary variable that holds the angle that the user enters
		int menu; //a variable that holds the menu option that the user selects
		
		TriangleUnit t=new TriangleUnit(); //declares the Triangle t, which will be constructed later in the program
		do {
			do { A1 = B1 = C1 = 60;
			a1 = b1 = c1 = 3;
			angleCount = 0;
			sideCount = 0;//this block of code resets all the variables for when the program restarts
				for (int i = 0; i<lettersUsed.length;i++) //runs through the array and makes each value in the array "" 
					lettersUsed[i] = ""; 
				z = 0;
				
				do {
					do {
						letter = inputLetter(); //prompts for which field to enter a value for
					} while (letterUsed(letter, lettersUsed) == true); //checks to see if letter is already input into the program and loops back if so
					if (letter.equals("a") || letter.equals("b") || letter.equals("c")) { //checks to see if a side length letter was inputed
						tempS = inputSide(); //stores user input in temporary variable
						//the following checks to see if letter is a, b, or c and assigns value to appropriate variable
						if (letter.equals("a")){
							a1 = tempS;t.puta1(a1);}
						else if (letter.equals("b"))
							{b1 = tempS;t.putb1(b1);}
						else{
							c1 = tempS;t.putc1(c1);}sideCount++; 
						lettersUsed[z] = letter; //stores the letter into lettersUsed
						z++;
					}
					else if ((letter.equals("A") || letter.equals("B") || letter.equals("C")) && angleCount<3) { //checks to see if letter inputed is angle ltter
						tempA = inputAngle(); //stores user input in temporary variable
						//the following checks to see if letter is A, B or C and assigns value to appropriate variable
						if (letter.equals("A")){
							A1 = tempA;t.putA1(A1);}
						else if (letter.equals("B"))
						{		B1 = tempA;t.putB1(B1);
						}else{
							C1 = tempA;
							t.putC1(C1);}angleCount++;
						lettersUsed[z] = letter; //stores the letter into lettersUsed
						z++;
					}
					else
						System.out.println("Error! Cannot enter more than 3 angles."); //prevents program from getting stuck in AAA case

					System.out.print("\nsideCOunt: "+sideCount+" : angleCOunt: "+angleCount);} while(!((angleCount + sideCount == 3 && sideCount > 0) || (angleCount == 3 && sideCount == 1))); //conditions met
					if (t.getSolutions() == 0)  //checks to see if inputed values of the triangle construct a valid triangle
						{lettersUsed = new String[6]; 
						System.out.println("A triangle cannot be constructed based on these specifications.\n\nRestarting program.\n");
						}
			} while (t.getSolutions() == 0); //loops back to beginning if a triangle cannot be constructed 
		//t = new Triangle (); //Constructs triangle
				
				
				/*
				t.putA1(A1);t.putB1(B1);t.putC1(C1);
				t.puta1(a1);
				t.putb1(b1);
				t.putc1(c1);*/
			do {
				menu = inputMenu(); //prompts and gets th
				
			
				
				
				
				if (menu == 1) { //display specifications is selected
					//outputs triangle specifications
					System.out.print("sol: "+t.getSolutions());
					if (t.getSolutions() == 1) //different outputs depending on whether there is 1 or 2 solutions
						System.out.println("Solution 1:");
					System.out.println("Side 'a' is equal to "+round(t.geta1())+" units.");
					System.out.println("Side 'b' is equal to "+round(t.getb1())+" units.");
					System.out.println("Side 'c' is equal to "+round(t.getc1())+" units.");
					System.out.println("Angle 'A' is equal to "+round(t.getA1())+" degrees.");
					System.out.println("Angle 'B' is equal to "+round(t.getB1())+" degrees.");
					System.out.println("Angle 'C' is equal to "+round(t.getC1())+" degrees.\n");
					if (t.getSolutions() == 2) { //checks to see if two triangles can be created, if so the program outputs the second triangle's specifications neatly 
						System.out.println("\nSolution 2:");
						System.out.println("Side 'a' is equal to "+round(t.geta2())+" units.");
						System.out.println("Side 'b' is equal to "+round(t.getb2())+" units.");
						System.out.println("Side 'c' is equal to "+round(t.getc2())+" units.");
						System.out.println("Angle 'A' is equal to "+round(t.getA2())+" degrees.");
						System.out.println("Angle 'B' is equal to "+round(t.getB2())+" degrees.");
						System.out.println("Angle 'C' is equal to "+round(t.getC2())+" degrees.\n");
					}
				} 
				else if (menu == 2) { //display perimeter was selected
					//outputs the perimeter of the triangle
					if (t.getSolutions() == 2) //different outputs depending on whether there is 1 or 2 solutions
						System.out.println("Solution 1:");
					System.out.println("Perimeter = "+round(t.getPerimeter1())+" units\n");
					if (t.getSolutions() == 2) { //displays second perimeter if applicable
						System.out.println("Solution 2:");
						System.out.println("Perimeter = "+round(t.getPerimeter2())+" units\n");
					}
				}
				else if (menu == 3) { //display area was selected
					//outputs the area of the triangle
					if (t.getSolutions() == 2) //different outputs depending on whether there is 1 or 2 solutions
						System.out.println("Solution 1:");
					System.out.println("Area = "+round(t.getArea1())+" units^2\n");
					if (t.getSolutions()== 2) { //displays the second area if applicable
						System.out.println("Solution 2:");
						System.out.println("Area = "+round(t.getArea2())+" units^2\n");
					}
				}
				else if (menu == 5) //exit program was selected
					reset = false; 
				else { //reset specifications was selected
					System.out.println("Restarting program.\n");
					reset=true; 
				}
			} while(menu>=1 && menu<=3); //loops back if display specifications, perimeter, or area selected
		} while (reset); //loops back to the beginning if rest specifications was selected
		System.out.println("Program terminated.");
	}
}
