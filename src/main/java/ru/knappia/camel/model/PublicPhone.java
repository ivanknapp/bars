package ru.knappia.camel.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * Контактный телефон
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "is_deleted",
        "system_object_id",
        "global_id",
        "global_object_id",
        "PublicPhone"
})
@Data
public class PublicPhone {

    /**
     * is_deleted
     * (Required)
     *
     */
    @JsonProperty("is_deleted")
    @JsonPropertyDescription("is_deleted")
    private Number isDeleted;
    /**
     * system_object_id
     *
     */
    @JsonProperty("system_object_id")
    @JsonPropertyDescription("system_object_id")
    private String systemObjectId;
    /**
     * global_id
     * (Required)
     *
     */
    @JsonProperty("global_id")
    @JsonPropertyDescription("global_id")
    private Number globalId;
    /**
     * global_object_id
     * (Required)
     *
     */
    @JsonProperty("global_object_id")
    @JsonPropertyDescription("global_object_id")
    private Number globalObjectId;
    /**
     * Контактный телефон
     *
     */
    @JsonProperty("PublicPhone")
    @JsonPropertyDescription("Контактный телефон")
    private String publicPhone;

}