package ru.vsu.cs.p_p_v;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FileDepthAnalyzer {

    public static void genMaxDepthElements(String path, Consumer<String> callback) {
        int maxDepth = getMaxDepth(path, 0);
        List<File> maxDepthFiles = getFilesWithDepth(path, 0, maxDepth);

        for (File f : maxDepthFiles) {
            callback.accept("Depth " + (maxDepth - 1) + ": " + f.getPath());
        }
    }

    private static int getMaxDepth(String path, int currentDepth) {
        File dir = new File(path);
        File[] filesInDirectory = dir.listFiles();

        if (filesInDirectory == null)
            return 0;

        currentDepth++;
        int maxDepth = 0;
        for (File f : filesInDirectory) {
            if (f.isDirectory()) {
                int dirDepth = getMaxDepth(f.getPath(), currentDepth);
                if (dirDepth > maxDepth)
                    maxDepth = dirDepth;
            } else {
                if (currentDepth > maxDepth)
                    maxDepth = currentDepth;
            }
        }

        return maxDepth;
    }

    private static List<File> getFilesWithDepth(String path, int currentDepth, int neededDepth) {
        List<File> neededFiles = new ArrayList<>();

        File dir = new File(path);
        File[] filesInDirectory = dir.listFiles();

        if (filesInDirectory == null)
            return neededFiles;

        currentDepth++;
        int maxDepth = 0;
        for(File f : filesInDirectory) {
            if (currentDepth == neededDepth)
                neededFiles.add(f);

            if (f.isDirectory())
                neededFiles.addAll(getFilesWithDepth(f.getPath(), currentDepth, neededDepth));
        }

        return neededFiles;
    }
}
