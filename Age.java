public class Age extends Node 
{
    public Age(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return "Age :"+ getLabel();
    }
}
