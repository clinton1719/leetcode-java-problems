import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateTagsIndex {
    static final Path PROBLEMS_DIR = Paths.get("problems");
    static final Path TAGS_DIR = Paths.get("tags");

    // Improved regex to handle index.md or README.md and flexible frontmatter
    static final Pattern FRONTMATTER_PATTERN = Pattern.compile("(?s)^---\\s*\\n(.*?)\\n---");
    static final Pattern TAGS_PATTERN = Pattern.compile("tags:\\s*\\[(.*?)\\]");
    static final Pattern TITLE_PATTERN = Pattern.compile("title:\\s*\"?(.*?)\"?(?:\\n|$)");
    static final Pattern ID_PATTERN = Pattern.compile("id:\\s*(\\d+)");

    static void main(String[] args) throws IOException {
        if (!Files.exists(TAGS_DIR)) Files.createDirectories(TAGS_DIR);
        Map<String, List<ProblemInfo>> tagMap = new TreeMap<>(); // Sorted tags

        if (!Files.exists(PROBLEMS_DIR)) {
            System.out.println("❌ Error: 'problems' directory not found.");
            return;
        }

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(PROBLEMS_DIR)) {
            for (Path problemDir : dirStream) {
                if (!Files.isDirectory(problemDir)) continue;

                // FIX: Check for index.md as per your example
                Path markdownFile = problemDir.resolve("index.md");
                if (!Files.exists(markdownFile)) {
                    // Fallback to README.md just in case
                    markdownFile = problemDir.resolve("README.md");
                    if (!Files.exists(markdownFile)) continue;
                }

                String content = Files.readString(markdownFile);
                Matcher fmMatcher = FRONTMATTER_PATTERN.matcher(content);
                if (!fmMatcher.find()) continue;

                String frontmatter = fmMatcher.group(1);
                Matcher tagsMatcher = TAGS_PATTERN.matcher(frontmatter);
                Matcher titleMatcher = TITLE_PATTERN.matcher(frontmatter);
                Matcher idMatcher = ID_PATTERN.matcher(frontmatter);

                if (!tagsMatcher.find() || !titleMatcher.find() || !idMatcher.find()) continue;

                String rawTags = tagsMatcher.group(1);
                String title = titleMatcher.group(1).trim();
                String id = idMatcher.group(1);

                ProblemInfo info = new ProblemInfo(id, title, PROBLEMS_DIR.getFileName() + "/" + problemDir.getFileName());

                // Clean up tags: remove quotes, split, and trim
                String[] tags = rawTags.split(",");
                for (String tag : tags) {
                    tag = tag.replace("\"", "").replace("'", "").trim();
                    if (!tag.isEmpty()) {
                        tagMap.computeIfAbsent(tag, k -> new ArrayList<>()).add(info);
                    }
                }
            }
        }

        // Generate files
        for (Map.Entry<String, List<ProblemInfo>> entry : tagMap.entrySet()) {
            String tag = entry.getKey();
            List<ProblemInfo> problems = entry.getValue();

            // Sort by ID numerically
            problems.sort(Comparator.comparingInt(p -> Integer.parseInt(p.id)));

            Path tagFile = TAGS_DIR.resolve(tag + ".md");
            try (BufferedWriter writer = Files.newBufferedWriter(tagFile)) {
                writer.write("# 🚩 Tag: " + tag + "\n\n");
                for (ProblemInfo p : problems) {
                    writer.write(String.format("- [%s. %s](../%s)\n", p.id, p.title, p.relativePath));
                }
            }
        }

        System.out.println("✅ Tag indexes generated for " + tagMap.size() + " tags in /tags");
    }

    static class ProblemInfo {
        String id;
        String title;
        String relativePath;

        ProblemInfo(String id, String title, String path) {
            this.id = id;
            this.title = title;
            // Ensure path uses forward slashes for Markdown links
            this.relativePath = path.replace("\\", "/");
        }
    }
}