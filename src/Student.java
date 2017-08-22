public class Student {

	private String name;
	private int grade;

	public Student(String line) {
		String[] split = line.split(",");

		this.name = split[0];
		this.grade = Integer.parseInt(split[1]);

	}

	@Override
	public int hashCode() {
		return name.hashCode() + grade;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student other = (Student) obj;
			return name.compareTo(other.name) == 0 && grade == other.grade;
		}
		return false;
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
