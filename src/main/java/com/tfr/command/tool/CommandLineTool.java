package com.tfr.command.tool;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class CommandLineTool {

    public static void main(String[] args) {
        ArgumentParser parser = ArgumentParsers.newFor("command-line-tool")
                .build();

        parser.addArgument("command")
                .type(Command.class);
        try {
            Namespace parsedArgs = parser.parseArgs(args);

            final Command command = parsedArgs.get("command");

            System.out.println("Executing: " + command);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
        }
    }
}
