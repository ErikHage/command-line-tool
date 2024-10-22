package com.tfr.command.tool;

import com.tfr.command.tool.strategy.Strategy;
import com.tfr.command.tool.strategy.StrategyFactory;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.Map;

public class CommandLineTool {

    private final StrategyFactory strategyFactory;

    public CommandLineTool() {
        strategyFactory = new StrategyFactory();
    }

    public static void main(String[] args) {
        ArgumentParser parser = ArgumentParsers.newFor("command-line-tool")
                .build();

        parser.addArgument("command")
                .type(Command.class);

        try {
            Namespace parsedArgs = parser.parseArgs(args);

            final Command command = parsedArgs.get("command");

            new CommandLineTool().runCommand(command);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
        }
    }

    public void runCommand(final Command command) {
        final Strategy strategy = this.strategyFactory.getStrategy(command);

        try {
            strategy.interact();
            strategy.execute(Map.of());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
