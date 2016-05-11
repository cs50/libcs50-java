# CS50 Library for Java

## Development

Requires [Docker Toolbox](https://www.docker.com/products/docker-toolbox).

    docker-compose run cli # runs CS50 CLI
    make all # builds all
    make build # builds src/edu/harvard/CS50.java as build/edu/harvard/CS50.class
    make docs # builds documentation in docs/
    make lib # builds JAR file in jar/

## Usage

    // assuming cs50.jar is in $CLASSPATH
    import edu.harvard.CS50;

    ...

    double d = CS50.getDouble();
    float f = CS50.getFloat();
    int i = CS50.getInt();
    long l = CS50.getLong();
    String s = CS50.getString();
