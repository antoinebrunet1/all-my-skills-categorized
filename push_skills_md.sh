#!/bin/bash

# If skills.md has not changed
if [ -z "$(git diff skills.md)" ]; then
  exit 0
fi

make run-ui-tests-ci

returnValue=$?

# If the UI tests fail
if [ $returnValue -ne 0 ]; then
  exit 1
fi

make push-skills-md