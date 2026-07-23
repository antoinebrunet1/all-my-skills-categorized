install-jekyll:
	apt-get update
	apt-get install ruby-full -y
	gem install jekyll

jekyll-build: install-jekyll
	jekyll build

jekyll-serve: jekyll-build
	jekyll serve

run-ui-tests-ci: jekyll-serve
	cd ui_testing && npm install && npx playwright test --reporter=line