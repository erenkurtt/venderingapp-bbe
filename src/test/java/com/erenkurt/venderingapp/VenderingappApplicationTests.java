package com.erenkurt.venderingapp;

import com.erenkurt.venderingapp.System.System;
import com.erenkurt.venderingapp.System.SystemController;
import com.erenkurt.venderingapp.System.SystemService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class VenderingappApplicationTests {

    @Test
    void contextLoads() {
    }

    @InjectMocks
    private SystemController systemController;

    @Mock
    private SystemService systemService;

    @Test
    public void givenValidDataWhenGetSystemCalledThenStatusShouldEqualToOK() {
        // Given
        List<System> systems = new ArrayList<>();
        systems.add(new System(1, 100.0, 25));
        Mockito.when(systemService.getSystem()).thenReturn(systems);

        // When
        ResponseEntity<List<System>> response = systemController.getSystem();

        // Then
        assert response.getStatusCode() == HttpStatus.OK;
        assert Objects.equals(response.getBody(), systems);
    }

    @Test
    public void givenValidDataWhenUpdateSystemCalledThenStatusShouldEqualToOK() {
        // Given
        System updatedSystem = new System(1, 150.0, 28);
        Mockito.when(systemService.updateSystem(1, updatedSystem)).thenReturn(updatedSystem);

        // When
        ResponseEntity<System> response = systemController.updateSystem(1, updatedSystem);

        // Then
        assert response.getStatusCode() == HttpStatus.OK;
        assert Objects.equals(response.getBody(), updatedSystem);
    }

    @Test
    public void givenNonValidDataWhenUpdateSystemCalledThenStatusShouldEqualToNOT_FOUND() {
        // Given
        System updatedSystem = new System(1, 150.0, 28);
        Mockito.when(systemService.updateSystem(1, updatedSystem)).thenReturn(updatedSystem);

        // When
        ResponseEntity<System> response = systemController.updateSystem(10, updatedSystem);

        // Then
        assert response.getStatusCode() == HttpStatus.NOT_FOUND;
    }
}
