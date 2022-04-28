import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {

        Path fileName = Path.of("/Users/stellaji/Documents/GitHub/markdown-parser/test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> getLinksExpected = new ArrayList<>();
        getLinksExpected.add("https://something.com");
        getLinksExpected.add("some-thing.html");

        assertEquals(actualLinks, getLinksExpected);

    }

    @Test
    public void testParse1() throws IOException {

        Path fileName = Path.of("/Users/stellaji/Documents/GitHub/markdown-parser/breaking1.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks1 = new ArrayList<>();
        expectedLinks1.add("https://fn258$!lmao.com");
        expectedLinks1.add("thiswillb[r]eak.org");

        assertEquals(actualLinks, expectedLinks1);

    }

    @Test
    public void testParse2() throws IOException {

        Path fileName = Path.of("/Users/stellaji/Documents/GitHub/markdown-parser/breaking2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://something.com");
        expectedLinks.add("some-thing.html");

        assertEquals(actualLinks, expectedLinks);

    }
    @Test
    public void testParse3() throws IOException {

        Path fileName = Path.of("/Users/stellaji/Documents/GitHub/markdown-parser/breaking3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://twice.jype.com/");
        expectedLinks.add("https://twice.jype.com/");

        assertEquals(actualLinks, expectedLinks);

    }
    @Test
    public void testParse4() throws IOException {

        Path fileName = Path.of("/Users/stellaji/Documents/GitHub/markdown-parser/breaking3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("");

        assertEquals(actualLinks, expectedLinks);

    }
}

