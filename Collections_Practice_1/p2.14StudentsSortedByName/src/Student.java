import java.awt.datatransfer.StringSelection;

public class Student implements Comparable<Student> {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

	@Override
	public int compareTo(Student object) {
		// TODO Auto-generated method stub
		return name.compareToIgnoreCase(object.name);
	}

}
