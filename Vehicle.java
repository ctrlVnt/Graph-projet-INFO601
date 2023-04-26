public class Vehicle {
    
    public static enum vehicleType
    {
        Car,
        Truck,
        Motorcycle
    }

    private vehicleType type;
    private String brand;
    private String model;

    public Vehicle(vehicleType type, String brand, String model)
    {
        this.type = type;
        this.brand = brand;
        this.model = model;
    }

    public vehicleType getType()
    {
        return type;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
        "type ='" + type + '\'' +
        ", brand ='" + brand + '\'' +
        ", model ='" + model +
        '}';
    }
}
