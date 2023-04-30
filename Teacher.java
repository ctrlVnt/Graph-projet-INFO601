public class Teacher extends Node
{

    public Teacher(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return "Teacher{"+ getLabel() +"}";
    }
}
