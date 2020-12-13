# ONEIO Assignment
This project is developed as an assignment for ONEIO as an evaluation test. The project is a Fiz Buzz game which is played with a number with two divisibles and generate correct string responses for each number either Fizz, Buzz, FizzBuzz, or a number itself.

<b>Technologies used</b>

Following are the technologies used to developed this project.

1. Java8
2. Spring Boot
3. Maven
4. Junit
5. Docker

<b> Detailed description </b>

This is a maven based dockerized REST API project, which is build in Java8 and spring boot framework has been used to develop the REST API. The tests cases to validate the function logic have been developed which resides in src/test/java/FizzBuzzApplicationTests.java file. As there seems no need for the database interaction, and to make it simple controller and services layer has been developed. 

<b> How to run </b>

For ease this project has been dockerized and there is a DockerFile in the project root directory. Port 8080 has been exposed and the project can be run by running the following commands.

<b> docker build -f DockerFile -t fizzbuzz . </b>
<b> docker run -p 8080:8080 fizzbuzz </b>
  
The docker image has also been published on Docker Hub and can be found via url : https://hub.docker.com/r/furqanahmed1988/fizzbuzz
