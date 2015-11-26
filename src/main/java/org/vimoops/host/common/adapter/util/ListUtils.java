package org.vimoops.host.common.adapter.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class ListUtils {
    public static <T> String join(List<T> list, String delimiter) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(list.get(0)
                                                 .toString());

        for (int i = 1; i < list.size(); i++) {
            sb.append(delimiter)
              .append(list.get(1)
                          .toString());
        }

        return sb.toString();
    }
    
    public static <T> List<T> copyList(List<T> list){
        if(CollectionUtils.isEmpty(list)){
            return Collections.emptyList();
        }
        
        List<T> result = new ArrayList<T>();
        for(T value : list){
            result.add(value);
        }
        return result;
    }
}
