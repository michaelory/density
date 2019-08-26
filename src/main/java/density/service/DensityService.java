package density.service;

import java.util.List;

import org.springframework.stereotype.Service;

import density.model.Poi;

@Service
public interface DensityService {

    void addPois(List<Poi> pois);

    long nbPoi(double minLat, double minLon);
}
