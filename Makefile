DESTDIR ?= /usr/local/share/java
VERSION = 3.0.0

all: build docs deb jar

.PHONY: build
build: Makefile src/edu/harvard/CS50.java
	mkdir -p build/lib
	javac -d build/lib src/edu/harvard/CS50.java
	cp src/edu/harvard/CS50.java build/lib/edu/harvard

.PHONY: jar
jar: build
	mkdir -p build/jar
	jar cvf build/jar/cs50.jar -C build/lib .

.PHONY: clean
clean:
	rm -rf build

.PHONY: deb
deb: jar
	rm -rf build/deb
	mkdir -p build/deb/libcs50-java/usr/share/java
	cp -r build/jar/* build/deb/libcs50-java/usr/share/java

	fpm \
	    --category java \
	    --conflicts lib50-java \
	    --chdir build/deb/libcs50-java \
	    --deb-priority optional \
	    --description "CS50 library for Java" \
	    --input-type dir \
	    --license "MIT" \
	    --maintainer "CS50 <sysadmins@cs50.harvard.edu>" \
	    --name libcs50-java \
	    --output-type deb \
	    --package build/deb \
	    --provides lib50-java \
	    --provides libcs50-java \
	    --replaces lib50-java \
	    --replaces libcs50-java \
	    --url https://github.com/cs50/libcs50-java \
	    --vendor CS50 \
	    --version $(VERSION) \
	    .

	rm -rf build/deb/libcs50-java

.PHONY: rpm
rpm: jar
	rm -rf build/rpm
	mkdir -p build/rpm/libcs50-java/usr/share/java
	cp -r build/jar/* build/rpm/libcs50-java/usr/share/java

	fpm \
	    --category java \
	    --conflicts lib50-java \
	    --chdir build/rpm/libcs50-java \
	    --description "CS50 library for Java" \
	    --input-type dir \
		--license "MIT" \
	    --maintainer "CS50 <sysadmins@cs50.harvard.edu>" \
	    --name libcs50-java \
	    --output-type rpm \
	    --package build/rpm \
	    --provides libcs50-java \
	    --url https://github.com/cs50/libcs50-java \
	    --vendor CS50 \
	    --version $(VERSION) \
	    .

	rm -rf build/rpm/libcs50-java

.PHONY: docs
docs:
	rm -rf docs
	javadoc -d docs  -linkoffline https://docs.oracle.com/javase/8/docs/api/ \
		https://docs.oracle.com/javase/8/docs/api/ -sourcepath src edu.harvard

.PHONY: install
install: build
	mkdir -p $(DESTDIR)
	cp -r build/jar/cs50.jar $(DESTDIR)

.PHONY: version
version:
	@echo $(VERSION)
