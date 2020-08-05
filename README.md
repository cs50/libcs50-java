# CS50 Library for Java

## Documentation

http://cs50.github.io/libcs50-java/edu/harvard/CS50.html

## Pacakge Cloud

https://packagecloud.io/MuhammadHassanRazaa/libcs50-java/packages/java/edu.harvard/libcs50-java-1.0.jar

## Development

```
    make build # builds class
    make jar # builds jar
    make docs # builds documentation
    make deb # builds deb package
```

## Installation

### Ubuntu

```
$ curl -s https://packagecloud.io/install/repositories/cs50/repo/script.deb.sh | sudo bash
$ sudo apt-get install libcs50-java
```

### Fedora

```
$ curl -s https://packagecloud.io/install/repositories/cs50/repo/script.rpm.sh | sudo bash
$ sudo yum install libcs50-java
```

### From Source

1. Download the latest release from https://github.com/cs50/libcs50-java/releases
1. Extract `libcs50-java*`
1. cd `libcs50-java*`
1. `make install # may require sudo`

By default, we install to `/usr/local/share/java`. If you'd like to change the installation location, run `DESTDIR=/path/to/install make install` as desired.


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
