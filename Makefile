DESTDIR ?= /usr/local/share/java
VERSION = 2.0.0

.PHONY: build
build: clean Makefile src/edu/harvard/CS50.java
	mkdir -p build/usr/share/java
	javac -d build src/edu/harvard/CS50.java
	cp src/edu/harvard/CS50.java build/edu/harvard
	jar cvf build/usr/share/java/cs50.jar -C build .

.PHONY: clean
clean:
	rm -rf build libcs50-java* libcs50-java_*

.PHONY: deb
deb: build
	@echo "libcs50-java ($(VERSION)-0ubuntu1) trusty; urgency=low" > debian/changelog
	@echo "  * v$(VERSION)" >> debian/changelog
	@echo " -- CS50 Sysadmins <sysadmins@cs50.harvard.edu>  $$(date --rfc-2822)" >> debian/changelog
	mkdir -p libcs50-java-$(VERSION)
	rsync -a build/usr libcs50-java-$(VERSION)
	tar -cvzf libcs50-java_$(VERSION).orig.tar.gz libcs50-java-$(VERSION)
	cp -r debian libcs50-java-$(VERSION)
	cd libcs50-java-$(VERSION) && debuild -S -sa --lintian-opts --display-info --info --show-overrides
	mkdir -p build/deb
	mv libcs50-java* build/deb

.PHONY: docs
docs:
	rm -rf docs
	javadoc -d docs  -linkoffline https://docs.oracle.com/javase/8/docs/api/ \
		https://docs.oracle.com/javase/8/docs/api/ -sourcepath src edu.harvard

.PHONY: install
install: build
	mkdir -p $(DESTDIR)
	cp -r build/usr/share/java/cs50.jar $(DESTDIR)

.PHONY: version
version:
	@echo $(VERSION)
