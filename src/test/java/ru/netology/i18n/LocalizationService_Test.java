package ru.netology.i18n;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

public class LocalizationService_Test {
    @Test
    public void localeTest() {
        // Given:
        String rusLine = "Добро пожаловать";

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn(rusLine);

        // When:
        localizationService.locale(Country.RUSSIA);

        // Then:
        assertEquals(rusLine, localizationService.locale(Country.RUSSIA));
    }
}
