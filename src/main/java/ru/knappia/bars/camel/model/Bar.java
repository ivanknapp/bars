package ru.knappia.bars.camel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

/**
 * Бары
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
public class Bar {

    /**
     * Долгота в WGS-84
     * (Required)
     *
     */
    @JsonProperty("Longitude_WGS84")
    @JsonPropertyDescription("Долгота в WGS-84")
    private String longitudeWGS84;
    /**
     * Число посадочных мест
     * (Required)
     *
     */
    @JsonProperty("SeatsCount")
    @JsonPropertyDescription("Число посадочных мест")
    private Integer seatsCount;
    /**
     * Широта в WGS-84
     * (Required)
     *
     */
    @JsonProperty("Latitude_WGS84")
    @JsonPropertyDescription("Широта в WGS-84")
    private String latitudeWGS84;
    /**
     * global_id
     * (Required)
     *
     */
    @JsonProperty("global_id")
    @JsonPropertyDescription("global_id")
    private Integer globalId;
    /**
     * Вид объекта
     * (Required)
     *
     */
    @JsonProperty("TypeObject")
    @JsonPropertyDescription("Вид объекта")
    private String typeObject;
    /**
     * Показатель социальных льгот
     * (Required)
     *
     */
    @JsonProperty("SocialPrivileges")
    @JsonPropertyDescription("Показатель социальных льгот")
    private String socialPrivileges;
    /**
     * Административный округ
     * (Required)
     *
     */
    @JsonProperty("AdmArea")
    @JsonPropertyDescription("Административный округ")
    private String admArea;
    /**
     * Контактный телефон
     * (Required)
     *
     */
    @JsonProperty("PublicPhone")
    @JsonPropertyDescription("Контактный телефон")
    private List<PublicPhone> publicPhone;
    /**
     * Наименование
     * (Required)
     *
     */
    @JsonProperty("Name")
    @JsonPropertyDescription("Название")
    private String name;
    /**
     * is_deleted
     * (Required)
     *
     */
    @JsonProperty("is_deleted")
    @JsonPropertyDescription("is_deleted")
    private Boolean isDeleted;
    /**
     * system_object_id
     *
     */
    @JsonProperty("system_object_id")
    @JsonPropertyDescription("system_object_id")
    private String systemObjectId;
    /**
     * Район
     * (Required)
     *
     */
    @JsonProperty("District")
    @JsonPropertyDescription("Район")
    private String district;
    /**
     * Название управляющей компании
     *
     */
    @JsonProperty("OperatingCompany")
    @JsonPropertyDescription("Название управляющей компании")
    private String operatingCompany;
    /**
     * Адрес
     * (Required)
     *
     */
    @JsonProperty("Address")
    @JsonPropertyDescription("Адрес")
    private String address;
    /**
     * Код
     * (Required)
     *
     */
    @JsonProperty("ID")
    @JsonPropertyDescription("Код")
    private String iD;
    /**
     * Является сетевым
     * (Required)
     *
     */
    @JsonProperty("IsNetObject")
    @JsonPropertyDescription("Является сетевым")
    private String isNetObject;
    /**
     * signature_date
     *
     */
    @JsonProperty("signature_date")
    @JsonPropertyDescription("signature_date")
    private String signatureDate;


    @Override
    public String toString() {
        return "Bar{" +
                "longitudeWGS84='" + longitudeWGS84 + '\'' +
                ", seatsCount=" + seatsCount +
                ", latitudeWGS84=" + latitudeWGS84 +
                ", globalId=" + globalId +
                ", typeObject=" + typeObject +
                ", socialPrivileges=" + socialPrivileges +
                ", admArea=" + admArea +
                ", publicPhone=" + publicPhone +
                ", name=" + name +
                ", isDeleted=" + isDeleted +
                ", systemObjectId=" + systemObjectId +
                ", district=" + district +
                ", operatingCompany=" + operatingCompany +
                ", address=" + address +
                ", iD=" + iD +
                ", isNetObject=" + isNetObject +
                ", signatureDate=" + signatureDate +
                '}';
    }
}