package density.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import density.model.Poi;
import density.model.Zone;
import density.service.DensityService;

public class DensityServiceImpl implements DensityService {

    private List<Poi> pois = new ArrayList<>();

    private Map<Zone, Integer> zones = new HashMap<>();
    private Map<Integer, List<Zone>> reverseZone = new TreeMap<>(Collections.reverseOrder());

    @Override
    public void addPoi(Poi poi) {
        this.pois.add(poi);
        double roundLat = round(poi.getLat());
        double roundLon = round(poi.getLon());
        Zone zone = new Zone(roundLat < 0 ? roundLat : min(roundLat), roundLat < 0 ? min(roundLat) : roundLat,
                roundLon < 0 ? roundLon : min(roundLon), roundLon < 0 ? min(roundLon) : roundLon);
        int nbPoi = zones.getOrDefault(zone, 0) + 1;
        zones.put(zone, nbPoi);
        List<Zone> rZones = reverseZone.getOrDefault(nbPoi, new ArrayList<>());
        rZones.add(zone);
        reverseZone.put(nbPoi, rZones);
    }

    public double min(double number) {
        return number < 0 ? number + 0.5 : number - 0.5;
    }

    public double round(double number) {
        String numberStr = String.valueOf(number);
        numberStr = numberStr.substring(numberStr.indexOf(".") + 1);
        return Integer.valueOf(numberStr) == 5 ? number : Math.round(number);
    }

    @Override
    public long nbPoi(double minLat, double minLon) {
        return pois.stream().filter(poi -> poi.getLat() >= minLat && poi.getLon() >= minLon).count();
    }

    @Override
    public List<Zone> densest(int nbZone) {
        List<Zone> zoneMostDensity = new ArrayList<>();

        for (List<Zone> rZones : reverseZone.values()) {
            if (zoneMostDensity.size() >= nbZone) {
                return zoneMostDensity;
            }
            if (rZones.size() >= nbZone) {
                int i = 0;
                do {
                    zoneMostDensity.add(rZones.get(i));
                    i++;
                } while (zoneMostDensity.size() < nbZone);
            } else {
                zoneMostDensity.addAll(rZones);
            }
        }
        return zoneMostDensity;
    }

}
