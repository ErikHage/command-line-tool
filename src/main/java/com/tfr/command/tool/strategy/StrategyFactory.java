package com.tfr.command.tool.strategy;

import com.tfr.command.tool.Command;

import java.util.EnumMap;
import java.util.Map;

public class StrategyFactory {

    private final Map<Command, Strategy> commandStrategyMap;

    public StrategyFactory() {
        this.commandStrategyMap = new EnumMap<>(Command.class);

        this.commandStrategyMap.put(Command.TEST, new TestStrategy());
    }

    public Strategy getStrategy(final Command command) {
        return commandStrategyMap.get(command);
    }
}
