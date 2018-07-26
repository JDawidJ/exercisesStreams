import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    String brand;
    BigDecimal price;
    int carMileage;
    Engine engine;
    CarBody carBody;
    Wheel wheel;

    public Car(String fileName) {
        try {
            List<String> lista = Files.lines(Paths.get(fileName))
                    .collect(Collectors.toList());

            String[] line1 = lista.get(0).split(" ");
            String[] line2 = lista.get(1).split(" ");
            String[] line3 = lista.get(2).split(" ");
            String[] line4 = lista.get(3).split(" ");
            String[] line3Accessories = line3[2].split(";");


            List<Equipment> accessories = new ArrayList<>();
            for (int i = 0; i < line3Accessories.length; i++) {
                accessories.add(Equipment.valueOf(line3Accessories[i]));
            }

            try {
                this.brand = line1[0];
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Blad w nazwie auta-ustawiono nazwe domyslna");
                this.brand = "AUTODOMYSLNE";
            }
            try {
                this.price = BigDecimal.valueOf(Integer.valueOf(line1[1]));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("blad w cenie-ustawiono cene domyslna");
                this.price = BigDecimal.valueOf(0000);
            }
            try {
                this.carMileage = Integer.valueOf(line1[2]);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("blad w przebiegu-ustawiono wartosc domyslna");
                this.carMileage = 0;
            }

            try {
                this.engine = new Engine(EngineType.valueOf(line2[0]), BigDecimal.valueOf(Double.valueOf(line2[1])), BigDecimal.valueOf(Double.valueOf(line2[2])));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("błąd w parametrach silnika");
            }
            try {


                this.carBody = new CarBody(CarBodyColour.valueOf(line3[0]), CarBodyType.valueOf(line3[1]), accessories);
                this.wheel = new Wheel(line4[0], Integer.valueOf(line4[1]), WheelType.valueOf(line4[2]));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("blad w nadwoziu lub kołach");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carMileage != car.carMileage) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;
        if (price != null ? !price.equals(car.price) : car.price != null)
            return false;
        if (engine != null ? !engine.equals(car.engine) : car.engine != null) return false;
        if (carBody != null ? !carBody.equals(car.carBody) : car.carBody != null) return false;
        return wheel != null ? wheel.equals(car.wheel) : car.wheel == null;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + carMileage;
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (carBody != null ? carBody.hashCode() : 0);
        result = 31 * result + (wheel != null ? wheel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", carMileage=" + carMileage +
                ", engine=" + engine +
                ", carBody=" + carBody +
                ", wheel=" + wheel +
                '}';
    }

    public void konstruktorSamochodu(String nazwaPliku) {


    }


}
