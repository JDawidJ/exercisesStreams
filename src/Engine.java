import java.math.BigDecimal;

public class Engine {
   EngineType engineType;
   BigDecimal engineCapacity;
   BigDecimal fuelConsumpcion;

    public Engine() {
    }

    public Engine(EngineType engineType, BigDecimal engineCapacity, BigDecimal fuelConsumpcion) {
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
        this.fuelConsumpcion = fuelConsumpcion;
    }

    public Engine(EngineType[] values, BigDecimal engineCapacity, BigDecimal fuelConsumpcion) {
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public BigDecimal getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(BigDecimal engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public BigDecimal getFuelConsumpcion() {
        return fuelConsumpcion;
    }

    public void setFuelConsumpcion(BigDecimal fuelConsumpcion) {
        this.fuelConsumpcion = fuelConsumpcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (engineType != engine.engineType) return false;
        if (engineCapacity != null ? !engineCapacity.equals(engine.engineCapacity) : engine.engineCapacity != null) return false;
        return fuelConsumpcion != null ? fuelConsumpcion.equals(engine.fuelConsumpcion) : engine.fuelConsumpcion == null;
    }

    @Override
    public int hashCode() {
        int result = engineType != null ? engineType.hashCode() : 0;
        result = 31 * result + (engineCapacity != null ? engineCapacity.hashCode() : 0);
        result = 31 * result + (fuelConsumpcion != null ? fuelConsumpcion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineType=" + engineType +
                ", engineCapacity=" + engineCapacity +
                ", fuelConsumpcion=" + fuelConsumpcion +
                '}';
    }
}
