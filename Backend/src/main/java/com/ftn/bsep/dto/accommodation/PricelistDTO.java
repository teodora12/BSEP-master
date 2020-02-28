package com.ftn.bsep.dto.accommodation;

import com.ftn.bsep.model.modelGenerated.Pricelist;

import java.util.List;

public class PricelistDTO {

    private Long id;

    private List<ItemDTO> itemDTOS;

    public PricelistDTO(){

    }

    public PricelistDTO(Pricelist pricelist){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemDTO> getItemDTOS() {
        return itemDTOS;
    }

    public void setItemDTOS(List<ItemDTO> itemDTOS) {
        this.itemDTOS = itemDTOS;
    }
}
