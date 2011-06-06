all: clean
	mkdir build
	javac src/Funcao.java -d build
	mkdir aar
	cp -ax build/* aar/
	mkdir aar/META-INF
	cp services.xml aar/META-INF/
	jar cvf Funcao.aar -C aar .

clean:
	rm -rf aar build *.aar *~
