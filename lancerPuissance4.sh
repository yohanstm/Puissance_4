javac --source-path ./src -d ./bin --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls src/Puissance4.java
java -cp ./bin:/usr/share/java/mariadb-java-client.jar --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls Puissance4

