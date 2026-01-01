import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class GenerateTagsIndex {
    static final Path PROBLEMS_DIR = Paths.get("problems");
    static final Path TAGS_DIR = Paths.get("tags");
    static final Path MAIN_README = Paths.get("README.md");

    static final Pattern FRONTMATTER_PATTERN = Pattern.compile("(?s)^---\\s*\\n(.*?)\\n---");
    static final Pattern TAGS_PATTERN = Pattern.compile("tags:\\s*\\[(.*?)\\]");
    static final Pattern TITLE_PATTERN = Pattern.compile("title:\\s*\"?(.*?)\"?(?:\\n|$)");
    static final Pattern ID_PATTERN = Pattern.compile("id:\\s*(\\d+)");
    static final Pattern DIFFICULTY_PATTERN = Pattern.compile("difficulty:\\s*(.*?)(?:\\n|$)");

    static class ProblemInfo {
        String id;
        String title;
        String difficulty;
        String relativePath;
        List<String> tags;

        ProblemInfo(String id, String title, String difficulty, String path, List<String> tags) {
            this.id = id;
            this.title = title;
            this.difficulty = difficulty;
            this.relativePath = path.replace("\\", "/");
            this.tags = tags;
        }
    }

    public static void main(String[] args) throws IOException {
        if (!Files.exists(TAGS_DIR)) Files.createDirectories(TAGS_DIR);

        Map<String, List<ProblemInfo>> tagMap = new TreeMap<>();
        List<ProblemInfo> allProblems = new ArrayList<>();
        int easy = 0, medium = 0, hard = 0;

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(PROBLEMS_DIR)) {
            for (Path problemDir : dirStream) {
                if (!Files.isDirectory(problemDir)) continue;

                Path markdownFile = problemDir.resolve("index.md");
                if (!Files.exists(markdownFile)) {
                    markdownFile = problemDir.resolve("README.md");
                    if (!Files.exists(markdownFile)) continue;
                }

                String content = Files.readString(markdownFile);
                Matcher fmMatcher = FRONTMATTER_PATTERN.matcher(content);
                if (!fmMatcher.find()) continue;

                String fm = fmMatcher.group(1);
                String id = getMatch(ID_PATTERN, fm);
                String title = getMatch(TITLE_PATTERN, fm);
                String diff = getMatch(DIFFICULTY_PATTERN, fm);
                String rawTags = getMatch(TAGS_PATTERN, fm);

                if (id == null || title == null) continue;

                // Track difficulty for stats
                if ("Easy".equalsIgnoreCase(diff)) easy++;
                else if ("Medium".equalsIgnoreCase(diff)) medium++;
                else if ("Hard".equalsIgnoreCase(diff)) hard++;

                List<String> problemTags = new ArrayList<>();
                for (String t : rawTags.split(",")) {
                    String cleanTag = t.replace("\"", "").replace("'", "").trim();
                    if (!cleanTag.isEmpty()) {
                        problemTags.add(cleanTag);
                        tagMap.computeIfAbsent(cleanTag, k -> new ArrayList<>()).add(null); // Placeholder
                    }
                }

                ProblemInfo info = new ProblemInfo(id, title, diff, "problems/" + problemDir.getFileName(), problemTags);
                allProblems.add(info);

                // Re-populate tagMap with full info
                for (String tag : problemTags) {
                    tagMap.get(tag).add(info);
                }
            }
        }

        // 1. Generate Individual Tag Files
        for (Map.Entry<String, List<ProblemInfo>> entry : tagMap.entrySet()) {
            String tag = entry.getKey();
            List<ProblemInfo> problems = entry.getValue();
            problems.removeIf(Objects::isNull);
            problems.sort(Comparator.comparingInt(p -> Integer.parseInt(p.id)));

            try (BufferedWriter writer = Files.newBufferedWriter(TAGS_DIR.resolve(tag + ".md"))) {
                writer.write("# 🚩 Tag: " + tag + "\n\n");
                for (ProblemInfo p : problems) {
                    writer.write(String.format("- [%s. %s](../%s)\n", p.id, p.title, p.relativePath));
                }
            }
        }

        // 2. Generate Main README.md
        allProblems.sort(Comparator.comparingInt(p -> Integer.parseInt(p.id)));
        try (BufferedWriter writer = Files.newBufferedWriter(MAIN_README)) {
            writer.write("# 🚀 LeetCode Solutions\n\n");

            writer.write("## 📊 Statistics\n\n");
            writer.write("| Total | Easy | Medium | Hard |\n");
            writer.write("| --- | --- | --- | --- |\n");
            writer.write(String.format("| %d | %d | %d | %d |\n\n", allProblems.size(), easy, medium, hard));

            writer.write("## 🏷️ Tag Cloud\n\n");
            StringBuilder tagCloud = new StringBuilder();
            for (String tag : tagMap.keySet()) {
                tagCloud.append(String.format("[`%s`](tags/%s.md) ", tag, tag));
            }
            writer.write(tagCloud.toString() + "\n\n");

            writer.write("## 📚 Problem List\n\n");
            writer.write("| # | Title | Difficulty | Tags |\n");
            writer.write("| --- | --- | --- | --- |\n");
            for (ProblemInfo p : allProblems) {
                String tagLinks = String.join(", ", p.tags);
                writer.write(String.format("| %s | [%s](%s) | %s | %s |\n",
                        p.id, p.title, p.relativePath, p.difficulty, tagLinks));
            }
        }

        System.out.println("✅ README and Tag indexes generated successfully.");
    }

    private static String getMatch(Pattern p, String text) {
        Matcher m = p.matcher(text);
        return m.find() ? m.group(1).trim() : "";
    }
}