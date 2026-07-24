install-jekyll:
	gem install jekyll jekyll-relative-links jekyll-remote-theme jekyll-seo-tag

jekyll-build: install-jekyll
	jekyll build

jekyll-serve: jekyll-build
	nohup jekyll serve > backend.log 2>&1 &

run-ui-tests-ci: jekyll-serve
	cd ui_testing && npm init playwright@latest && npx playwright test --reporter=line

push-skills-md:
	git config user.name "GitHub Actions Bot"
	git config user.email "<>"
	git add skills.md
	git commit -m "skills.md added by GitHub Actions"
	git push origin master

validate-skills-md-changed:
	bash validate_skills_md_changed.sh