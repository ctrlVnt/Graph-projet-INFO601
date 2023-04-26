public class University {
    
    private String name;
    private String city;

    public University(String name, String city)
    {
        this.name = name;
        this.city = city;
    }

    public String getName()
    {
        return name;
    }

    public String getCity()
    {
        return city;
    }

    @Override
    public String toString() {
        return "University{" +
        "name ='" + name + '\'' +
        ", city ='" + city +
        '}';
    }
}
