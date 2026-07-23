jekyll-and-bundler-install:
	apt-get update
	apt-get install ruby-full -y
	gem install jekyll

run-ui-tests-ci:
	cd ui_testing && npm install && npx playwright test --reporter=line