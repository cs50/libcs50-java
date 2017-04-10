# CS50 Library for Java

## Documentation

http://cs50.github.io/lib50-java/edu/harvard/CS50.html

## Development

Requires [Docker Toolbox](https://www.docker.com/products/docker-toolbox).

    make bash # runs CS50 CLI
    make all # builds all
    make build # builds class and JAR file in build/edu/harvard/ and build/usr/java/packages/lib/ext
    make docs # builds documentation in build/docs/
    make deb # builds deb package in build/deb/
    make pacman # builds pacman package in build/pacman/
    make rpm # builds rpm package in build/rpm/

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
