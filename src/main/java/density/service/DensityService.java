package density.service;

import java.util.List;

import org.springframework.stereotype.Service;

import density.model.Poi;
import density.model.Zone;

@Service
public interface DensityService {

    void addPoi(Poi poi);

    long nbPoi(double minLat, double minLon);

    List<Zone> densest(int nbZone);
}
