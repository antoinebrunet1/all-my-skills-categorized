import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    printSkillsMarkdownFile();
  }

  private static void printSkillsMarkdownFile() throws IOException {
    addHeader();
    addEmptyLine();
    addSkills();
    System.out.println(mdFileSB);
  }

  private static void addHeader() throws IOException {
    String header = Files.readString(Paths.get(HEADER_MD_LOCATION));

    mdFileSB.append(header).append("\n");
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
    Map<String, List<String>> skillsMapInAlpha = getSkillsMap();

    for (String section : skillsMapInAlpha.keySet().stream().sorted().toList()) {
      List<String> skills = skillsMapInAlpha.get(section);

      addSection(section, skills);
    }
  }

  private static void addSection(String section, List<String> skills) {
    addHeading2(section);
    addEmptyLine();
    addUnorderedList(skills.stream().sorted().toList());
    addEmptyLine();
  }

  private static Map<String, List<String>> getSkillsMap() throws IOException {
    String skillsString = Files.readString(Paths.get(SKILLS_JSON_LOCATION));
    ObjectMapper mapper = new ObjectMapper();

    return mapper.readValue(skillsString, new TypeReference<>() {});
  }
}
