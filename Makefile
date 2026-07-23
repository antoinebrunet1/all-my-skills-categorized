jekyll-and-bundler-install:
	bash jekyll_and_bundler_install.sh

run-ui-tests-ci:
	cd ui_testing && npm install && npx playwright test --reporter=line