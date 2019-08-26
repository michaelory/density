package density.model;

import java.util.Objects;

public class Zone {

    private double minLat;
    private double maxLat;
    private double minLon;
    private double maxLon;

    public Zone(double minLat, double maxLat, double minLon, double maxLon) {
        this.minLat = minLat;
        this.maxLat = maxLat;
        this.minLon = minLon;
        this.maxLon = maxLon;
    }

    public double getMinLat() {
        return minLat;
    }

    public void setMinLat(double minLat) {
        this.minLat = minLat;
    }

    public double getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(double maxLat) {
        this.maxLat = maxLat;
    }

    public double getMinLon() {
        return minLon;
    }

    public void setMinLon(double minLon) {
        this.minLon = minLon;
    }

    public double getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(double maxLon) {
        this.maxLon = maxLon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return Double.compare(zone.minLat, minLat) == 0 &&
                Double.compare(zone.maxLat, maxLat) == 0 &&
                Double.compare(zone.minLon, minLon) == 0 &&
                Double.compare(zone.maxLon, maxLon) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minLat, maxLat, minLon, maxLon);
    }

    @Override
    public String toString() {
        return "Zone{" +
                "minLat=" + minLat +
                ", maxLat=" + maxLat +
                ", minLon=" + minLon +
                ", maxLon=" + maxLon +
                '}';
    }
}
