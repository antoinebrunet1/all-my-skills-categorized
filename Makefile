run-ui-tests-ci:
	cd ui_testing && npm install && npx playwright test --reporter=line