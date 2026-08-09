package utility;

public final class TestData {

    private TestData() {
    }

    private static final String EMAIL =
            "user" + System.currentTimeMillis() + "@gmail.com";

    public static String getEmail() {
        return EMAIL;
    }
}
