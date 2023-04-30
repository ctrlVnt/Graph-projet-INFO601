public class Adresse  extends Node
{
    public Adresse(String name)
    {
        super(name);
    }

    @Override
    public String toString() {
        return "Adresse :"+ getLabel();
    }
}
