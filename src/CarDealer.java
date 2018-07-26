import java.util.*;
import java.util.stream.Collectors;

public class CarDealer implements CarSort {
    private Set<Car> cars = new TreeSet<>(Comparator.comparing(Car::getBrand));

    CarDealer(List<String> auta) {
        auta
                .stream()
                .forEach(p -> this.cars.add(new Car(p + ".txt")));
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public List<Car> sortPrice(Set<Car> auta) {
        List<Car> posortowane = new ArrayList<>();
        posortowane.addAll(auta);
        posortowane = posortowane
                .stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .collect(Collectors.toList());
        return posortowane;
    }

    @Override
    public List<Car> sortBrand(Set<Car> auta) {
        List<Car> posortowane = new ArrayList<>();
        posortowane.addAll(auta);
        posortowane = posortowane
                .stream()
                .sorted(Comparator.comparing(Car::getBrand))
                .collect(Collectors.toList());
        return posortowane;
    }

    @Override
    public List<Car> sortColour(Set<Car> auta) {
        List<Car> posortowane = new ArrayList<>();
        posortowane.addAll(auta);
        posortowane = posortowane
                .stream()
                .sorted(Comparator.comparing(p -> p.getCarBody().getCarBodyColour().toString())) //nie działa-ok działa jebany toString
                .collect(Collectors.toList());
        return posortowane;
    }

    @Override
    public List<Car> sortBodyType(Set<Car> auta) {
        List<Car> posortowane = new ArrayList<>();
        posortowane.addAll(auta);
        posortowane = posortowane
                .stream()
                // .map(p->p.getCarBody().carBodyType)
                .sorted((Comparator.comparing(p -> p.getCarBody().getCarBodyType().toString())))
                .collect(Collectors.toList());
        return posortowane;
    }

    public List<Car> bodyTypeAndPriceSorter(CarBodyType carBodyType, int a, int b) {
        List<Car> listaAut = new ArrayList<>();
        listaAut.addAll(this.cars);
        listaAut = listaAut
                .stream()
//allMatch bylo by fajne ale nie wiem jak dodac je do listy stad filter
                .filter(p -> p.getCarBody().getCarBodyType() == (carBodyType) && (p.getPrice().intValueExact() > a && p.getPrice().intValueExact() < b))
                .collect(Collectors.toList());
        return listaAut;

    }

    public List<Car> fuelTypeSorter(EngineType engineType) {
        List<Car> listaAut = new ArrayList<>();
        listaAut.addAll(this.cars);
        listaAut = listaAut
                .stream()
                .filter(p -> p.getEngine().getEngineType() == engineType)
                .collect(Collectors.toList());
        return listaAut;
    }

    public void differentTypeParameters(int priceMin, int priceMax, EngineType engineType, int engineCapacityMin, int engineCapacityMax) {
        List<Car> auta = this.cars
                .stream()
                .filter(p -> (p.getPrice().intValueExact() > priceMin &&
                        p.getPrice().intValueExact() < priceMax) &&
                        (p.getEngine().getEngineType() == engineType) &&
                        (p.getEngine().getEngineCapacity().intValueExact() > engineCapacityMin &&
                                p.getEngine().getEngineCapacity().intValueExact() < engineCapacityMax))
                .collect(Collectors.toList());
        System.out.println(auta);
    }

    public IntSummaryStatistics arithmeticAverage(Engine engine) {
        IntSummaryStatistics summaryStatistics = this.cars
                .stream()
                .collect(Collectors.summarizingInt(p -> p.getEngine().getEngineCapacity().intValueExact()));
        return summaryStatistics;
    }

    //overloading?! :D
    public IntSummaryStatistics arithmeticAverage(Set<Car> auta) {
        IntSummaryStatistics summaryStatistics = this.cars
                .stream()
                .collect(Collectors.summarizingInt(p -> p.getPrice().intValueExact()));
        return summaryStatistics;
    }

    @Override
    public String toString() {
        return "CarDealer{" +
                "cars=" + cars +
                '}';
    }
}
