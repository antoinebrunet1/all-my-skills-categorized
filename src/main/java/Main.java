import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.steppschuh.markdowngenerator.list.UnorderedList;
import net.steppschuh.markdowngenerator.text.heading.Heading;

public class Main {
  private static final StringBuilder mdFileSB = new StringBuilder();
  private static final String RESOURCES_LOCATION = "src/main/resources";
  private static final String SKILLS_JSON_LOCATION = RESOURCES_LOCATION + "/skills.json";
  private static final String HEADER_MD_LOCATION = RESOURCES_LOCATION + "/header.md";

  public static void main(String[] args) throws IOException {
    addHeader();
    addEmptyLine();
    addSkills();
    System.out.println(mdFileSB);
  }

  private static void addHeader() throws IOException {
    String header = Files.readString(Paths.get(HEADER_MD_LOCATION));

    mdFileSB.append(header);
  }

  private static void addHeading2(String text) {
    mdFileSB.append(new Heading(text, 2)).append("\n");
  }

  private static void addUnorderedList(List<String> items) {
    mdFileSB.append(new UnorderedList<>(items)).append("\n");
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
