public class Motorcycle extends Vehicle 
{
    public static enum MotorcycleType 
    {
        Sportive,
        Roadster,
        Routiere,
        Scooter
    }

    private MotorcycleType type;

    public Motorcycle(String brand, String model, MotorcycleType type) 
    {
        super(Vehicle.vehicleType.Motorcycle, brand, model);
        this.type = type;
    }

    public MotorcycleType getMotorcycleType()
    {
        return type;
    }
}
