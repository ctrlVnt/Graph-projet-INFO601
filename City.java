public class City extends Node
{
    public City(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return "City :"+ getLabel();
    }
}
