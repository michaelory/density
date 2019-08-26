package density.service.impl;

import java.util.ArrayList;
import java.util.List;

import density.model.Poi;
import density.service.DensityService;

public class DensityServiceImpl implements DensityService {

    private List<Poi> pois = new ArrayList<>();

    @Override
    public void addPois(List<Poi> pois) {
        this.pois = pois;
    }

    @Override
    public long nbPoi(double minLat, double minLon) {
        return pois.stream().filter(poi -> poi.getLat()>=minLat && poi.getLon()>=minLon).count();
    }
}
