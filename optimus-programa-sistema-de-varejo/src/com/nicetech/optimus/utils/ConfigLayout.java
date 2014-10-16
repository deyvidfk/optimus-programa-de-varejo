package com.nicetech.optimus.utils;

public enum ConfigLayout {

    LookAndFeelDefault("com.jtattoo.plaf.fast.FastLookAndFeel"), LookAndFeel2("com.jtattoo.plaf.smart.SmartLookAndFeel");

    private final String lookAndFeel;

    private ConfigLayout(String look) {
        lookAndFeel = look;
    }

    /**
     * @return the lookAndFeel
     */
    public String getLookAndFeel() {
        return lookAndFeel;
    }
}
