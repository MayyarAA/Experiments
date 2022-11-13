## How to create similar project via mvn
`mvn archetype:generate -DgroupId=com.mayyar.codeOne -DartifactId=mayyarCodeOne 
-DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

## How to build project

`mvn clean package`

## How to run project after build

`java -cp target/classes com.mayyar.codeOne.App`
