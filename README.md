[![Build Status](https://travis-ci.org/DominoKit/domino-event-bus.svg?branch=master)](https://travis-ci.org/DominoKit/domino-event-bus)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.dominokit/domino-event-bus/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.dominokit/domino-event-bus)
![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/org.dominokit/domino-event-bus.svg)


# domino-event-bus

## Setup

### Maven dependency

- Add the following dependency to the backend module
```xml
<dependency>
    <groupId>org.dominokit</groupId>
    <artifactId>vertx-domino-event-bus-backend</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

- Add the following dependency to the frontend module
```xml
<dependency>
    <groupId>org.dominokit</groupId>
    <artifactId>vertx-domino-event-bus-shared</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

- Add these dependencies to the frontend shell project
```xml
<dependency>
    <groupId>org.dominokit</groupId>
    <artifactId>vertx-domino-event-bus-frontend</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>org.dominokit</groupId>
    <artifactId>vertx-domino-event-bus-frontend</artifactId>
    <version>1.0-SNAPSHOT</version>
    <classifier>sources</classifier>
</dependency>
<dependency>
    <groupId>org.dominokit</groupId>
    <artifactId>vertx-domino-event-bus-frontend-ui</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>org.dominokit</groupId>
    <artifactId>vertx-domino-event-bus-frontend-ui</artifactId>
    <version>1.0-SNAPSHOT</version>
    <classifier>sources</classifier>
</dependency>
```

- Add these two lines on your html page
```xml
<script src="/static/bower_components/sockjs/sockjs.min.js"></script>
<script src="/static/bower_components/vertx3-eventbus-client/vertx-eventbus.js"></script>
```

> To use the snapshot version without building locally, configure the snapshot repository
```xml
<repository>
   <id>sonatype-snapshots-repo</id>
   <url>https://oss.sonatype.org/content/repositories/snapshots</url>
   <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
      <checksumPolicy>fail</checksumPolicy>
   </snapshots>
</repository>
```

## Sample

```java

// In your backend, publish message to the event bus
vertxContext.vertx().setPeriodic(1000, event -> vertxContext.vertx().eventBus().publish(VertxBusContext.DEFAULT_SOCKJS_ADDRESS, new Random().nextInt()));

// In your frontend, listen to the messages
StoreRegistry.INSTANCE.<VertxBusContext>consumeData(VertxBusContext.EVENT_BUS_STORE, vertxBusContext -> {
            vertxBusContext.registerMessageHandler(VertxBusContext.DEFAULT_SOCKJS_ADDRESS, (VertxBusContext.EventBusMessageHandler<Number>) message -> {
                // handle message
                
            });
        });
```




