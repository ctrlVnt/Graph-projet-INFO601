public class Student extends Node
{
    public Student(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return "Student{"+ getLabel() +"}";
    }
}
