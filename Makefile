DESCRIPTION = CS50 Library for Java
MAINTAINER = CS50 <sysadmins@cs50.harvard.edu>
NAME = lib50-java
VERSION = 2.0.0

BUILD_DIR = build
DEB_DIR = $(BUILD_DIR)/deb
DOCS_DIR = docs
JAR_DIR = $(BUILD_DIR)/usr/java/packages/lib/ext
PACMAN_DIR = $(BUILD_DIR)/pacman
RPM_DIR = $(BUILD_DIR)/rpm

.PHONY: all
all: clean deb pacman rpm

.PHONY: bash
bash:
	docker run -i --rm -t -v "$(PWD):/root" cs50/cli

.PHONY: build
build: clean Makefile src/edu/harvard/CS50.java
	mkdir -p "$(JAR_DIR)"
	javac -d "$(BUILD_DIR)" src/edu/harvard/CS50.java
	jar cvf "$(JAR_DIR)/cs50.jar" -C "$(BUILD_DIR)" .
	find "$(BUILD_DIR)" -type d -exec chmod 0755 {} +
	find "$(BUILD_DIR)" -type f -exec chmod 0644 {} +

.PHONY: clean
clean:
	rm -rf "$(BUILD_DIR)"

.PHONY: deb
deb: build
	mkdir -p "$(DEB_DIR)"
	fpm \
	-C "$(BUILD_DIR)" \
	-m "$(MAINTAINER)" \
	-n "$(NAME)" \
	-p "$(DEB_DIR)" \
	-s dir \
	-t deb \
	-v "$(VERSION)" \
	--deb-no-default-config-files \
	--depends java7-runtime \
	--description "$(DESCRIPTION)" \
	usr

.PHONY: docs
docs:
	rm -rf $(DOCS_DIR)
	javadoc -d "$(DOCS_DIR)" -sourcepath src edu.harvard

# TODO: add dependencies
.PHONY: pacman
pacman: build
	mkdir -p "$(PACMAN_DIR)"
	fpm \
	-C "$(BUILD_DIR)" \
	-m "$(MAINTAINER)" \
	-n "$(NAME)" \
	-p "$(PACMAN_DIR)" \
	-s dir \
	-t pacman \
	-v "$(VERSION)" \
	--description "$(DESCRIPTION)" \
	usr

# TODO: add dependencies
.PHONY: rpm
rpm: build
	mkdir -p "$(RPM_DIR)"
	fpm \
	-C "$(BUILD_DIR)" \
	-m "$(MAINTAINER)" \
	-n "$(NAME)" \
	-p "$(RPM_DIR)" \
	-s dir \
	-t rpm \
	-v "$(VERSION)" \
	--description "$(DESCRIPTION)" \
	usr
