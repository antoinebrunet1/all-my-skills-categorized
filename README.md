# All my skills categorized

**Deployed HTML page:** [https://antoinebrunet1.github.io/all-my-skills-categorized/skills.html](https://antoinebrunet1.github.io/all-my-skills-categorized/skills.html)

## 🎯 Goal

To have all my skills categorized on a hosted HTML page

## ⚙️ How the goal is achieved

On every push to `master` and every pull request to `master`, the `main` method of the Maven project (the repository) generates `skills.md` using `skills.json` and `header.md`. The Java logic makes sure that section titles and skills are in alphabetical order.

Using GitHub Pages and [Jekyll](https://jekyllrb.com/), I convert `skills.md` to HTML and deploy it.

## 🧪 UI testing

The update of the hosting is triggered by a push by "GitHub Actions Bot" to `master` of the `skills.md` generated just before. Both the generation of the file and the push are realized in `.github/workflows/generate_markdown.yml`.

The push only happens if the generated `skills.md` is different from the previous one and if the UI tests pass. The UI tests are not run if `skills.md` has not changed. The UI tests are in the `ui_testing` folder and are written in JavaScript Playwright. If the UI tests fail, the pipeline fails.