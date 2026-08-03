export const testData = {
    url: "http://127.0.0.1:4000/skills.html",
    expectedTexts: {
        h1: "All my skills categorized",
        h2: "Antoine Brunet",
        p: "Software developer/QA analyst | Developed 6 full stack apps with Angular/Spring Boot | Automated/maintained 300+ web app/API tests",
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