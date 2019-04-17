package io.tooko.vue.antd.xml;

import java.util.HashMap;

public class AntTagConstant {

    public static HashMap<String, HashMap<String, String[]>> TAG_CONSTANT = new HashMap<>();

    static {
        /* a-row */
        HashMap<String, String[]> aRowMap = new HashMap<>();
        aRowMap.put("gutter", new String[]{"8", "16", "24", "32", "48"});
        aRowMap.put("type", new String[]{"flex"});
        aRowMap.put("justify", new String[]{"start", "center", "end", "space-between", "space-around"});
        aRowMap.put("align", new String[]{"top", "middle", "bottom"});
        TAG_CONSTANT.put("a-row", aRowMap);

        /* a-col */
        HashMap<String, String[]> aColMap = new HashMap<>();
        aColMap.put("span", new String[]{"8"});
        aColMap.put("order", new String[]{"0"});
        aColMap.put("offset", new String[]{"0"});
        aColMap.put("push", new String[]{"0"});
        aColMap.put("pull", new String[]{"0"});
        aColMap.put("xs", new String[]{"8"});
        aColMap.put("sm", new String[]{"8"});
        aColMap.put("md", new String[]{"8"});
        aColMap.put("lg", new String[]{"8"});
        aColMap.put("xl", new String[]{"8"});
        aColMap.put("xxl", new String[]{"8"});
        TAG_CONSTANT.put("a-col", aColMap);

        HashMap<String, String[]> aLayout = new HashMap<>();
        aLayout.put("class", new String[]{""});
        aLayout.put("style", new String[]{""});
        aLayout.put("has-sider", new String[]{"true"});
        TAG_CONSTANT.put("a-layout", aLayout);

    }
}
