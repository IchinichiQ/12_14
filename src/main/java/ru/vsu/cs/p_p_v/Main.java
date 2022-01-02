package ru.vsu.cs.p_p_v;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

/*    На вход передается путь к папке (в виде строки, например "Z:\\ВвП"). Напишите
    функцию, которая находит наиболее "глубоко" лежащие элементы ("листья") - это могут
    быть и файлы и папки.
    Для чтения набора файлов и подпапок в папке использовать класс java.io.File (метод
    listFiles()).
    Вначале надо найти максимальную глубину пути, а затем еще раз рекурсивно обойти все
    элементы и вернуть самые глубокие.
    Для универсальности будем передавать в функцию другую функцию (а точнее
    функциональный интерфейс), которая будет использоваться в качестве callback-вызова,
    который будет вызываться для каждого элемента с максимальной глубиной.
    Функция должна иметь следующую сигнатуру:
    public static void genMaxDepthElements(String path,
                                           Consumer<String> callback)
    И вызываться будет как-то так:
    genMaxDepthElements ("Z:\\", (String path) -> {
        // например, печать элемента
        System.out.println(path);
    });
*/

    public static void main(String[] args) {
        System.out.print("Please enter directory path: ");

        Scanner scan = new Scanner(System.in);
        String inputDir = scan.nextLine();

        FileDepthAnalyzer.genMaxDepthElements(inputDir, System.out::println);
    }

}
