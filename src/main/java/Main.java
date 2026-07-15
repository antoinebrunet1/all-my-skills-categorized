import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.steppschuh.markdowngenerator.list.UnorderedList;
import net.steppschuh.markdowngenerator.text.Text;
import net.steppschuh.markdowngenerator.text.emphasis.BoldText;
import net.steppschuh.markdowngenerator.text.heading.Heading;

public class Main {
  private static final StringBuilder mdFileSB = new StringBuilder();
  private static final String HEADING_1 = "All my skills categorized";
  private static final String FULL_NAME = "Antoine Brunet";
  private static final String BIO = "Software developer + Quality assurance analyst // I build " +
      "scalable software and guarantee quality using pipelines with dev and QA checks";
  private static final Map<String, String> CONTACT_LIST = Map.of(
      "LinkedIn profile:", "https://www.linkedin.com/in/antoinebrunet97/",
      "Email:", "antoinebrunet1@outlook.com",
      "GitHub profile:", "https://github.com/antoinebrunet"
  );
  private static final String SKILLS_JSON_LOCATION = "src/main/resources/skills.json";

  public static void main(String[] args) throws IOException {
    addHeader();
    addEmptyLine();
    addSkills();
    System.out.println(mdFileSB);
  }

  private static void addHeader() {
    addHeading1(HEADING_1);
    addHeading2(FULL_NAME);
    addText(BIO);
    addEmptyLine();
    addContactList();
  }

  private static void addHeading1(String text) {
    addHeading(text, 1);
  }

  private static void addHeading2(String text) {
    addHeading(text, 2);
  }

  private static void addHeading(String text, int level) {
    mdFileSB.append(new Heading(text, level)).append("\n");
  }

  private static void addText(String text) {
    mdFileSB.append(new Text(text)).append("\n");
  }

  private static void addUnorderedList(List<String> items) {
    mdFileSB.append(new UnorderedList<>(items)).append("\n");
  }

  private static List<String> getContactList() {
    List<String> contactList = new ArrayList<>();

    for (String description : CONTACT_LIST.keySet()) {
      String value = CONTACT_LIST.get(description);
      String contactListItem = getContactListItem(description, value);
      contactList.add(contactListItem);
    }

    return contactList;
  }

  private static String getContactListItem(String description, String value) {
    return new BoldText(description) + " " + value;
  }

  private static void addContactList() {
    addUnorderedList(getContactList());
  }

  private static void addEmptyLine() {
    mdFileSB.append("\n");
  }

  private static void addSkills() throws IOException {
    Map<String, List<String>> skillsMapInAlpha = getSkillsMapInAlphaOrderForSectionsAndSkills();

    for (String section : skillsMapInAlpha.keySet()) {
      List<String> skills = skillsMapInAlpha.get(section);

      addSection(section, skills);
    }
  }

  private static void addSection(String section, List<String> skills) {
    addHeading2(section);
    addEmptyLine();
    addUnorderedList(skills);
    addEmptyLine();
  }

  private static Map<String, List<String>> getSkillsMapInAlphaOrderForSectionsAndSkills()
      throws IOException {
    Map<String, List<String>> skillsMap = getSkillsMap();
    Map<String, List<String>> skillsMapInAlpha = new LinkedHashMap<>();

    skillsMap
        .keySet()
        .stream()
        .sorted()
        .forEach(
            key -> skillsMapInAlpha.put(
                key,
                skillsMap.get(key)
                    .stream()
                    .sorted()
                    .toList()
            )
        );

    return skillsMapInAlpha;
  }

  private static Map<String, List<String>> getSkillsMap() throws IOException {
    String skillsString = Files.readString(Paths.get(SKILLS_JSON_LOCATION));
    ObjectMapper mapper = new ObjectMapper();

    return mapper.readValue(skillsString, new TypeReference<>() {});
  }
}
