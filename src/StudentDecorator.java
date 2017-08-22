public class StudentDecorator {

	private Student student;
	private int count;

	public StudentDecorator(Student s, int count) {
		this.student = s;
		this.count = count;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return student.toString() + " count- " + count;
	}

	@Override
	public int hashCode() {
		return this.student.hashCode();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof StudentDecorator) {
			StudentDecorator other = (StudentDecorator) obj;
			return student.getName().compareTo(other.student.getName()) == 0
					&& student.getGrade() == this.student.getGrade();
		}
		return false;
	}
}
