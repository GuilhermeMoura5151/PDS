/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula11_5;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author brunop
 */
public class DVisitor extends SimpleFileVisitor<Path> {
    
    private Map<Path, Map<Path, Integer>> files;
    private int size;
    private Path actualDir;
    
    // Constructor
    public DVisitor() {
            files = new TreeMap<>();
            size = 0;
            actualDir = null;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            actualDir = dir.toAbsolutePath();
            return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            Map<Path, Integer> actualFile = new TreeMap<>();
            actualFile.put(file.getFileName(), (int) attrs.size());
            files.put(actualDir, actualFile);
            size += attrs.size();
            return FileVisitResult.CONTINUE;
    }
    
    // Getter & Setter
    public int getSize() {return size;}

    public Map<Path, Map<Path, Integer>> getFiles() {return files;}
    
}
