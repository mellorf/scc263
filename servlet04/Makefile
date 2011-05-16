NAME=servlet04
TOMCAT_WEBAPPS=/usr/local/apache-tomcat-7.0.8/webapps/
CLASSPATH=/usr/local/apache-tomcat-7.0.8/lib/servlet-api.jar:config/WEB-INF/classes
# WAR - Web Application Archive

all:
	javac -d config/WEB-INF/classes -cp $(CLASSPATH) src/org/usp/$(NAME)/**/*.java

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
	mkdir -p config/WEB-INF/classes/org/usp/$(NAME)/bundles
	cp src/org/usp/$(NAME)/bundles/*.properties config/WEB-INF/classes/org/usp/$(NAME)/bundles/
	cp -ax pages/* war/
	cp -ax config/* war/
	jar cvf $(NAME).war -C war .
	cp $(NAME).war $(TOMCAT_WEBAPPS)
