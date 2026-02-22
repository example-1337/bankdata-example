# Getting started

## Parts

The backend is in the folder backend

The frontend is in the folder frontend

External services (FX) is in external services

Shared contains shard code, and a seperation of say domain logic (showcase)

The bruno folder contains bruno requests for the backend and external services

## Running

### Running Database

Before the server can start you need to start the database.
Using docker compose

```bash
docker compose -f docker/docker-compose.yml up -d
```

### Running (backend) server

This will run a local dev server (backend)

```bash
./gradlew :backend:quarkusdev
```

And should start at port 8080

### Running (frontend) server

Thr frontend requires

```bash
./gradlew :frontend:jsBrowserDevelopmentRun
```

And will (if started after the backend) run on port 8081

## docker image(s)

### Building docker image (backend)

Will create a docker image with the jvm

```bash
./gradlew :backend:buildDockerImage
```

### Build graalvm native docker image (backend)

Will create a docker image based on a graalvm native image

```bash
./gradlew :backend:buildNativeAotDocker
```
