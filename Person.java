public class Person extends Node
{    
    private String adresse;
    private int age;

    public Person(String adresse, int age)
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

    @Override
    public String toString() {
        return "Person{" +
        "adresse ='" + adresse + '\'' +
        ", age ='" + age +
        '}';
    }
}
