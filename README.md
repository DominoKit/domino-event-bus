# How to run

- #### run `mvn clean install` to build

- #### Run for development :

  - ##### For super dev mode 
  
    - In one terminal run `mvn gwt:codeserver -pl *-frontend -am`
    
    - In another terminal `cd domino-event-bus-backend`
    - execute `mvn exec:java`
    - the server port will be printed in the logs access the application on `http://localhost:[port]`
    
    - For debuging client code in intellij please install the following chrome plugin
    
    https://chrome.google.com/webstore/detail/jetbrains-ide-support/hmhgeddbohgjknpmjagkdomcpobmllji
    
    then execute the `js-debug` run configuration in debug mode. 

  - ##### For gwt compiled mode 
  
    - `cd domino-event-bus-backend`
    - execute `mvn exec:java -Dmode=compiled`
    - the server port will be printed in the logs access the application on `http://localhost:[port]`

  - ##### For production mode 
  
    - `cd domino-event-bus-backend`
    - execute `java -jar target/domino-event-bus-backend-1.0-SNAPSHOT-fat.jar`
    - the server port will be printed in the logs access the application on `http://localhost:[port]`
