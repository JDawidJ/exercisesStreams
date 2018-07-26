import java.util.List;
import java.util.Set;

public interface CarSort {
    List<Car> sortPrice(Set<Car>auta);
    List<Car> sortBrand(Set<Car>auta);
    List<Car> sortColour(Set<Car>auta);
    List<Car> sortBodyType(Set<Car>auta);
}
