package density.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import density.model.Poi;
import density.model.Zone;
import density.service.impl.DensityServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DensityServiceTest {

    private DensityService densityService;

    @Before
    public void init() {
        densityService = new DensityServiceImpl();
        densityService.addPoi(new Poi(-48.6, -37.7));
        densityService.addPoi(new Poi(-27.1, 8.4));
        densityService.addPoi(new Poi(6.6, -6.9));
        densityService.addPoi(new Poi(-2.3, 38.3));
        densityService.addPoi(new Poi(6.8, -6.9));
        densityService.addPoi(new Poi(-2.5, 38.3));
        densityService.addPoi(new Poi(0.1, -0.1));
        densityService.addPoi(new Poi(-2.1, 38.1));
    }

    @Test
    public void nbPoi() {
        Assert.assertEquals(2, densityService.nbPoi(6.5, -7));
    }

    @Test
    public void densest() {
        Assert.assertEquals(2, densityService.densest(2).size());
        Assert.assertEquals(3, densityService.densest(3).size());
        Assert.assertEquals(0, densityService.densest(0).size());
        Assert.assertEquals(0, densityService.densest(-1).size());

        Assert.assertArrayEquals(Arrays.asList(new Zone(6.5, 7, -7, -6.5),
                new Zone(-2, -1.5, 37.5, 38)).toArray(), densityService.densest(2).toArray());
    }

    @Test
    public void arround() {
        Assert.assertEquals(3, ((DensityServiceImpl) densityService).round(2.6), 0);
        Assert.assertEquals(2, ((DensityServiceImpl) densityService).round(2.4), 0);
        Assert.assertEquals(2.5, ((DensityServiceImpl) densityService).round(2.5), 0);
        Assert.assertEquals(-3, ((DensityServiceImpl) densityService).round(-2.6), 0);
        Assert.assertEquals(-2, ((DensityServiceImpl) densityService).round(-2.4), 0);
        Assert.assertEquals(-2.5, ((DensityServiceImpl) densityService).round(-2.5), 0);
    }

    @Test
    public void min() {
        Assert.assertEquals(2.5, ((DensityServiceImpl) densityService).min(3), 0);
        Assert.assertEquals(1.5, ((DensityServiceImpl) densityService).min(2), 0);
        Assert.assertEquals(2, ((DensityServiceImpl) densityService).min(2.5), 0);
        Assert.assertEquals(-2.5, ((DensityServiceImpl) densityService).min(-3), 0);
        Assert.assertEquals(-1.5, ((DensityServiceImpl) densityService).min(-2), 0);
        Assert.assertEquals(-2, ((DensityServiceImpl) densityService).min(-2.5), 0);
    }

}
