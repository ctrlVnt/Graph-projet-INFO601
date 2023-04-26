public class Student extends Node
{
    private String formation;
    private String universite;

    public Student(String formation, String universite)
    {
        super(formation);
        this.formation = formation;
        this.universite = universite;
    }

    public String getFormation()
    {
        return formation;
    }

    public String getUniversite()
    {
        return universite;
    }
}
