public class StubNumberGenerator implements NumberGenerator {

    private int stubInt;

    public StubNumberGenerator(int stubInt) {
        this.stubInt = stubInt;
    }

    @Override
    public int getInt() {
        return stubInt;
    }
}
