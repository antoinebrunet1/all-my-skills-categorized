#!/bin/bash

if [ "$(git diff skills.md)" ]; then
  exit 0
fi
exit 1