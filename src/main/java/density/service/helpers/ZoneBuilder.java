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
        double roundLat = round(lat);
        double roundLon = round(lon);
        zone.setMinLat(roundLat < 0 ? roundLat : min(roundLat));
        zone.setMaxLat(roundLat < 0 ? min(roundLat) : roundLat);
        zone.setMinLon(roundLon < 0 ? roundLon : min(roundLon));
        zone.setMaxLon(roundLon < 0 ? min(roundLon) : roundLon);
        return zone;
    }

    static double min(double number) {
        return number < 0 ? number + 0.5 : number - 0.5;
    }

    static double round(double number) {
        String numberStr = String.valueOf(number);
        numberStr = numberStr.substring(numberStr.indexOf('.') + 1);
        return Integer.valueOf(numberStr) == 5 ? number : Math.round(number);
    }
}
