install-jekyll:
	gem install jekyll jekyll-relative-links jekyll-remote-theme jekyll-seo-tag

jekyll-build: install-jekyll
	jekyll build

jekyll-serve: jekyll-build
	nohup jekyll serve > backend.log 2>&1 &

wait-for-front-end: jekyll-serve
	bash wait_for_frontend.sh

run-ui-tests-ci: wait-for-front-end
	cd ui_testing && npm i -D @playwright/test && npx playwright install && npx playwright test --reporter=line

push-skills-md:
	git config user.name "GitHub Actions Bot"
	git config user.email "<>"
	git add skills.md
	git commit -m "skills.md added by GitHub Actions"
	git push origin master

validate-skills-md-changed:
	bash validate_skills_md_changed.sh