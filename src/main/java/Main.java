import java.util.ArrayList;
import java.util.List;
import net.steppschuh.markdowngenerator.list.UnorderedList;
import net.steppschuh.markdowngenerator.text.Text;
import net.steppschuh.markdowngenerator.text.emphasis.BoldText;
import net.steppschuh.markdowngenerator.text.heading.Heading;

public class Main {
  private static final StringBuilder mdFileSB = new StringBuilder();

  public static void main(String[] args) {
  }

  private static void addHeader() {
    addHeading("All my skills categorized", 1);
    addHeading("Antoine Brunet", 2);
    addText("Software developer + Quality assurance analyst // I build scalable software and " +
        "guarantee quality using pipelines with dev and QA checks");
    addUnorderedList(getContactList());
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
    return List.of(
        getContactListItem("LinkedIn profile",
            "https://www.linkedin.com/in/antoinebrunet97/"),
        getContactListItem("Email", "antoinebrunet1@outlook.com"),
        getContactListItem("GitHub profile", "https://github.com/antoinebrunet")
    );
  }

  private static String getContactListItem(String description, String value) {
    return (new BoldText(description)).toString() + (new BoldText(":")) + value;
  }
}
