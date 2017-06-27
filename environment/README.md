# Docker Environment

This folder provides a Docker environment that can be used to run Spring Applications in Tomcat for the course.

NOTE: If using Intellij to develop the coursework ensure you install a local copy of Tomcat for Intellij to pull its binaries from.

See [this question](https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000405164-Docker-Tomcat?page=1#community_comment_115000349104).

## Requirements

- Docker [Mac](https://docs.docker.com/docker-for-mac/) [Windows](https://docs.docker.com/docker-for-windows/)

## Run

Start:

Mac:

```
export HOST_IP=`ipconfig getifaddr en0` && docker-compose up
```

Windows:

```
TBC
```

NOTE: `HOST_IP` is required by the Java Remote Debugger for Tomcat, it should be set to the IP address of the primary external IP address of your machine on your local LAN.

NOTE: If one moves from one network type to another (wired to wireless) the remote debugging port will stop working, as Java will only accept connections from the known IP address. Simply restart the containers if the network changes.

## Stop

On mac hit `Ctr-c` to stop docker-compose.

## Tomcat Version

The Tomcat version is controlled by the `./services/tomcat.yml` file, it is the image name.

## Remote Debugging Config

The remote debugging config is setup by the environment variables in `./env/tomcat.env` and the `HOST_IP` which is set by the command line and the `environment` config on the `./services/tomcat.yml` file passing through that value from the host to the container.

## Intellij Config

Create a `Tomcat: Remote` Run Configuration and config it like so:

![Intellij Config](https://raw.githubusercontent.com/gregorskii/udemy-spring/master/environment/readme-assets/project-config-run.png)

NOTE: name it whatever you like, but remember it for below.

Ensure the Spring project has a artifact of `Web Application: Exploded`:

![Intellij Config](https://raw.githubusercontent.com/gregorskii/udemy-spring/master/environment/readme-assets/project-config-artifacts.png)

Ensure the Run configuration is set to deploy the exploded WAR:

![Intellij Config](https://raw.githubusercontent.com/gregorskii/udemy-spring/master/environment/readme-assets/project-config-deployment.png)

## Running Intellij Run Mode

Click the run icon with the Run Configuration for `Tomcat: Remote` selected.

If everything worked the output should look like this:

```
[2017-06-27 11:01:07,600] Artifact spring-mvc: Server is not connected. Deploy is not available.
Connected to server
[2017-06-27 11:01:07,777] Artifact spring-mvc: Artifact is being deployed, please wait...
```

Once completed you should be able to create breakpoints and debug the Spring application in your browser.
