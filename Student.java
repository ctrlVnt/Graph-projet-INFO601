public class Student extends Person
{
    private int year;

    public Student(String name, int age, int year)
    {
        super(name, age);
        this.year = year;
    }

    public int getYear()
    {
        return year;
    }
}
