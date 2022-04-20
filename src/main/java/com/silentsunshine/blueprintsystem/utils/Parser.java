package com.silentsunshine.blueprintsystem.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhouqichun
 **/
public class Parser {
    public static List<String> parseUserId(String ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(ids.split(","))
                .filter(id -> id != null && ! id.isEmpty())
                .collect(Collectors.toList());
    }

    public static String unparse(List<String> ids) {
        StringBuilder stringBuilder = new StringBuilder(",");
        for (String id : ids) {
            stringBuilder.append(id).append(",");
        }
        return stringBuilder.toString();
    }

    public static String convertJsonStringfy(String data) {
        return data.replace("\\", "\\\\");
    }
}
