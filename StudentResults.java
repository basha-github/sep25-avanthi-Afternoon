
class Student {
	String name;
	String course;
	int fee;
	int java;
	int cpp;
	int python;

	public Student(String name, String course, int fee, int java, int cpp, int python) {
		super();
		this.name = name;
		this.course = course;
		this.fee = fee;
		this.java = java;
		this.cpp = cpp;
		this.python = python;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", course=" + course + ", fee=" + fee + ", java=" + java + ", cpp=" + cpp
				+ ", python=" + python + "]";
	}

}

public class StudentResults {
	static Student[] students = new Student[200];

	static void prepareStudentData() {
		int max = 100, min = 0, feeMax = 75000, feeMin = 5000;

		String[] courseNames = { "EEE", "EC", "IT", "CSE", "Mechanical", "Civil" };
		int courseMax = 5, courseMin = 0;

		for (int i = 0; i < 200; i++) {
			int fee = (int) (Math.random() * (feeMax - feeMin + 1) + feeMin);
			int java = (int) (Math.random() * (max - min + 1) + min);
			int cpp = (int) (Math.random() * (max - min + 1) + min);
			int python = (int) (Math.random() * (max - min + 1) + min);
			int courseIndex = (int) (Math.random() * (courseMax - courseMin + 1) + courseMin);

			students[i] = new Student("Student" + (i + 1), courseNames[courseIndex], fee, java, cpp, python);

			System.out.println(students[i]);
		}

	}

	public static void main(String[] args) {
		prepareStudentData();

		processFeeDue(75000);
		processFeeDue(10000);

		processMarks();
		processFeeDue("Pass", 75000);
	}

	private static void processFeeDue(String res, int amt) {
		long dueAmount = 0;
		for (int i = 0; i < students.length; i++) {

			if ((students[i].java >= 35) && (students[i].cpp >= 35) && (students[i].python >= 35)) {

				if (students[i].fee <= amt) {// 10000
					dueAmount = dueAmount + 75000 - students[i].fee;
				}
			} // if
		} // for
		
		System.out.println("All Passed Student Due Amount--->"+dueAmount);

	}

	private static void processMarks() {
		int pass = 0;
		for (int i = 0; i < students.length; i++) {

			if ((students[i].java >= 35) && (students[i].cpp >= 35) && (students[i].python >= 35)) {

				pass++;
			} // if
		} // for

		System.out.println("All Pass Count--->" + pass);

	}

	private static void processFeeDue(int amt) {

		long dueAmount = 0;

		for (int i = 0; i < students.length; i++) {

			if (students[i].fee <= amt) {// 10000
				dueAmount = dueAmount + 75000 - students[i].fee;
			} // if

		} // for

		System.out.println(amt + "only Paid Total Due Amount---->" + dueAmount);
	}

}
