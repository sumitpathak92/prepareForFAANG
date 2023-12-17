package generics.comparison;

public class Student implements Comparable<Student> {

    int rollNo;
    float marks;

    public Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int)( this.marks - o.marks );

        // if diff = 0, both equal
        // if diff < 0, o is bigger
        return diff;
    }
}
