[![Build Status](https://app.travis-ci.com/FrankChen021/bithon.svg?branch=master)](https://app.travis-ci.com/github/FrankChen021/bithon)

---

# What's Bithon

Bithon is a word combining binocular together with python.

It targets application metrics, logging, distributed tracing, alert and application risk governance under micro-service environment.

# Demon

A preview demo is hosted [here](https://www.bithon.org:9897/web/home).

# Build

## 1. clone source code

After clone this project, remember to clone the submodules.

```bash
git submodule update --init
```

## 2. choose a right JDK

JDK 1.8 is recommended because the agent is compatible with higher JRE that is used to run your Java applications.

If you have multiple JDKs on your machine, use `export JAVA_HOME={YOUR_JDK_HOME}` command to set correct JDK.

For example

```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk-8.jdk/Contents/Home
```

## 3. build project

For the first time to build this project, use following command to build all modules including its dependencies. 

```bash
mvn clean install --activate-profiles all
```

After the first build, we can remove the `--activate-profiles all` to speed up the following build.

# Run

Once the project has been built, you could run the project in a standalone mode to evaluate this project.

## 1. Launch collector & web server

To launch server in evaluation mode, execute the following command:

```bash
java -Dspring.profiles.include=dev,storage-jdbc,collector,webapp -jar server/server-starter/target/bithon-server-starter.jar
```

By default, the application opens and listens on following ports at local

| Function | Port |
|----------|------|
| tracing  | 9895 |
| event    | 9896 |
| metric   | 9898 |
| ctrl     | 9899 |
| web      | 9897 |

Once the application has started, visit [http://localhost:9897/web/home](http://localhost:9897/web/home) to view the monitor.

> Note:
> `-Dspring.profiles.include` parameter here is just for demo.
> 
> You can make changes to `server/server-starter/src/main/resources/application.yml` to reflect your own settings.
> 
> You can also use enable [Alibaba Nacos](doc/configuration/configuration-nacos.md) as your configuration storage center.

## 2. Attach agent to your java application

Attach agent to your java agent by adding following VM arguments.

```bash
-javaagent:<YOUR_PROJECT_DIRECTORY>/agent/agent-distribution/target/agent-distribution/agent-main.jar -Dbithon.application.name=<YOUR_APPLICATION_NAME> -Dbithon.application.env=<YOUR_APPLICATION_ENV>
```

| Variable               | Description                                                                                                              |
|------------------------|--------------------------------------------------------------------------------------------------------------------------|
| YOUR_PROJECT_DIRECTORY | the directory where this project saves                                                                                   |
| YOUR_APPLICATION_NAME  | the name of your application. It could be any string                                                                     |
| YOUR_APPLICATION_ENV   | the name of your environment to label your application. It could be any string. Usually it could be `dev`, `test`, `prd` |

By default, the agent connects collector running at local(127.0.0.1). 
Collector address could be changed in file `agent/agent-main/src/main/resources/agent.yml`.
Make sure to re-build the project after changing the configuration file above.

# JDKs Compatibility

Following matrix lists the JDKs that have been tested on macOS. And in theory, this matrix works both for Windows and Linux.

| JDK           | Supported | 
|---------------|-----------|
| JDK 1.8.0_291 | Yes       |
| JDK 9.0.4     | Yes       |
| JDK 10.0.2    | Yes       |
| JDK 11.0.12   | Yes       |
| JDK 12.0.2    | Yes       |
| JDK 13.0.2    | Yes       |
| JDK 14.0.2    | Yes       |
| JDK 15.0.2    | Yes       |
| JDK 16.02     | Yes       |
| JDK 17        | Yes       |

# Contribution

To develop for this project, intellij is recommended. 

A code style template file(`dev/bithon_intellij_code_style`) must be imported into intellij for coding.

For more information, check the [development doc](doc/dev/development.md).

# License

[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)

# User Doc
1. [Configuration](doc/configuration/configuration.md)
2. [Metrics](doc/sdk/metrics.md)
