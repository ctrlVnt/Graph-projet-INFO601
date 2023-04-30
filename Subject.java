public class Subject extends Node 
{
    public Subject(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return "Subject :"+ getLabel();
    }
}
