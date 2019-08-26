package density.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import density.model.Poi;
import density.model.Zone;
import density.service.DensityService;
import density.service.helpers.ZoneBuilder;
import density.service.helpers.ZoneMaps;

public class DensityServiceImpl implements DensityService {

    private List<Poi> pois = new ArrayList<>();

    private ZoneMaps zones = new ZoneMaps();

    @Override
    public void addPoi(Poi poi) {
        pois.add(poi);
        Zone zone = ZoneBuilder.createZone(poi.getLat(), poi.getLon());
        zones.put(zone, zones.getOrDefault(zone, 0) + 1);
    }

    @Override
    public long nbPoi(double minLat, double minLon) {
        return pois.stream().filter(poi -> poi.getLat() >= minLat && poi.getLon() >= minLon).count();
    }

    @Override
    public List<Zone> densest(int nbZone) {
        if (nbZone < 0)
            return Collections.emptyList();

        List<Zone> zoneMostDensity = new ArrayList<>(nbZone);

        for (List<Zone> reverseZones : zones.getReverseZones().values()) {
            if (zoneMostDensity.size() >= nbZone) {
                return zoneMostDensity;
            }
            if (reverseZones.size() >= nbZone) {
                completeZones(zoneMostDensity, reverseZones, nbZone);
            } else {
                zoneMostDensity.addAll(reverseZones);
            }
        }
        return zoneMostDensity;
    }

    private void completeZones(List<Zone> zoneMostDensity, List<Zone> zones, int nbZone) {
        int i = 0;
        do {
            zoneMostDensity.add(zones.get(i));
            i++;
        } while (i < zones.size() && zoneMostDensity.size() < nbZone);

    }

}
