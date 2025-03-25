package extension.extension.activity.dto;

import extension.extension.activity.utils.TabsDataType;

import java.util.Map;

public record ActivityDTO(
        Map<Integer, TabsDataType> activity
)
{}
