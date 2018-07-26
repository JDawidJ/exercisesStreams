import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

  //List<String>samochody=createCar();// metoda uzyta raz do stworzenia plikow z autami
List<String>carList= TemporaryListCarsFromFiles("bmw","Fiat","Renault");
  CarDealer carDealer =new CarDealer(carList);
        System.out.println(carDealer);
        System.out.println("sortowanie cena: ");
        System.out.println(carDealer.sortPrice(carDealer.getCars()));
        System.out.println("sortowanie brand: ");
        System.out.println(carDealer.sortBrand(carDealer.getCars()));
        System.out.println("sortowanie kolor: ");
        System.out.println(carDealer.sortColour(carDealer.getCars()));
        System.out.println("sortowanie rodzaj nadwozia: ");
        System.out.println(carDealer.sortBodyType(carDealer.getCars()));
        System.out.println("RODZAJE NADWOZIA I CENA:");
        System.out.println(carDealer.bodyTypeAndPriceSorter(CarBodyType.SEDAN, 12, 1000000));
        System.out.println("Rodzaj paliwa: ");
        System.out.println(carDealer.fuelTypeSorter(EngineType.DIESEL));
        System.out.println("Parametry wpisane prze uzytkownika: ");
        carDealer.differentTypeParameters(20,522220, EngineType.DIESEL,1,3);
        System.out.println("srenia arytmetyczna pojemnosc: ");
        System.out.println(carDealer.arithmeticAverage(new Engine()));
        System.out.println("srenia arytmetyczna cena: ");
        System.out.println(carDealer.arithmeticAverage(carDealer.getCars()));
    }
    public static List<String> createCar() {
        List<String> auta = new ArrayList<>();
        String carName, price, mileage, engineType, engineCapacity, fuelConsumption, bodyColour, bodyType, equipment, tireProducent, tireSize, tireType;
        int howManyCarsToCreate;

        Scanner skan = new Scanner(System.in);

        System.out.println("Ile aut chcesz stworzyc?: ");
        howManyCarsToCreate = skan.nextInt();
        do {
            System.out.println("Podaj markę: ");

            carName = skan.next();
            System.out.println("Podaj cenę: ");
            price = skan.next();
            System.out.println("Podaj carMileage: ");
            mileage = skan.next();
            System.out.println("Podaj rodzaj silnika(DIESEL/BENZYNA): ");
            engineType = skan.next();
            System.out.println("Podaj pojemnosc: ");
            engineCapacity = skan.next();
            System.out.println("Podaj spalanie: ");
            fuelConsumption = skan.next();
            System.out.println("Podaj kolor: ");
            bodyColour = skan.next();
            System.out.println("Podaj rodzaj nadwozia( SEDAN/HATCHBACK/KOMBI): ");
            bodyType = skan.next();
            System.out.println("Podaj wyposazenie: ");
            equipment = skan.next();
            System.out.println("Podaj nazwe producenta opon: ");
            tireProducent = skan.next();
            System.out.println("Podaj rozmiar opony: ");
            tireSize = skan.next();
            System.out.println("podaj rodzaj opony: ");
            tireType = skan.next();


            try {
                PrintWriter printWriter = new PrintWriter(carName + ".txt");
                printWriter.println(carName + " " + price + " " + mileage);
                printWriter.println(engineType + " " + engineCapacity + " " + fuelConsumption);
                printWriter.println(bodyColour + " " + bodyType + " " + equipment);
                printWriter.println(tireProducent + " " + tireSize + " " + tireType);
                printWriter.close();
                auta.add(carName);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
           howManyCarsToCreate=howManyCarsToCreate-1;
        }
        while (howManyCarsToCreate > 0);
        return auta;

    }
    public static List<String> TemporaryListCarsFromFiles(String fileName1, String fileName2, String fileName3){
        List<String>lista=new ArrayList<>();
        lista.add(fileName1);
        lista.add(fileName2);
        lista.add(fileName3);
        return lista;
    }
}