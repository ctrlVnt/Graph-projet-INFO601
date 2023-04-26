public class Personne extends Node
{    
    private String adresse;
    private int age;

    public Personne(String adresse, int age)
    {
        super(adresse);
        this.adresse = adresse;
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public String getAdresse()
    {
        return adresse;
    }
}
