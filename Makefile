all: build docs

build:
	find src -type f -name "*.java" -exec javac {} \;

docs: build
	rm -rf docs
	javadoc -d docs -sourcepath src edu.harvard

