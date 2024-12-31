package com.education.ztu;

import org.junit.*;
import org.junit.rules.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class CarTest {
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private Car car;

    @Before
    public void setUp() {
        car = new Car("Tesla");
    }

    @Test
    public void testEngineStart() {
        car.getEngine().startEngine();
        assertTrue(car.getEngine().isEngineWorks());
    }

    @Test
    public void testEngineStop() {
        car.getEngine().startEngine();
        car.getEngine().stopEngine();
        assertFalse(car.getEngine().isEngineWorks());
    }

    @Test
    public void testCarBrand() {
        assertEquals("Tesla", car.getBrand());
    }

    @Ignore
    @Test
    public void testCarStatus() {
        assertFalse(car.getCarStatus());
    }

    @Test
    public void testLogEngineStatus() throws IOException {
        File logFile = tempFolder.newFile("engineLog.txt");

        Car car = new Car("Toyota");

        car.getEngine().startEngine();
        car.logEngineStatus(logFile);

        assertTrue(logFile.exists());
        assertTrue(Files.size(Paths.get(logFile.getPath())) > 0);
    }

}
