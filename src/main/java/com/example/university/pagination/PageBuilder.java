package com.example.university.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.Map;

public abstract class PageBuilder {

    public static final String PAGE_NUM_KEY = "pageNum";
    public static final String PER_PAGE_ELEMENTS_KEY = "perPageElements";

    public static Pageable build(String pageString, String sortString) {
        Map<String, Integer> pageParams = getPageParams(pageString);
        int pageNum = pageParams.get(PAGE_NUM_KEY);
        int perPageElements = pageParams.get(PER_PAGE_ELEMENTS_KEY);
        if (sortString == null)
            return PageRequest.of(pageNum, perPageElements);
        else
            return PageRequest.of(pageNum, perPageElements, SortBuilder.build(sortString));
    }

    private static Map<String, Integer> getPageParams(String pageString) {
        String[] pageStringParts = pageString.split(",");
        Map<String, Integer> pageParams = new HashMap<>();
        pageParams.put(PAGE_NUM_KEY, Integer.parseInt(pageStringParts[0]));
        pageParams.put(PER_PAGE_ELEMENTS_KEY, Integer.parseInt(pageStringParts[1]));
        return pageParams;
    }
}
