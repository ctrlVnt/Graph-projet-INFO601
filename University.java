public class University extends Node 
{
    public University(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return "University{"+ getLabel() +"}";
    }
}
