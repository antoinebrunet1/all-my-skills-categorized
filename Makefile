install-jekyll:
	apt-get update
	apt-get install ruby-full -y
	gem install jekyll

jekyll-build:
	jekyll build

jekyll-serve:
	jekyll serve

run-ui-tests-ci:
	cd ui_testing && npm install && npx playwright test --reporter=line