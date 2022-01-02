package ru.vsu.cs.p_p_v;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileDepthAnalyzerTest {

/*  Test directory structure:
Test Directory
│   Level 0.txt
│
└───Level 1
    │   Level 1.txt
    │
    ├───Level 2 #1
    │   └───Level 3
    │       └───Level 4
    │               Level 4 #1.txt
    │               Level 4 #2.txt

    └───Level 2 #2
        │   Level 2.txt
        │
        └───Level 3
                Level 3.txt
*/

    @Test
    void genMaxDepthElements() {
        String dirPath = "\\Test Directory";
        String[] maxDepthElements = new String[] {"Level 4` #1.txt", "Level 4 #2.txt"};

        FileDepthAnalyzer.genMaxDepthElements(dirPath, (String path) -> {isCorrectAnswerCallback(path, maxDepthElements);});
    }

    void isCorrectAnswerCallback(String path, String[] correctElements) {
        File f = new File(path);
        String filename = f.getName();

        if (!Arrays.asList(correctElements).contains(filename))
            throw new RuntimeException("Wrong file \"" + filename + "\"");
    }
}