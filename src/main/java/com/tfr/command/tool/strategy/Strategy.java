package com.tfr.command.tool.strategy;

import java.util.Map;

public interface Strategy {

    Map<String, Object> interact();

    void execute(Map<String, Object> params);
}
