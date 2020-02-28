package com.ftn.agent.dto;

import com.ftn.agent.model.Pricelist;
import com.ftn.agent.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
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
