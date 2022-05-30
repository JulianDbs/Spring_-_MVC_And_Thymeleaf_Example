# Spring MVC AND Thymeleaf Example
> An example of a Responsive Web Site using Spring MVC and Thymeleaf.

## Table of Contents
* [Technologies Used](#technologies-used)
* [Application Screenshots](#application-screenshots)
* [Unitary Tests Screenshots](#unitary-test-screenshots)
* [Setup and Usage Linux](#setup-and-usage-linux)
* [Test JUnit 5 Tests Linux](#test-junit-5-tests-linux)
* [Acknowledgements](#acknowledgements)
* [Contact](#contact)


## Technologies Used
- Java - version 11
- Spring - version 2.6.7
- Gradle - version 7.4.1
- Spring Web - version 5.3.19
- Thymeleaf - version 3.0.15
- JUnit 5 - version 5.8.1
- HTML
- CSS
- JavaScript


## Application Screenshots
![Example screenshot 0](./README_IMG/app_image_00.jpg)
![Example screenshot 1](./README_IMG/app_image_01.jpg)
![Example screenshot 2](./README_IMG/app_image_02.jpg)
![Example screenshot 3](./README_IMG/app_image_03.jpg)
![Example screenshot 4](./README_IMG/app_image_04.jpg)
![Example screenshot 5](./README_IMG/app_image_05.jpg)
![Example screenshot 6](./README_IMG/app_image_06.jpg)
![Example screenshot 7](./README_IMG/app_image_07.jpg)
![Example screenshot 8](./README_IMG/app_image_08.jpg)
![Example screenshot 9](./README_IMG/app_image_09.jpg)
![Example screenshot 10](./README_IMG/app_image_10.jpg)

## Unitary Tests Screenshots
![Unitary Test Screenshot 0](./README_IMG/test_app_00.jpg)
![Unitary Test Screenshot 1](./README_IMG/test_app_01.jpg)
![Unitary Test Screenshot 2](./README_IMG/test_app_02.jpg)
![Unitary Test Screenshot 3](./README_IMG/test_app_03.jpg)
![Unitary Test Screenshot 4](./README_IMG/test_app_04.jpg)
![Unitary Test Screenshot 5](./README_IMG/test_app_05.jpg)
![Unitary Test Screenshot 6](./README_IMG/test_app_06.jpg)
![Unitary Test Screenshot 7](./README_IMG/test_app_07.jpg)
![Unitary Test Screenshot 8](./README_IMG/test_app_08.jpg)
![Unitary Test Screenshot 9](./README_IMG/test_app_09.jpg)
![Unitary Test Screenshot 10](./README_IMG/test_app_10.jpg)


## Setup and Usage Linux

0. Open a Terminal.
1. Clone the GitHub repository.
2. Go to the main project directory.
3. Execute the following command :
```
	$ sudo ./gradlew bootrun 
```
4. Open your favorite browser and got to http://localhost:8080/

## Test JUnit 5 Tests Linux
> Extracted from https://mkyong.com/junit5/junit-5-consolelauncher-examples/

0. Clone the GitHub repository.
1. Download the last version of ['junit-platform-console-standalone.jar'](https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/) from the Maven Central repository.
![Get JUnit platform console standalone](./README_IMG/get_junit_platform_console_standalone_0.jpg)
![Get JUnit platform console standalone](./README_IMG/get_junit_platform_console_standalone_1.jpg)

2. Put the 'junit-platform-console-standalone-1.9.*.jar' in the main project directory.

3. Open a Terminal.
4. Go to the main project directory.
5. Run the following command :

```
	$ java -jar junit-platform-console-standalone-1.9.0-M1.jar -cp ./build/classes/java/test/:./build/classes/java/main/ --select-package='com.juliandbs.springmvcthymeleafexample' --details=verbose
```


## Acknowledgements
- This project was based on : [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)


## Contact
Created by [@_julian_dbs](https://twitter.com/_julian_dbs)