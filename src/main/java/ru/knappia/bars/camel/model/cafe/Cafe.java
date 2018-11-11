package ru.knappia.bars.camel.model.cafe;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import ru.knappia.bars.camel.model.bar.PublicPhone;


/**
 * Кафе
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Longitude_WGS84",
        "SeatsCount",
        "Latitude_WGS84",
        "global_id",
        "TypeObject",
        "SocialPrivileges",
        "AdmArea",
        "PublicPhone",
        "Name",
        "is_deleted",
        "system_object_id",
        "District",
        "OperatingCompany",
        "Address",
        "ID",
        "IsNetObject",
        "signature_date"
})
@Data
public class Cafe {

    /**
     * Долгота в WGS-84
     * (Required)
     *
     */
    @JsonProperty("Longitude_WGS84")
    @JsonPropertyDescription("Долгота в WGS-84")
    public String longitudeWGS84;
    /**
     * Число посадочных мест
     * (Required)
     *
     */
    @JsonProperty("SeatsCount")
    @JsonPropertyDescription("Число посадочных мест")
    public Integer seatsCount;
    /**
     * Широта в WGS-84
     * (Required)
     *
     */
    @JsonProperty("Latitude_WGS84")
    @JsonPropertyDescription("Широта в WGS-84")
    public String latitudeWGS84;
    /**
     * global_id
     * (Required)
     *
     */
    @JsonProperty("global_id")
    @JsonPropertyDescription("global_id")
    public Integer globalId;
    /**
     * Вид объекта
     * (Required)
     *
     */
    @JsonProperty("TypeObject")
    @JsonPropertyDescription("Вид объекта")
    public String typeString;
    /**
     * Показатель социальных льгот
     * (Required)
     *
     */
    @JsonProperty("SocialPrivileges")
    @JsonPropertyDescription("Показатель социальных льгот")
    public String socialPrivileges;
    /**
     * Административный округ
     * (Required)
     *
     */
    @JsonProperty("AdmArea")
    @JsonPropertyDescription("Административный округ")
    public String admArea;
    /**
     * Контактный телефон
     * (Required)
     *
     */
    @JsonProperty("PublicPhone")
    @JsonPropertyDescription("Контактный телефон")
    public List<PublicPhone> publicPhone;
    /**
     * Наименование
     * (Required)
     *
     */
    @JsonProperty("Name")
    @JsonPropertyDescription("Название")
    public String name;
    /**
     * is_deleted
     * (Required)
     *
     */
    @JsonProperty("is_deleted")
    @JsonPropertyDescription("is_deleted")
    public Boolean isDeleted;
    /**
     * system_object_id
     *
     */
    @JsonProperty("system_object_id")
    @JsonPropertyDescription("system_object_id")
    public String systemObjectId;
    /**
     * Район
     * (Required)
     *
     */
    @JsonProperty("District")
    @JsonPropertyDescription("Район")
    public String district;
    /**
     * Название управляющей компании
     *
     */
    @JsonProperty("OperatingCompany")
    @JsonPropertyDescription("Название управляющей компании")
    public String operatingCompany;
    /**
     * Адрес
     * (Required)
     *
     */
    @JsonProperty("Address")
    @JsonPropertyDescription("Адрес")
    public String address;
    /**
     * Код
     * (Required)
     *
     */
    @JsonProperty("ID")
    @JsonPropertyDescription("Код")
    public String iD;
    /**
     * Является сетевым
     * (Required)
     *
     */
    @JsonProperty("IsNetObject")
    @JsonPropertyDescription("Является сетевым")
    public String isNetObject;
    /**
     * signature_date
     *
     */
    @JsonProperty("signature_date")
    @JsonPropertyDescription("signature_date")
    public String signatureDate;

}