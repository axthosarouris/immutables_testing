package no.unit.examplepackage.model;

import java.util.Arrays;


public enum Level {
    LEVEL_2(2),
    LEVEL_1(1),
    LEVEL_0(0),
    NO_LEVEL(null);

    public static final String ERROR_TEMLATE = "The specified level \"%s\" is not a legal value (%s)";
    private Integer level;

    Level(Integer level) {
        this.level = level;
    }

    /**
     * In cases where an integer is supplied, it must be checked that the level is correct.
     *
     * @param integer The level value as integer
     * @return Level value
     */
    public static Level getLevel(Integer integer)  {
        return Arrays.stream(values())
            .filter(levelInteger -> levelInteger.level.equals(integer)).findFirst()
            .orElseThrow(() -> new IllegalStateException(
                String.format(ERROR_TEMLATE, integer.toString(), Arrays.toString(values()))));
    }
}

