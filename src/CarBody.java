import java.util.List;

public class CarBody {
    CarBodyColour carBodyColour;
    CarBodyType carBodyType;
    List<Equipment> equipmentList;

    public CarBody(CarBodyColour carBodyColour, CarBodyType carBodyType, List<Equipment> equipmentList) {
        this.carBodyColour = carBodyColour;
        this.carBodyType = carBodyType;
        this.equipmentList = equipmentList;
    }

    public CarBody(CarBodyColour carBodyColour, CarBodyType carBodyType) {
        this.carBodyColour = carBodyColour;
        this.carBodyType = carBodyType;
    }

    public CarBody() {
    }

    public CarBodyColour getCarBodyColour() {
        return carBodyColour;
    }

    public void setCarBodyColour(CarBodyColour carBodyColour) {
        this.carBodyColour = carBodyColour;
    }

    public CarBodyType getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(CarBodyType carBodyType) {
        this.carBodyType = carBodyType;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarBody carBody = (CarBody) o;

        if (carBodyColour != carBody.carBodyColour) return false;
        if (carBodyType != carBody.carBodyType) return false;
        return equipmentList != null ? equipmentList.equals(carBody.equipmentList) : carBody.equipmentList == null;
    }

    @Override
    public int hashCode() {
        int result = carBodyColour != null ? carBodyColour.hashCode() : 0;
        result = 31 * result + (carBodyType != null ? carBodyType.hashCode() : 0);
        result = 31 * result + (equipmentList != null ? equipmentList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CarBody{" +
                "carBodyColour=" + carBodyColour +
                ", carBodyType=" + carBodyType +
                ", equipmentList=" + equipmentList +
                '}';
    }
}
