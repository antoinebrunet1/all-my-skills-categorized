#!/bin/bash

if [ "$(git diff skills.md src/main/resources/header.md src/main/java/org/example/Main.java)" ]; then
  git add skills.md
  git commit -m "skills.md added by GitHub Actions"
  git push origin master
fi
exit 0