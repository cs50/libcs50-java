# CS50 Library for Java

## Building

    # compiles src/edu/harvard/CS50.java as build/edu/harvard/CS50.class
    make build

    # builds documentation in docs
    make docs

    # builds JAR file
    make lib

## Usage

    // assuming `cs50.jar` is in `CLASSPATH`
    import edu.harvard.CS50;

    ...

    double d = CS50.getDouble();
    float f = CS50.getFloat();
    int i = CS50.getInt();
    long l = CS50.getLong();
    String s = CS50.getString();
