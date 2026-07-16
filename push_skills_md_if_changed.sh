#!/bin/bash

if [ "$(git diff --quiet skills.md && git diff --quiet src/main/resources/header.md)" ]; then
  git add skills.md
  git commit -m "skills.md added by GitHub Actions"
  git push origin master
fi
exit 0