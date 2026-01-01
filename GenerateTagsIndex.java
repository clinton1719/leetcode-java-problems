
// GenerateTagsIndex.java
// This script scans problem folders, extracts YAML frontmatter tags,
// and generates markdown index files in the `tags/` folder.

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class GenerateTagsIndex {
    static final Path PROBLEMS_DIR = Paths.get("problems");
    static final Path TAGS_DIR = Paths.get("tags");
    static final Pattern FRONTMATTER_PATTERN = Pattern.compile("(?s)^---\n(.*?)\n---");
    static final Pattern TAGS_LINE_PATTERN = Pattern.compile("tags:\\s*\\[(.*?)\\]");
    static final Pattern TITLE_PATTERN = Pattern.compile("title:\\s*(.*?)\\n");
    static final Pattern ID_PATTERN = Pattern.compile("id:\\s*(\\d+)");


    static class ProblemInfo {
        String id;
        String title;
        String path;

        ProblemInfo(String id, String title, String path) {
            this.id = id;
            this.title = title;
            this.path = path;
        }
    }

    public static void main(String[] args) throws IOException {
        if (!Files.exists(TAGS_DIR)) Files.createDirectories(TAGS_DIR);
        Map<String, List<ProblemInfo>> tagMap = new HashMap<>();

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(PROBLEMS_DIR)) {
            for (Path problemDir : dirStream) {
                Path readme = problemDir.resolve("README.md");
                if (!Files.exists(readme)) continue;

                String content = Files.readString(readme);
                Matcher fmMatcher = FRONTMATTER_PATTERN.matcher(content);
                if (!fmMatcher.find()) continue;

                String frontmatter = fmMatcher.group(1);
                Matcher tagsMatcher = TAGS_LINE_PATTERN.matcher(frontmatter);
                Matcher titleMatcher = TITLE_PATTERN.matcher(frontmatter);
                Matcher idMatcher = ID_PATTERN.matcher(frontmatter);

                if (!tagsMatcher.find() || !titleMatcher.find() || !idMatcher.find()) continue;

                String[] tags = tagsMatcher.group(1).split(",\\s*");
                String title = titleMatcher.group(1);
                String id = idMatcher.group(1);

                ProblemInfo info = new ProblemInfo(id, title, problemDir.toString());
                for (String tag : tags) {
                    tag = tag.replace("\"", "").trim();
                    tagMap.computeIfAbsent(tag.trim(), k -> new ArrayList<>()).add(info);
                }
            }
        }

        for (Map.Entry<String, List<ProblemInfo>> entry : tagMap.entrySet()) {
            String tag = entry.getKey();
            List<ProblemInfo> problems = entry.getValue();
            problems.sort(Comparator.comparing(p -> p.id));

            Path tagFile = TAGS_DIR.resolve(tag + ".md");
            try (BufferedWriter writer = Files.newBufferedWriter(tagFile)) {
                writer.write("# 🚩 Tag: " + tag + "\n\n");
                for (ProblemInfo p : problems) {
                    writer.write(String.format("- [%s. %s](../%s)\n", p.id, p.title, p.path));
                }
            }
        }

        System.out.println("✅ Tag indexes generated in /tags");
    }
}
