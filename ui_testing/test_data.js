export const testData = {
    url: "http://localhost:4000/all-my-skills-categorized/skills.html",
    expectedTexts: {
        h1: "All my skills categorized",
        h2: "Antoine Brunet",
        p: "Software developer + Quality assurance analyst // I produce scalable code and guarantee quality from software development and QA perspectives using pipelines",
        ul: [
            "LinkedIn profile: https://www.linkedin.com/in/antoinebrunet97/",
            "Email: antoinebrunet1@outlook.com",
            "GitHub profile: https://github.com/antoinebrunet1"
        ]
    },
    selectors: {
        h1: "h1",
        h2: "h2",
        p: "p",
        li: "li",
        ul: "ul",
        h3: "h3"
    }
}