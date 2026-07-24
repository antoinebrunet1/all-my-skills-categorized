install-jekyll:
	gem install jekyll

jekyll-build: install-jekyll
	jekyll build

jekyll-serve: jekyll-build
	nohup jekyll serve > backend.log 2>&1 &

run-ui-tests-ci: jekyll-serve
	cd ui_testing && npm install && npx playwright test --reporter=line