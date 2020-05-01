package com.borgespires.kata.wordwrap;

import static java.util.Objects.isNull;

public class BreakSpacesFirst {

    public static String wrap(String text, int columnSize) {
//        return wrapNullReturnsEmptyString(text, columnSize);
//        return oneShortWordDoesNotWrap(text, columnSize);

        // break at space
//        return twoWordsLongerThanLimitShouldWrap(text, columnSize);
//        return twoWordsShorterThanTheLimitDoNotWrap(text, columnSize);
//        return threeWordsJustOverTheLimitShouldWrapAtSecondWord(text, columnSize);
//        return fourWordsShorterThanTwiceTheLengthShouldWrapAtSecondWord(text, columnSize);
//        return threeWordsEachLongerThanLimitShouldWrap(text, columnSize);
//        return twoWordsTheFirstEndingAtTheLimit(text, columnSize);

        // break long words
//        return wordLongerThanLengthBreaksAtLength(text, columnSize);
        return wordLongerThanTwiceLengthShouldBreakTwice(text, columnSize);
    }

    /**
     * assertEquals("", wrap(null, 10));
     * 1. (nil->constant)
     */
    private static String wrapNullReturnsEmptyString(String text, int columnSize) {
        return "";
    }

    /**
     * assertEquals("", wrap("", 10));
     * 6. (unconditional->if)
     * 4. (constant->scalar)
     *
     * "I think the exception is probably more appropriate;"
     * "but the tests for that would also require the (unconditional->if) transformation."
     * "Still, it’s probably a good idea to to get all the invalid input cases done first."
     *
     * "But that just leaves us where we were before. So I guess there’s no better test to write"
     *
     * Why confusing with this digression?.
     */
    private static String oneShortWordDoesNotWrap(String text, int columnSize) {
        if (isNull(text)) return "";
        return text;
    }

    /**
     * assertEquals("word\nword", wrap("word word", 6));
     * 11. (expression->function)
     *
     * "This is one of those moves that feels clever."
     * "But given the priority premise, this is no longer all that simple."
     *
     * Why? the article does not show other valid option at this point.
     */
    private static String twoWordsLongerThanLimitShouldWrap(String text, int columnSize) {
        if (isNull(text)) return "";
        return text.replaceAll(" ", "\n");
    }

    /**
     * assertEquals("word word", wrap("word word", 11));
     * 6. (unconditional->if)
     */
    private static String twoWordsShorterThanTheLimitDoNotWrap(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        return text.replaceAll(" ", "\n");
    }

    /**
     * assertEquals("word word\nword", wrap("word word word", 11));
     * 11. (expression->function) // indexOf() not counted !!!!
     * 11. (expression->function)
     *
     * "Can it be solved with a higher priority transformation?
     * "I don’t think so. Every solution I can think of involves some kind of algorithm."
     *
     * Is this algorithm different from the one used on the other path?
     */
    private static String threeWordsJustOverTheLimitShouldWrapAtSecondWord(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        int space = text.lastIndexOf(' ');
        return text.substring(0, space) + "\n" + text.substring(space + 1);
    }

    /**
     * assertEquals("word word\nword word", wrap("word word word word", 11));
     * 11. (expression->function)
     */
    private static String fourWordsShorterThanTwiceTheLengthShouldWrapAtSecondWord(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        String columnText = text.substring(0, columnSize);
        int space = columnText.lastIndexOf(' ');
        return text.substring(0, space) + "\n" + text.substring(space + 1);
    }

    /**
     * assertEquals("word\nword\nword", wrap("word word word", 6));
     * 9. (statement->recursion)
     */
    private static String threeWordsEachLongerThanLimitShouldWrap(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        String columnText = text.substring(0, columnSize);
        int space = columnText.lastIndexOf(' ');
        return text.substring(0, space) + "\n" + wrap(text.substring(space + 1), columnSize);
    }

    /**
     * assertEquals("word\nword", WordWrap.wrap("word word", 4));
     * 11. (expression->function) => add(1)
     */
    private static String twoWordsTheFirstEndingAtTheLimit(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        String columnText = text.substring(0, columnSize + 1);
        int space = columnText.lastIndexOf(' ');
        return text.substring(0, space) + "\n" + wrap(text.substring(space + 1), columnSize);
    }

    /**
     * assertEquals("long\nword", wrap("longword", 4));
     * assertEquals("longer\nword", wrap("longerword", 6));
     *  6. (unconditional->if)
     * 11. (expression->function)
     */
    private static String wordLongerThanLengthBreaksAtLength(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        String columnText = text.substring(0, columnSize + 1);
        int space = columnText.lastIndexOf(' ');

        if (space >= 0)
            return text.substring(0, space) + "\n" + wrap(text.substring(space + 1), columnSize);
        return text.substring(0, columnSize) + "\n" + text.substring(columnSize);
    }

    /**
     * assertEquals("very\nlong\nword", wrap("verylongword", 4));
     * 9. (statement->recursion)
     */
    private static String wordLongerThanTwiceLengthShouldBreakTwice(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        String columnText = text.substring(0, columnSize + 1);
        int space = columnText.lastIndexOf(' ');

        if (space >= 0)
            return text.substring(0, space) + "\n" + wrap(text.substring(space + 1), columnSize);
        return text.substring(0, columnSize) + "\n" + wrap(text.substring(columnSize), columnSize);
    }
}
