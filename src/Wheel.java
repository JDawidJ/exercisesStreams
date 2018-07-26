public class Wheel {
    String nazwaProducenta;
    int rozmiar;
    WheelType wheelType;

    public Wheel(String nazwaProducenta, int rozmiar, WheelType wheelType) {
        this.nazwaProducenta = nazwaProducenta;
        this.rozmiar = rozmiar;
        this.wheelType = wheelType;
    }

    public Wheel() {
    }

    public String getNazwaProducenta() {
        return nazwaProducenta;
    }

    public void setNazwaProducenta(String nazwaProducenta) {
        this.nazwaProducenta = nazwaProducenta;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    public WheelType getWheelType() {
        return wheelType;
    }

    public void setWheelType(WheelType wheelType) {
        this.wheelType = wheelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wheel wheel = (Wheel) o;

        if (rozmiar != wheel.rozmiar) return false;
        if (nazwaProducenta != null ? !nazwaProducenta.equals(wheel.nazwaProducenta) : wheel.nazwaProducenta != null)
            return false;
        return wheelType == wheel.wheelType;
    }

    @Override
    public int hashCode() {
        int result = nazwaProducenta != null ? nazwaProducenta.hashCode() : 0;
        result = 31 * result + rozmiar;
        result = 31 * result + (wheelType != null ? wheelType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "nazwaProducenta='" + nazwaProducenta + '\'' +
                ", rozmiar=" + rozmiar +
                ", wheelType=" + wheelType +
                '}';
    }
}
