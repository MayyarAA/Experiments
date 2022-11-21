## How to run this project

## If mayyarutils is published

### Step 1: build multiThreadingOne
`mvn clean install`

### Step 2: run multiThreadingOne

`java -cp target/classes main.App`


## If mayyarutils is not published

#### you will need to use a local maven repository to build multiThreadingOne

### Step 1: clone mayyarutils locally
`git clone https://github.com/MayyarAA/mayyarutils.git`


### Step 2: build & release mvn project mayyarutils locally
`mvn clean install`


### Step 3: clone multiThreadingOne locally

`git clone https://github.com/MayyarAA/mayyarutils/tree/main`

### Step 4: build multiThreadingOne
`mvn clean install`

### Step 5: run multiThreadingOne
Try running project in intellij and copying classs path

`java -classpath /Users/mayyaral-atari/Desktop/work/experiments/java/quickTakes/target/classes:/Users/mayyaral-atari/.m2/repository/org/mayyar/utils/mayyarutils/1.0-SNAPSHOT/mayyarutils-1.0-SNAPSHOT.jar main.App
`




