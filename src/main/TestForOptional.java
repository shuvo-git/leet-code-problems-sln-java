package main;


class Abcd {
    int p;
    Abcd(int p) {
        this.p = p;
    }
}

public class TestForOptional {
    public Abcd getAbcd() {
        return new Abcd(4);
    }
}
