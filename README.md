# Getting started

## Parts

The backend is in, backend
External services (FX) is in external services
Shared contains shard code, and a seperation of say domain logic (showcase)

The bruno folder contains bruno requests



## dependencies

## Running server

this will run a local dev server

```bash
./gradlew :backend:quarkusdev
```

## Building docker image

Will create a docker image with the jvm

```bash
./gradlew :backend:buildDockerImage
```

## Build graalvm native docker image

Will create a docker image based on a graalvm native image

```bash
./gradlew :backend:buildNativeAotDocker
```

