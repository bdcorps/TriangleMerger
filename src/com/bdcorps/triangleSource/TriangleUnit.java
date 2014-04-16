import java.awt.List;
import java.util.ArrayList;

public class TriangleUnit {
	private double A, B, C = 60; // these fields represent the angles of first
									// solution of the triangle
	private double A2, B2, C2 = 60; // these fields represent the angles of the
									// second solution of the triangle
	private double a, b, c = 3; // these fields represent the sides of first
								// solution of the triangle
	private double a2, b2, c2 = 3; // these fields represent the sides of second
									// solution of the triangle
	private ArrayList<String> lettersUsed = new ArrayList<String>();
	private int angleCount = 0;
	private int sideCount = 0;
	private int solutions = 1;

	public int getSolutions() {
		return solutions;
	}

	public void setSolutions(int solutions) {
		this.solutions = solutions;
	}

	public TriangleUnit() {
		// the instance fields of the first solution are set to their
		// corresponding parameter values
		A = 60;
		B = 60;
		C = 60;
		a = 3;
		b = 3;
		c = 3;

		
		
		/*
		 * if (a!=3 && b!=3 && c!=3) //SSS case SSS(); else if ((A1!=60 &&
		 * B1!=60 && C1==60)||(A1!=60 && B1==60 && C1!=60)||(A1==60 && B1!=60 &&
		 * C1!=60))//AAS or ASA case AASorASA(); else if (A1!=60 && B1!=60 &&
		 * C1!=60) { //AAAS case A1 = 60; //sets one angle to zero, then solves
		 * as an AAS case AASorASA(); } else if
		 * ((A!=60&&a==3)||(B1!=60&&b==3)||(C1!=60&&c==3)) //SAS case SAS();
		 * else //SSA case SSA();
		 */
	}

	private void classifySolve() {
		angleCount = 0;
		sideCount = 0;
		boolean contained = true;
		System.out.print(lettersUsed.toString());
		for (int i = 0; i < lettersUsed.size(); i++) {
			String letter1 = lettersUsed.get(i);
			if (Character.isUpperCase(letter1.charAt(0))) {
				angleCount++;
			} else if (!Character.isUpperCase(letter1.charAt(0))) {
				sideCount++;
			}

			for (int j = 0; j < lettersUsed.size(); j++) {
				String letter2 = lettersUsed.get(j);
				if (j!=i){

					// check containment
					//quits if contained becomes false
					if (contained){
				if (letter2.toUpperCase().equals(letter1.toUpperCase())) {
					contained = false;
				} else {
					contained = true;
				}}}
			}
		}

		if (sideCount == 3) {
			SSS();
		} else if (sideCount == 2 && angleCount == 1) {
			if (contained) {
			SAS();
			} else {
				SSA();
			}
		} else if (sideCount == 1 && angleCount == 2) {
			AASorASA();
		}
		solutions = solutions(a, b, c, A, B, C); 
	}

	public double getA1() {
		return A;
	}

	public double getB1() {
		return B;
	}

	public double getC1() {
		return C;
	}

	public double geta1() {
		return a;
	}

	public double getb1() {
		return b;
	}

	public double getc1() {
		return c;
	}

	public double getA2() {
		return A2;
	}

	public double getB2() {
		return B2;
	}

	public double getC2() {
		return C2;
	}

	public double geta2() {
		return a2;
	}

	public double getb2() {
		return b2;
	}

	public double getc2() {
		return c2;
	}

	public void putA1(double x) {
		A = x;
		lettersUsed.add("A");
		classifySolve();
	}

	public void putB1(double x) {
		B = x;
		lettersUsed.add("B");
		classifySolve();
	}

	public void putC1(double x) {
		C = x;
		lettersUsed.add("C");
		classifySolve();
	}

	public void puta1(double x) {
		a = x;
		lettersUsed.add("a");
		classifySolve();
	}

	public void putb1(double x) {
		b = x;
		lettersUsed.add("b");
		classifySolve();
	}

