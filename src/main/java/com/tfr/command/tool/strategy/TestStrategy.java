package com.tfr.command.tool.strategy;

import java.util.Map;

public class TestStrategy implements Strategy {
    @Override
    public Map<String, Object> interact() {
        return Map.of();
    }

    @Override
    public void execute(Map<String, Object> params) {
        System.out.println("This is a test...");
    }
}
