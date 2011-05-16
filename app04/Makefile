all:

create:
	mkdir config
	mkdir pages
	mkdir config/WEB-INF

war:
	mkdir war
	cp -ax config/* war/
	cp -ax pages/* war/
	jar cvf app04.war -C war .
	cp app04.war /usr/local/apache-tomcat-7.0.8/webapps/

clean:
	find -name "*~" | xargs rm -rf
	rm -rf war
