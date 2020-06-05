package pl.brewit.brews.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class BrewSimple {
    private UUID id;
    @NotBlank @Size(max = 75) private String productName;
    @NotBlank @Size(max = 200) private String descShort;
    private Short tempCs;
    private Short timeMs;
    private Short volumeMl;
    private Short weightGm;

    public BrewSimple(UUID id, @NotBlank @Size(max = 75) String productName, @NotBlank @Size(max = 200) String descShort,
                      Short tempCs, Short timeMs, Short volumeMl, Short weightGm) {
        this.id = id;
        this.productName = productName;
        this.descShort = descShort;
        this.tempCs = tempCs;
        this.timeMs = timeMs;
        this.volumeMl = volumeMl;
        this.weightGm = weightGm;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public Short getTempCs() {
        return tempCs;
    }

    public void setTempCs(Short tempCs) {
        this.tempCs = tempCs;
    }

    public Short getTimeMs() {
        return timeMs;
    }

    public void setTimeMs(Short timeMs) {
        this.timeMs = timeMs;
    }

    public Short getVolumeMl() {
        return volumeMl;
    }

    public void setVolumeMl(Short volumeMl) {
        this.volumeMl = volumeMl;
    }

    public Short getWeightGm() {
        return weightGm;
    }

    public void setWeightGm(Short weightGm) {
        this.weightGm = weightGm;
    }
}