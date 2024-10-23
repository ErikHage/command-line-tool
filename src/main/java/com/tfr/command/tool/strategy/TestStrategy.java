package com.tfr.command.tool.strategy;

import java.util.Map;

public class TestStrategy implements Strategy {
    @Override
    public Map<String, Object> interact() {
        String name = System.console().readLine("Enter your name: ");

        return Map.of("name", name);
    }

    @Override
    public void execute(Map<String, Object> params) {
        System.out.println("Hello " + params.get("name"));
        System.out.println("This is just a test...");
    }
}
