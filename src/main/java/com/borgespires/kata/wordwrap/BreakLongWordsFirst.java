package com.borgespires.kata.wordwrap;

import static java.util.Objects.isNull;

public class BreakLongWordsFirst {

    public static String wrap(String text, int columnSize) {
//        return wrapNullReturnsEmptyString(text, columnSize);
//        return oneShortWordDoesNotWrap(text, columnSize);

        // break long words
//        return wordLongerThanLengthBreaksAtLength(text, columnSize);
//        return wordLongerThanTwiceLengthShouldBreakTwice(text, columnSize);

        // break at space
//        return twoWordsLongerThanLimitShouldWrap(text, columnSize);
//        return threeWordsEachLongerThanLimitShouldWrap(text, columnSize);
//        return threeWordsJustOverTheLimitShouldWrapAtSecondWord(text, columnSize);
        return twoWordsTheFirstEndingAtTheLimit(text, columnSize);
    }

    /**
     * wrap(null, 10) == ""
     * 1.(nil->constant)
     */
    private static String wrapNullReturnsEmptyString(String text, int columnSize) {
        return "";
    }

    /**
     * wrap("word", 5) == "word"
     * 6.(unconditional->if)
     * 4.(constant->scalar)
     */
    private static String oneShortWordDoesNotWrap(String text, int columnSize) {
        if (isNull(text)) return "";
        return text;
    }

    /**
     * Two steps:
     * => splitting the execution pathways first by adding an if and returning a constant
     * assertEquals("long\nword", wrap("longword", 4));
     * 6.(unconditional->if)
     *
     * => and then generalising
     * "The next test is completely obvious. We’ve got to get rid of that constant."
     * assertEquals("longer\nword", wrap("longerword", 6));
     * 11.(expression->function)
     */
    private static String wordLongerThanLengthBreaksAtLength(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;
        return text.substring(0, columnSize) + "\n" + text.substring(columnSize);
    }

    /**
     * assertEquals("very\nlong\nword", wrap("verylongword", 4));
     * 9.(statement->recursion)
     *
     * "It is also possible to pass this test with (if->while)"
     *
     * The argument that recursion is simpler than iteration...
     * Is this true for all cases or is it situational?
     */
    private static String wordLongerThanTwiceLengthShouldBreakTwice(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;
        return text.substring(0, columnSize) + "\n" + wrap(text.substring(columnSize), columnSize);
    }

    /**
     * Two steps:
     * assertEquals("word\nword", wrap("word word", 6));
     * 6. (unconditional->if)
     *
     * assertEquals("wrap\nhere", wrap("wrap here", 6));
     * 11. (expression->function)
     *
     * indexOf() not counted as function transformation
     */
    private static String twoWordsLongerThanLimitShouldWrap(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        int space = text.indexOf(" ");
        if (space >= 0)
            return text.substring(0, space) + "\n" + text.substring(space + 1);
        return text.substring(0, columnSize) + "\n" + wrap(text.substring(columnSize), columnSize);
    }

    /**
     * assertEquals("word\nword\nword", wrap("word word word", 6));
     *  9. (statement->recursion)
     */
    private static String threeWordsEachLongerThanLimitShouldWrap(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        int space = text.indexOf(" ");
        if (space >= 0)
            return text.substring(0, space) + "\n" + wrap(text.substring(space+1), columnSize);
        return text.substring(0, columnSize) + "\n" + wrap(text.substring(columnSize), columnSize);
    }

    /**
     * assertEquals("word word\nword", wrap("word word word", 11));
     * 11. (expression->function)
     */
    private static String threeWordsJustOverTheLimitShouldWrapAtSecondWord(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        int space = text.substring(0, columnSize).lastIndexOf(" ");
        if (space >= 0)
            return text.substring(0, space) + "\n" + wrap(text.substring(space+1), columnSize);
        return text.substring(0, columnSize) + "\n" + wrap(text.substring(columnSize), columnSize);
    }

    /**
     * assertEquals("word\nword", wrap("word word", 4));
     * 11. (statement->function) => add(length, 1)
     */
    private static String twoWordsTheFirstEndingAtTheLimit(String text, int columnSize) {
        if (isNull(text)) return "";
        if (text.length() <= columnSize) return text;

        int space = text.substring(0, columnSize + 1).lastIndexOf(" ");
        if (space >= 0)
            return text.substring(0, space) + "\n" + wrap(text.substring(space+1), columnSize);
        return text.substring(0, columnSize) + "\n" + wrap(text.substring(columnSize), columnSize);
    }
}
