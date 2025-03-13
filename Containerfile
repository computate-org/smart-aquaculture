FROM registry.access.redhat.com/ubi9/openjdk-17:latest

USER root

RUN microdnf install -y git

RUN install -d /home/default/smart-aquaculture
COPY . /home/default/smart-aquaculture

RUN git clone https://github.com/computate-org/computate-base.git /home/default/computate-base
RUN git clone https://github.com/computate-org/computate-search.git /home/default/computate-search
RUN git clone https://github.com/computate-org/computate-vertx.git /home/default/computate-vertx
RUN git clone https://github.com/computate-org/smart-aquaculture-static.git /home/default/smart-aquaculture-static

WORKDIR /home/default/computate-base
RUN mvn clean install -DskipTests
WORKDIR /home/default/computate-search
RUN mvn clean install -DskipTests
WORKDIR /home/default/computate-vertx
RUN mvn clean install -DskipTests
WORKDIR $HOME/smart-aquaculture
RUN mvn clean install -DskipTests

WORKDIR /home/default/smart-aquaculture
RUN mvn clean install -DskipTests
RUN mvn dependency:build-classpath -Dmdep.outputFile=/home/default/smart-aquaculture/cp.txt -q
CMD java -cp "$(cat /home/default/smart-aquaculture/cp.txt):/home/default/smart-aquaculture/target/classes" com.example.site.verticle.MainVerticle
