public class Student {

	private String name;
	private int grade;

	public Student(String line) {
		String[] split = line.split(",");

		this.name = split[0];
		this.grade = Integer.parseInt(split[1]);

	}


	@Override
	public String toString() {
		return "name: " + this.name + " grade: " + this.grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
