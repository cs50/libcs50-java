DESCRIPTION = CS50 Library for Java
MAINTAINER = CS50 <sysadmins@cs50.harvard.edu>
NAME = lib50-java
VERSION = 1.0.0

BUILD_DIR = build
JAR_DIR = $(BUILD_DIR)/usr/java/packages/lib/ext

.PHONY: bash
bash:
	docker run -i --rm -t -v "$(PWD):/root" cs50/cli

.PHONY: build
build: clean Makefile src/edu/harvard/CS50.java
	mkdir -p "$(JAR_DIR)"
	javac -d "$(BUILD_DIR)" src/edu/harvard/CS50.java
	jar cvf "$(JAR_DIR)/cs50.jar" -C build .
	javadoc -d "$(BUILD_DIR)/docs" -sourcepath src edu.harvard
	find build -type d -exec chmod 0755 {} +
	find build -type f -exec chmod 0644 {} +

.PHONY: clean
clean:
	rm -rf build

.PHONY: deb
deb: build
	fpm \
	-C "$(BUILD_DIR)" \
	-m "$(MAINTAINER)" \
	-n "$(NAME)" \
	-p "$(BUILD_DIR)" \
	-s dir \
	-t deb \
	-v "$(VERSION)" \
	--deb-no-default-config-files \
	--depends java7-runtime \
	--description "$(DESCRIPTION)" \
	usr

# TODO: add dependencies
.PHONY: pacman
pacman: build
	rm -f "$(NAME)-$(VERSION)-*.pkg.tar.xz"
	fpm \
	-C "$(BUILD_DIR)" \
	-m "$(MAINTAINER)" \
	-n "$(NAME)" \
	-p "$(BUILD_DIR)" \
	-s dir \
	-t pacman \
	-v "$(VERSION)" \
	--description "$(DESCRIPTION)" \
	usr

# TODO: add dependencies
.PHONY: rpm
rpm: build
	rm -f "$(NAME)-$(VERSION)-*.rpm"
	fpm \
	-C "$(BUILD_DIR)" \
	-m "$(MAINTAINER)" \
	-n "$(NAME)" \
	-p "$(BUILD_DIR)" \
	-s dir \
	-t rpm \
	-v "$(VERSION)" \
	--description "$(DESCRIPTION)" \
	usr
