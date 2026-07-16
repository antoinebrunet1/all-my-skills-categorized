# All my skills categorized

## 🎯 Goal

To have all my skills categorized on a hosted HTML page

## ⚙️ How the goal is achieved

On every push to `master` and every pull request to `master`, the `main` method of the Maven project (the repository) generates `skills.md` using `skills.json` and `header.md`. The Java logic makes sure that section titles and skills are in alphabetical order.

Using GitHub Pages and [Jekyll](https://jekyllrb.com/), I convert `skills.md` to HTML and deploy it.