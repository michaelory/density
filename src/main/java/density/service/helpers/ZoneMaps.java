package density.service.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import density.model.Zone;

public class ZoneMaps extends HashMap<Zone, Integer> {

    private transient Map<Integer, List<Zone>> reverseZone = new TreeMap<>(Collections.reverseOrder());

    @Override
    public Integer put(Zone zone, Integer poiCount) {
        List<Zone> zones = reverseZone.getOrDefault(poiCount, new ArrayList<>());
        zones.add(zone);
        reverseZone.put(poiCount, zones);
        return super.put(zone, poiCount);
    }

    public Map<Integer, List<Zone>> getReverseZones() {
        return reverseZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ZoneMaps zoneMaps = (ZoneMaps) o;
        return reverseZone.equals(zoneMaps.reverseZone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), reverseZone);
    }
}
