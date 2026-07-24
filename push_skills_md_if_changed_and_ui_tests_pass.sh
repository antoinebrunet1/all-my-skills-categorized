#!/bin/bash

if [ "$(git diff skills.md)" ] && [ "$(make run-ui-tests-ci)" ]; then
  git config user.name "GitHub Actions Bot"
  git config user.email "<>"
  git add skills.md
  git commit -m "skills.md added by GitHub Actions"
  git push origin master
fi
exit 0