#!/bin/bash
mvn archetype:generate \
    -DarchetypeGroupId=org.dominokit.domino.archetypes \
    -DarchetypeArtifactId=domino-gwt-module-archetype \
    -DarchetypeVersion=1.0-rc.4-SNAPSHOT \
    -DarchetypeParentGroupId=org.dominokit \
    -DarchetypeParentArtifactId=domino-event-bus \
    -DarchetypeParentVersion=1.0-SNAPSHOT \
    -DgroupId=org.dominokit \
    -DartifactId=$1 \
    -Dmodule=${1^} \
    -Dsubpackage=$1