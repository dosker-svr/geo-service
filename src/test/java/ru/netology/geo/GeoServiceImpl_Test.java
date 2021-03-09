package ru.netology.geo;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

public class GeoServiceImpl_Test {
    @Test
    public void byIp_Test() {
        // Given:
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location locationRus = Mockito.mock(Location.class);
        Mockito.when(locationRus.getCountry()).thenReturn(Country.RUSSIA);

        Location locationUsa = Mockito.mock(Location.class);
        Mockito.when(locationUsa.getCountry()).thenReturn(Country.USA);

        String ipMsk = "172.0.32.11";
        String ipNy = "96.44.183.149";

        // When:
        geoService.byIp(ipMsk);
        geoService.byIp(ipNy);

        // Then:
        assertEquals(Country.RUSSIA, geoService.byIp(ipMsk).getCountry());
        assertEquals(Country.USA, geoService.byIp(ipNy).getCountry());
    }
}
