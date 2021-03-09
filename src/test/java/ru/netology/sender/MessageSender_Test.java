package ru.netology.sender;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MessageSender_Test {
    @Test
    public void sendForRus_Test() {
        // Given:
        String ipMsk = "172.0.32.11";
        String key = "x-real-ip";
        String sendMes = "Добро пожаловать";

        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ipMsk)).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn(sendMes);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(key, ipMsk);

        // When:
        messageSender.send(headers);

        // Then:
        assertEquals(sendMes, messageSender.send(headers));
    }

    @Test
    public void sendForUsa_Test() {
        //Given:
        String ipUsa = "96.44.183.149";
        String key = "x-real-ip";
        String sendMes = "Welcome";

        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ipUsa)).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn(sendMes);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(key, ipUsa);

        // When:
        messageSender.send(headers);

        // Then:
        assertEquals(sendMes, messageSender.send(headers));
    }
}