	public void putc1(double x) {
		c = x;
		lettersUsed.add("c");
		classifySolve();
	}

	public void putA2(double x) {
		A2 = x;
	}

	public void putB2(double x) {
		B2 = x;
	}

	public void putC2(double x) {
		C2 = x;
	}

	public void puta2(double x) {
		a2 = x;
	}

	public void putb2(double x) {
		b2 = x;
	}

	public void putc2(double x) {
		c2 = x;
	}

	public void AASorASA() {
		// calculates the remaining angle
		if (lettersUsed.indexOf("A") == -1)
			A = 180 - B - C;
		else if (lettersUsed.indexOf("B") == -1)
			B = 180 - A - C;
		else
			C = 180 - A - B;
		// calculates the other two sides using the sine law twice
		if (lettersUsed.indexOf("a") == -1) {
			b = Math.sin(Math.toRadians(B)) * (a / Math.sin(Math.toRadians(A)));
			c = Math.sin(Math.toRadians(C)) * (a / Math.sin(Math.toRadians(A)));
		} else if (lettersUsed.indexOf("b") == -1) {
			a = Math.sin(Math.toRadians(A)) * (b / Math.sin(Math.toRadians(B)));
			c = Math.sin(Math.toRadians(C)) * (b / Math.sin(Math.toRadians(B)));
		} else {
			b = Math.sin(Math.toRadians(B)) * (c / Math.sin(Math.toRadians(C)));
			a = Math.sin(Math.toRadians(A)) * (c / Math.sin(Math.toRadians(C)));
		}
	}

	public void SAS() {
		// finds out the remaining side of the triangle
		if (lettersUsed.indexOf("a") == -1)
			a = Math.sqrt(b * b + c * c - 2 * b * c
					* Math.cos(Math.toRadians(A)));
		if (lettersUsed.indexOf("b") == -1)
			b = Math.sqrt(a * a + c * c - 2 * a * c
					* Math.cos(Math.toRadians(B)));
		if (lettersUsed.indexOf("c") == -1)
			c = Math.sqrt(a * a + b * b - 2 * a * b
					* Math.cos(Math.toRadians(C)));
		// calculates the remaining two angles of the triangle using cosine law
		// then triangle sum law
		// not in an else-if structure because more than 1 case can be valid
		if (lettersUsed.indexOf("A") != -1) {
			B = Math.toDegrees(Math
					.acos(((a * a + c * c - b * b) / (2 * a * c))));
			C = 180 - A - B;
		}
		if (lettersUsed.indexOf("B") != -1) {
			C = Math.toDegrees(Math
					.acos(((a * a + b * b - c * c) / (2 * a * b))));
			A = 180 - B - C;
		}
		if (lettersUsed.indexOf("C") != -1) {
			A = Math.toDegrees(Math
					.acos(((b * b + c * c - a * a) / (2 * b * c))));
			B = 180 - A - C;
		}
	}

