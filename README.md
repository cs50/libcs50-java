# CS50 Library for Java

## Documentation

http://cs50.github.io/libcs50-java/edu/harvard/CS50.html

## Development

```
    make build # builds class and JAR file
    make docs # builds documentation
    make deb # builds source deb package
```

## Usage

    // assuming cs50.jar is in $CLASSPATH
    import edu.harvard.CS50;

    ...

    char c = CS50.getChar();
    double d = CS50.getDouble();
    float f = CS50.getFloat();
    int i = CS50.getInt();
    long l = CS50.getLong();
    String s = CS50.getString();

## TODO

* Decide if keeping `CS50.eprintf`.
* Add tests.
