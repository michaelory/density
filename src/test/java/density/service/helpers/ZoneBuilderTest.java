package density.service.helpers;

import org.junit.Assert;
import org.junit.Test;

public class ZoneBuilderTest {

    @Test
    public void min() {
        Assert.assertEquals(2.5, ZoneBuilder.min(3), 0);
        Assert.assertEquals(1.5, ZoneBuilder.min(2), 0);
        Assert.assertEquals(2, ZoneBuilder.min(2.5), 0);
        Assert.assertEquals(-2.5, ZoneBuilder.min(-3), 0);
        Assert.assertEquals(-1.5, ZoneBuilder.min(-2), 0);
        Assert.assertEquals(-2, ZoneBuilder.min(-2.5), 0);
    }

    @Test
    public void round() {
        Assert.assertEquals(3, ZoneBuilder.round(2.6), 0);
        Assert.assertEquals(2, ZoneBuilder.round(2.4), 0);
        Assert.assertEquals(2.5, ZoneBuilder.round(2.5), 0);
        Assert.assertEquals(-3, ZoneBuilder.round(-2.6), 0);
        Assert.assertEquals(-2, ZoneBuilder.round(-2.4), 0);
        Assert.assertEquals(-2.5, ZoneBuilder.round(-2.5), 0);
    }
}
