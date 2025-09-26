#!/bin/bash

cd /home/ctate/.local/src/smart-aquaculture-developer/smart-aquaculture
env WATCH=false \
  GENERATE_NOW=true \
  VARS_PATH=/home/ctate/.local/src/smart-aquaculture-developer/smart-aquaculture/vars.yaml \
  COMPUTATE_SRC=/home/ctate/.local/src/computate \
  COMPUTATE_VERTX_SRC=/home/ctate/.local/src/computate-vertx \
  SITE_LANG=enUS \
  /home/ctate/.local/src/computate/bin/enUS/index.sh
