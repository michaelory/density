package density.service.helpers;

import density.model.Zone;

public class ZoneBuilder {

    private ZoneBuilder() {
    }

    public static Zone createZone(double minLat, double maxLat, double minLon, double maxLon) {
        Zone zone = new Zone();
        zone.setMinLat(minLat);
        zone.setMaxLat(maxLat);
        zone.setMinLon(minLon);
        zone.setMaxLon(maxLon);
        return zone;
    }

    public static Zone createZone(double lat, double lon) {
        Zone zone = new Zone();
        double maxLat = max(lat);
        double maxLon = max(lon);
        zone.setMinLat(maxLat < 0 ? maxLat : min(maxLat));
        zone.setMaxLat(maxLat < 0 ? min(maxLat) : maxLat);
        zone.setMinLon(maxLon < 0 ? maxLon : min(maxLon));
        zone.setMaxLon(maxLon < 0 ? min(maxLon) : maxLon);
        return zone;
    }

    static double min(double number) {
        String numberStr = String.valueOf(number);
        numberStr = numberStr.substring(numberStr.indexOf('.') + 1);
        if (Integer.valueOf(numberStr) == 5)
            return number;
        return Integer.valueOf(numberStr) < 5 ? number - Double.valueOf("0." + numberStr) : Math.round(number) - 0.5;
    }

    static double max(double number) {
        String numberStr = String.valueOf(number);
        numberStr = numberStr.substring(numberStr.indexOf('.') + 1);
        return Integer.valueOf(numberStr) < 5 ? number - Double.valueOf("0." + numberStr) + 0.5 : Math.round(number);
    }
}
