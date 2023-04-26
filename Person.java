public class Personne extends Node
{    
    private String name;
    private int age;

    public Personne(String name, int age)
    {
        super(name);
        this.name = name;
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }
}
