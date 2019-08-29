package density.service.helpers;

import org.junit.Assert;
import org.junit.Test;

public class ZoneBuilderTest {

    @Test
    public void minMax_26() {
        // poi 2.6 expected min 2.5 max 3
        Assert.assertEquals(3, ZoneBuilder.max(2.6), 0);
        Assert.assertEquals(2.5, ZoneBuilder.min(2.6), 0);
    }

    @Test
    public void minMax_25() {
        // poi 2.5 expected min 2.5 max 3
        Assert.assertEquals(3, ZoneBuilder.max(2.5), 0);
        Assert.assertEquals(2.5, ZoneBuilder.min(2.5), 0);
    }

    @Test
    public void minMax_24() {
        // poi 2.4 expected min 2 max 2.5
        Assert.assertEquals(2.5, ZoneBuilder.max(2.4), 0);
        Assert.assertEquals(2, ZoneBuilder.min(2.4), 0);
    }

    @Test
    public void minMax_neg26() {
        // poi -2.6 expected min -2.5 max -3
        Assert.assertEquals(-3, ZoneBuilder.max(-2.6), 0);
        Assert.assertEquals(-2.5, ZoneBuilder.min(-2.6), 0);
    }

    @Test
    public void minMax_neg25() {
        // poi -2.5 expected min -2.5 max -3
        Assert.assertEquals(-3, ZoneBuilder.max(-2.5), 0);
        Assert.assertEquals(-2.5, ZoneBuilder.min(-2.5), 0);
    }

    @Test
    public void minMax_neg24() {
        // poi -2.4 expected min -2 max -2.5
        Assert.assertEquals(-2.5, ZoneBuilder.max(-2.4), 0);
        Assert.assertEquals(-2, ZoneBuilder.min(-2.4), 0);
    }
}
