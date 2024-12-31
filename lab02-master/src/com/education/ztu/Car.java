package com.education.ztu;

public class Car {
    private String brand;
    private Engine engine;

    public Car(String brand) {
        this.brand = brand;
        this.engine = new Engine();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public boolean getCarStatus() {
        return this.engine.isEngineWorks();
    }

    public class Engine {
        private boolean engineWorks;

        public void startEngine() {
            this.engineWorks = true;
            System.out.println("Engine started.");
        }

        public void stopEngine() {
            this.engineWorks = false;
            System.out.println("Engine stopped.");
        }

        public boolean isEngineWorks() {
            return this.engineWorks;
        }
    }
}