	public void SSA() {
	
		double sideUnknown, sideKnown, sideKnown2; // variables that store the
													// unknown side, known side,
													// and second known side of
													// the triangle
		double angleKnown, angleUnknown, angleUnknown2; // variables that store
														// the known angle,
														// unknown angle, and
														// second unknown angle
														// of the triangle
		double angleUnknownA, angleUnknown2A, sideUnknownA; // variables that
															// store the unknown
															// angle, second
															// unknown angle,
															// and unknown side
															// of the ambiguous
															// case
		double ratio; // a variable that holds the sine ratio which helps when
						// using the sine law
		// the following selection structure initializes the fields of the
		// triangles to the variables declared in the beginning of the method
		if ((lettersUsed.indexOf("a") != -1)&&(lettersUsed.indexOf("A") != -1)) { // a and A are given
			sideKnown = a;
			angleKnown = A;
			a2 = sideKnown;
			A2 = angleKnown;
			if ((lettersUsed.indexOf("b") != -1)) {
				sideKnown2 = b;
				b2 = sideKnown2;
			} else {
				sideKnown2 = c;
				c2 = sideKnown2;
			}
		} else if ((lettersUsed.indexOf("b") != -1) && (lettersUsed.indexOf("B") != -1)) { // b and B are given
			sideKnown = b;
			angleKnown = B;
			b2 = sideKnown;
			B2 = angleKnown;
			if ((lettersUsed.indexOf("a") != -1)) {
				sideKnown2 = a;
				a2 = sideKnown2;
			} else {
				sideKnown2 = c;
				c2 = sideKnown2;
			}
		} else { // c and C are given
			sideKnown = c;
			angleKnown = C;
			c2 = sideKnown;
			C2 = angleKnown;
			if ((lettersUsed.indexOf("b") != -1)) {
				sideKnown2 = b;
				b2 = sideKnown2;
			} else {
				sideKnown2 = a;
				a2 = sideKnown2;
			}
		}
		// performs calculations to solve the unknown sides and angles of the
		// first solution
		ratio = Math.sin(Math.toRadians(angleKnown)) / sideKnown;
		angleUnknown = Math.toDegrees(Math.asin(ratio * sideKnown2));
		angleUnknown2 = 180 - angleUnknown - angleKnown;
		sideUnknown = Math.sin(Math.toRadians(angleUnknown2)) / ratio;
		// performs calculations to solve the unknown sides and angles of the
		// second solution (even if the triangle created is non-existent)
		angleUnknownA = 180 - Math.toDegrees(Math.asin(ratio * sideKnown2));
		angleUnknown2A = 180 - angleUnknownA - angleKnown;
		sideUnknownA = Math.sin(Math.toRadians(angleUnknown2A)) / ratio;
		// the temporary variables are then re-assigned to their appropriate
		// instance fields
		if ((lettersUsed.indexOf("a") != -1) && (lettersUsed.indexOf("A") != -1)) {
			if ((lettersUsed.indexOf("b") == -1)) { // acA was initially given
				b = sideUnknown;
				C = angleUnknown;
				B = angleUnknown2;
				b2 = sideUnknownA;
				C2 = angleUnknownA;
				B2 = angleUnknown2A;
			} else { // abA was initially given
				c = sideUnknown;
				B = angleUnknown;
				C = angleUnknown2;
				c2 = sideUnknownA;
				B2 = angleUnknownA;
				C2 = angleUnknown2A;
			}
		} else if ((lettersUsed.indexOf("b") != -1) && (lettersUsed.indexOf("B") != -1)) {
			if ((lettersUsed.indexOf("a") == -1)) { // bcB was initally given
				a = sideUnknown;
				C = angleUnknown;
				A = angleUnknown2;
				a2 = sideUnknownA;
				C2 = angleUnknownA;
				A2 = angleUnknown2A;
			} else { // baB was initially given
				c = sideUnknown;
				A = angleUnknown;
				C = angleUnknown2;
				c2 = sideUnknownA;
				A2 = angleUnknownA;
				C2 = angleUnknown2A;
			}
		} else if ((lettersUsed.indexOf("c") != -1) &&(lettersUsed.indexOf("C") != -1)) {
			if ((lettersUsed.indexOf("a") == -1)) { // cbC was initially given
				a = sideUnknown;
				B = angleUnknown;
				A = angleUnknown2;
				a2 = sideUnknownA;
				B2 = angleUnknownA;
				A2 = angleUnknown2A;
			} else { // caC was initially given
				b = sideUnknown;
				A = angleUnknown;
				B = angleUnknown2;
				b2 = sideUnknownA;
				A2 = angleUnknownA;
				B2 = angleUnknown2A;
			}
		}
		if (solutions == 1) { // if only 1 solution exists, all the values
								// calculated for the 2nd solution are reset
			A2 = 60;
			B2 = 60;
			C2 = 60;
			a2 = 3;
			b2 = 3;
			c2 = 3;
		}
	}

	public void SSS() {

		A = Math.toDegrees(Math.acos(((b * b + c * c - a * a) / (2 * b * c))));
		B = Math.toDegrees(Math.acos(((a * a + c * c - b * b) / (2 * a * c))));
		C = Math.toDegrees(Math.acos(((a * a + b * b - c * c) / (2 * a * b))));

	}

