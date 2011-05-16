NAME=app05
TOMCAT_WEBAPPS=/usr/local/apache-tomcat-7.0.8/webapps/

all:

create:
	mkdir pages
	mkdir config
	mkdir config/WEB-INF
	mkdir config/WEB-INF/lib

clean:
	rm -rf war
	find -name "*~" | xargs rm -rf
	rm -rf $(NAME).war

war: clean
	mkdir war
	cp -ax pages/* war/
	cp -ax config/* war/
	jar cvf $(NAME).war -C war .
	cp $(NAME).war $(TOMCAT_WEBAPPS)
