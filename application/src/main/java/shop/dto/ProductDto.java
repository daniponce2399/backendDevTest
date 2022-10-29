package shop.dto;

import java.math.BigDecimal;

/**
 * Product Dto
 */
public class ProductDto {
    private String id;
    private String name;
    private BigDecimal price;
    private boolean availability;

    /**
     * Id getter
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Id setter
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Price getter
     *
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Price setter
     *
     * @param price BigDecimal
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Availability getter
     *
     * @return availability
     */
    public boolean isAvailability() {
        return availability;
    }

    /**
     * Availability setter
     *
     * @param availability boolean
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
