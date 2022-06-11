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
    public void addition2() {
	assertEquals(5, 2 + 3);
    }

    @Test
    public void testGetLinks() throws IOException {

        Path fileName = Path.of("./test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> getLinksExpected = new ArrayList<>();
        getLinksExpected.add("https://something.com");
        getLinksExpected.add("some-thing.html");

        assertEquals(getLinksExpected, actualLinks);

    }

    @Test
    public void testParse1() throws IOException {

        Path fileName = Path.of("./breaking1.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks1 = new ArrayList<>();
        expectedLinks1.add("https://fn258$!lmao.com");
        expectedLinks1.add("thiswillb[r]eak.org");

        assertEquals(expectedLinks1, actualLinks);

    }

    @Test
    public void testParse2() throws IOException {

        Path fileName = Path.of("./breaking2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://something.com");
        expectedLinks.add("some-thing.html");

        assertEquals(expectedLinks, actualLinks);

    }
    @Test
    public void testParse3() throws IOException {

        Path fileName = Path.of("./breaking3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://twice.jype.com/");
        expectedLinks.add("https://twice.jype.com/");

        assertEquals(expectedLinks, actualLinks);

    }
    @Test
    public void testParse4() throws IOException {

        Path fileName = Path.of("./breaking3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://twice.jype.com/");
        expectedLinks.add("https://twice.jype.com/");

        assertEquals(expectedLinks, actualLinks);

    }

    @Test
    public void testParse5() throws IOException {

        Path fileName = Path.of("./breaking2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://something.com");
        expectedLinks.add("some-thing.html");

        assertEquals(expectedLinks, actualLinks);

    }

    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("url.com");
        expectedLinks.add("`google.com");
        expectedLinks.add("google.com");
        expectedLinks.add("ucsd.edu");

        assertEquals(expectedLinks, actualLinks);
    }

    @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("b.com");
        expectedLinks.add("a.com((");
        expectedLinks.add("example.com");

        assertEquals(expectedLinks, actualLinks);
    }

    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> actualLinks = MarkdownParse.getLinks(content);

        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://www.twitter.com");
        expectedLinks.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        expectedLinks.add("https://cse.ucsd.edu/");

        assertEquals(expectedLinks, actualLinks);
    }
}

