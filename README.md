# Corona Statistic Scraping Tools

### Dependecies

make sure you have installed several things below :

* [spring-boot] - version 2.2.6.RELEASE
* [maven](https://maven.apache.org/) - version 3.3+
* [java](https://openjdk.java.net/) - version 8.0 or above
* [tomcat](http://tomcat.apache.org/) - version 9.0

### IDE

we use [IntelliJ IDEA](https://www.jetbrains.com/idea/)

### Installation

```sh
$ git clone https://github.com/vani071/Scrapping-Corona-Stats.git corona-scraping-tools
$ cd corona-scraping-tools
$ mvn install
```

For build into jar

```sh
$ mvn  clean package -DskipTests
```

for run the jar as service in dev profile
```sh
$ nohup java -Xmx256m -Xms128m -jar scraping-corona-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev &
```
for run the jar as service in prod profile
```sh
$ nohup java -Xmx256m -Xms128m -jar scraping-corona-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod &
```

please share if you find this repo useful!

   [spring-boot]: <https://spring.io/projects/spring-boot>
