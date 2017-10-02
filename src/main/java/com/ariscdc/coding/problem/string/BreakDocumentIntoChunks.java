package com.ariscdc.coding.problem.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Given a set of string/document, break into chunks of specified size.
 * Constraints:
 * - Must break only on paragraph, indicated by colon (:)
 * - If the next paragraph exceeds the chunk size, put the next paragraph into its own chunk
 *
 * 20160131 1110-1200 (50 mins.)
 * 20160131 1210-1220 (10 mins.) (chunkify1())
 * 20160131 1230-1245 (15 mins.) (chunkify2())
 *                    (75 mins.)
 */
public class BreakDocumentIntoChunks {

    private static final char PARAGRAPH_DELIMITER = ':';

    private BreakDocumentIntoChunks() {}

    public static List<String> chunkify1(String document, int size) {

        List<String> chunks = new ArrayList<>();
        if (document == null || document.trim().length() == 0) return chunks;

        int i = 0;
        String paragraph = "";
        String lastParagraph = "";

        while (i < document.length()) {
            char ch = document.charAt(i);
            paragraph += ch;
            if (ch == PARAGRAPH_DELIMITER) {
                if (lastParagraph.isEmpty()) {
                    lastParagraph = paragraph;
                    paragraph = "";
                } else {
                    if (lastParagraph.length() + paragraph.length() <= size) {
                        chunks.add(lastParagraph + paragraph);
                        lastParagraph = "";
                        paragraph = "";
                    } else {
                        chunks.add(lastParagraph);
                        lastParagraph = paragraph;
                        paragraph = "";
                    }
                }
            }
            if (i == document.length() - 1 && (!lastParagraph.isEmpty() || paragraph.isEmpty())) {
                chunks.add(lastParagraph + paragraph);
            }
            i++;
        }

        return chunks;
    }

    public static List<String> chunkify2(String document, int size) {

        List<String> chunks = new ArrayList<>();
        if (document == null || document.trim().length() == 0) return chunks;

        int i = 0;
        String paragraph = "";
        String chunk = "";

        while (i < document.length()) {
            char ch = document.charAt(i);
            paragraph += ch;
            if (ch == PARAGRAPH_DELIMITER) {
                if (chunk.length() + paragraph.length() > size) {
                    chunks.add(chunk);
                    chunk = "";
                }
                chunk += paragraph;
                if (chunk.length() >= size) {
                    chunks.add(chunk);
                    chunk = "";
                }
                paragraph = "";
            }
            if (i == document.length() - 1) {
                chunks.add(chunk + paragraph);
            }
            i++;
        }

        return chunks;
    }

    public static void main(String[] args) {

//        System.out.println(BreakDocumentIntoChunks.chunkify1(null, 5));
//        System.out.println(BreakDocumentIntoChunks.chunkify1("", 5));
//        System.out.println(BreakDocumentIntoChunks.chunkify1("     ", 5));
//        System.out.println(BreakDocumentIntoChunks.chunkify1("::::::::", 5));
//        System.out.println(BreakDocumentIntoChunks.chunkify1("a:b:c:d:e:f:g:h:", 5));
//        System.out.println(BreakDocumentIntoChunks.chunkify1("a:bb:cc:abcdef:ab:c:d:", 5));
//        System.out.println(BreakDocumentIntoChunks.chunkify1("a:bb:cc:abcdef:ab:c:d:abcdefghijk", 5));

        System.out.println(BreakDocumentIntoChunks.chunkify2(null, 5));
        System.out.println(BreakDocumentIntoChunks.chunkify2("", 5));
        System.out.println(BreakDocumentIntoChunks.chunkify2("     ", 5));
        System.out.println(BreakDocumentIntoChunks.chunkify2("::::::::", 5));
        System.out.println(BreakDocumentIntoChunks.chunkify2("a:b:c:d:e:f:g:h:", 5));
        System.out.println(BreakDocumentIntoChunks.chunkify2("a:bb:cc:abcdef:ab:c:d:", 5));
        System.out.println(BreakDocumentIntoChunks.chunkify2("a:bb:cc:abcdef:ab:c:d:abcdefghijk", 5));
    }
}
