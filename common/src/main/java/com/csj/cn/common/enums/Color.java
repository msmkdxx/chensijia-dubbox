package com.csj.cn.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Color {
    RED("红色"),
    YELLOW("黄色"),
    GREEN("绿色");
    String name;

    public String getName() {
        return name;
    }

    public static Color matchOpCode(String opCodeStr) {
        for (Color opCode : Color.values()) {
            if (opCode.name().equalsIgnoreCase(opCodeStr)) {
                return opCode;
            }
        }
        return null;
    }
}