	public int solutions(double a, double b, double c, double A, double B,
			double C) {
		int temp = 1; // variable that stores number of solutions (default is 1)
		double h; // variable which will hold the height of the triangle
		double s1 = 3, s2 = 3, angle = 3; // variables which will hold side 1,
											// side 1, and an angle which will
											// be used to determine solution
											// variance in SSA cases
		// the following calculates the amount of angles and sides specified by
		// user in parameter

		if (angleCount == 2 && A + B + C >= 180) // checks if there are no 2
													// obtuse angles, no 2 right
													// angles, and sum of 2
													// angles less than 180 when
													// 2 angles are given
			temp = 0;
		if (angleCount == 3 && A + B + C != 180) // checks whether the the
													// angles add up to 180 when
													// 3 are given
			temp = 0;
		else if (sideCount == 2) { // 2 side lengths are given
			// the following sets s1, s2, and angle to certain values to
			// determine if there are 0, 1, or 2 solutions in a SSA case
			if ((lettersUsed.indexOf("a") != -1) && (lettersUsed.indexOf("b") != -1) && (lettersUsed.indexOf("A") != -1)) { // abA
				s1 = a;
				s2 = b;
				angle = A;
			} else if ((lettersUsed.indexOf("b") != -1) &&(lettersUsed.indexOf("c") != -1) && (lettersUsed.indexOf("B") != -1)) { // bcB
				s1 = b;
				s2 = c;
				angle = B;
			} else if ((lettersUsed.indexOf("c") != -1) && (lettersUsed.indexOf("a") != -1)&& (lettersUsed.indexOf("C") != -1)) { // caC
				s1 = c;
				s2 = a;
				angle = C;
			} else if ((lettersUsed.indexOf("b") != -1) &&(lettersUsed.indexOf("a") != -1) && (lettersUsed.indexOf("B") != -1)) { // baB
				s1 = b;
				s2 = a;
				angle = B;
			} else if ((lettersUsed.indexOf("c") != -1) && (lettersUsed.indexOf("b") != -1) && (lettersUsed.indexOf("C") != -1)) { // cbC
				s1 = c;
				s2 = b;
				angle = C;
			} else if ((lettersUsed.indexOf("a") != -1)&& (lettersUsed.indexOf("c") != -1)&&(lettersUsed.indexOf("A") != -1)) { // acA
				s1 = a;
				s2 = c;
				angle = A;
			}
			if (s1 != 3 && s2 != 3 && angle != 60) { // only performs these
														// calculations in the
														// case of an SSA
														// triangle
				h = s2 * Math.sin(Math.toRadians(angle));
				// checks are based off of this:
				// http://jwilson.coe.uga.edu/emt668/emat6680.2001/mealor/emat%206700/law%20of%20sines/law%20of%20sines%20ambiguous%20case/lawofsinesambiguouscase.html
				if (angle < 90 && s1 < h)
					temp = 0;
				else if (angle < 90 && h < s1 && s1 < s2)
					temp = 2;
				else if (angle > 90 && s1 <= s2)
					temp = 0;
			}
		}

		else if (sideCount == 3) { // if 3 sides are given, it ensures that no
									// side is longer than the sum of the other
									// 2
			if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
				temp = 0;
			}
		}
		solutions = temp;
		
		if (solutions==0){
			lettersUsed.clear();
		}
		
		return temp; // returns number of solutions
	}

	public double getPerimeter1() {
		return a + b + c; // sum of all sides
	}

	public double getPerimeter2() {
		return a2 + b2 + c2; // sum of all sides
	}

	public double getArea1() {
		double s = getPerimeter1() / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's law to
															// find area
	}

	public double getArea2() {
		double s = getPerimeter2() / 2;
		return Math.sqrt(s * (s - a2) * (s - b2) * (s - c2)); // Heron's law to
																// find area
	}
}