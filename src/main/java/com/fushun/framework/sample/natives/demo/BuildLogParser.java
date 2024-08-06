//package com.fushun.framework.sample.natives.demo;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//public class BuildLogParser {
//    public static void main(String[] args) {
//        String filePath = "/Volumes/work/IdeaProjects/framework-parent/framework-samples/spring-native-demo/src/main/java/com/fushun/framework/sample/natives/demo/build.log";
//
//        try {
//            // 读取文件内容
//            List<String> lines = Files.readAllLines(Paths.get(filePath));
//
//            // 用于存储匹配到的字符串
//            Set<String> matchedStrings = new HashSet<>();
//
//            // 定义正则表达式，包括匹配两个单引号中的内容
//            Pattern pattern = Pattern.compile("--initialize-at-build-time=([^\\s]+|'[^']*')");
//
//            // 匹配并添加到集合中
//            for (String line : lines) {
//                Matcher matcher = pattern.matcher(line);
//                while (matcher.find()) {
//                    String match = matcher.group(1);
//                    // 去掉单引号
//                    match = match.replaceAll("^'|'$", "");
//                    String[] parts = match.split(",");
//                    matchedStrings.addAll(Arrays.asList(parts));
//                }
//            }
//
//            // 按照"."前面两个部分进行分组
//            HashMap<String, Set<String>> groupedStrings = new HashMap<>();
//
//            for (String str : matchedStrings) {
//                String[] parts = str.split("\\.");
//                String key;
//                if (parts.length >= 2) {
//                    key = parts[0] + "." + parts[1];
//                } else {
//                    key = parts[0];
//                }
//                groupedStrings.computeIfAbsent(key, k -> new HashSet<>()).add(str);
//            }
//
//            // 输出分组结果
//            for (String key : groupedStrings.keySet()) {
//                String result = groupedStrings.get(key).stream().collect(Collectors.joining(","));
//                System.out.println(key + ": " + result);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
