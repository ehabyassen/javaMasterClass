To make the project compile successfully, add the jar 'imq-4.2.jar' in the parent directory to the class path 
of this project.

To run the project successfully

1- Make sure you have jdk21 installed. To check your java version, execute: java -version

2- Create a new directory to clone the OpenMQ project into.

3- Open a new terminal and navigate to that directory.

3- git clone https://github.com/eclipse-ee4j/openmq.git

3- cd openmq

4- mvn clean install

5- cd mq/dist/mq/bin

6- Run the process 'imqbrokerd'. For linux -> ./imqbrokerd

