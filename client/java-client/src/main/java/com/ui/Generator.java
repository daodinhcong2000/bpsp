package com.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public abstract class Generator {
    private static final Logger LOGGER = LogManager.getLogger(Generator.class);
    static final Random rand = new Random();

    static public Generator getGenerator(DevicePanel.DeviceType type) {
        switch (type) {
            case LIGHT:
                return new LightGenerator();
            case THERMOSTAT:
                return new ThermostatGenerator();
            case FRIDGE:
                return new FridgeGenerator();
            case SPEAKER:
                return new SpeakerGenerator();
            case TV:
                return new TVGenerator();
            case COMPUTER:
                return new ComputerGenerator();
            case FANS:
                return new FansGenerator();
            default:
                return new CustomGenerator();
        }
    }

    public abstract String getData();
}

class LightGenerator extends Generator {

    @Override
    public String getData() {
        return (Generator.rand.nextInt(6) + 8) + "";
    }
}

class ThermostatGenerator extends Generator {

    @Override
    public String getData() {
        return (Generator.rand.nextInt(20) + 10 + Generator.rand.nextDouble()) + "";
    }
}

class FridgeGenerator extends Generator {

    @Override
    public String getData() {
        return (Generator.rand.nextInt(6) + 8) + "";
    }
}

class SpeakerGenerator extends Generator {

    @Override
    public String getData() {
        return (Generator.rand.nextInt(101)) + "";
    }
}

class TVGenerator extends Generator {

    @Override
    public String getData() {
        return Generator.rand.nextBoolean() ? "ON" : "OFF";
    }
}

class ComputerGenerator extends Generator {

    @Override
    public String getData() {
        return Generator.rand.nextBoolean() ? "ON" : "OFF";
    }
}

class FansGenerator extends Generator {

    @Override
    public String getData() {
        return (Generator.rand.nextInt(11)) + "";
    }
}

class CustomGenerator extends Generator {

    @Override
    public String getData() {
        return "Hello World";
    }
}
