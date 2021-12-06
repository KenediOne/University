package com.example.university.pagination;

import org.springframework.data.domain.Sort;

public abstract class SortBuilder {

    public static Sort build(String sortString) {
        if (sortString == null || sortString.isEmpty())
            return Sort.by(Sort.Direction.ASC, "id");

        // Get first sorting before loop as we can't create empty Sort to do it later with loop/stream
        String[] sorts = sortString.split(",");
        String[] firstSortParts = sorts[0].split(":");
        Sort sortObject = Sort.by(directionFrom(firstSortParts[1]), firstSortParts[0]);

        for (int i = 1; i < sorts.length; i++) {
            String[] sortParts = sorts[i].split(":");
            sortObject = sortObject.and(Sort.by(directionFrom(sortParts[1]), sortParts[0]));
        }

        return sortObject;
    }

    private static Sort.Direction directionFrom(String directionString) {
        if (directionString.toLowerCase().equals("asc"))
            return Sort.Direction.ASC;
        if (directionString.toLowerCase().equals("desc"))
            return Sort.Direction.DESC;

        return null;
    }
}
