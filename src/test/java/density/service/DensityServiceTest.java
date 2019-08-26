package density.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import density.model.Poi;
import density.service.impl.DensityServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DensityServiceTest {

    private DensityService densityService;

    @Before
    public void init() {
        densityService = new DensityServiceImpl();
        List<Poi> pois = new ArrayList<>();

        /*
        @id @lat @lon
        id1 -48.6 -37.7
        id2 -27.1 8.4
        id3 6.6 -6.9
        id4 -2.3 38.3
        id5 6.8 -6.9
        id6 -2.5 38.3
        id7 0.1 -0.1
        id8 -2.1 38.1
         */
        pois.add(new Poi(-48.6, -37.7));
        pois.add(new Poi(-27.1, 8.4));
        pois.add(new Poi(6.6, -6.9));
        pois.add(new Poi(-2.3, 38.3));
        pois.add(new Poi(6.8, -6.9));
        pois.add(new Poi(-2.5, 38.3));
        pois.add(new Poi(0.1, -0.1));
        pois.add(new Poi(-2.1, 38.1));

        densityService.addPois(pois);
    }

    @Test
    public void nbPoi() {
        Assert.assertEquals(2, densityService.nbPoi(6.5, -7));
    }

}
