package be.rommens.aof2021.model;

import static java.lang.Integer.parseInt;

/**
 *
 */
public class Measurement {

    private final int depth;

    public Measurement(int depth) {
        this.depth = depth;
    }

    public Measurement(String rawDepth) {
        this.depth = parseInt(rawDepth);
    }

    public int getDepth() {
        return depth;
    }
}
