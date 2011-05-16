NAME=app06
TOMCAT_WEBAPPS=/usr/local/apache-tomcat-7.0.8/webapps/

all:
	javac -d config/WEB-INF/classes src/org/usp/$(NAME)/config/*.java
	javac -cp config/WEB-INF/classes -d config/WEB-INF/classes src/org/usp/$(NAME)/db/*.java

create:
	mkdir pages
	mkdir config
	mkdir config/WEB-INF
	mkdir config/WEB-INF/lib
	mkdir config/WEB-INF/classes
	mkdir -p src/org/usp/$(NAME)/db
	mkdir -p src/org/usp/$(NAME)/core
	mkdir -p src/org/usp/$(NAME)/config

clean:
	rm -rf war
	rm -rf config/WEB-INF/classes/*
	find -name "*~" | xargs rm -rf
	rm -rf $(NAME).war

war: clean all
	mkdir war
	cp -ax pages/* war/
	cp -ax config/* war/
	jar cvf $(NAME).war -C war .
	cp $(NAME).war $(TOMCAT_WEBAPPS)
