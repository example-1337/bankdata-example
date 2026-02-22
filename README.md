# Getting started

## Parts

The backend is in the folder backend
The frontend is in the folder frontend
External services (FX) is in external services
Shared contains shard code, and a seperation of say domain logic (showcase)

The bruno folder contains bruno requests for the backend and external services

## dependencies

## Running server

this will run a local dev server (backend)

```bash
./gradlew :backend:quarkusdev
```

and should start at port 8080

the frontend requires

```bash
./gradlew :frontend:jsBrowserDevelopmentRun
```

and will (if started after the backend) run on port 8081

## Building docker image (backend)

Will create a docker image with the jvm

```bash
./gradlew :backend:buildDockerImage
```

## Build graalvm native docker image (backend)

Will create a docker image based on a graalvm native image

```bash
./gradlew :backend:buildNativeAotDocker
```

