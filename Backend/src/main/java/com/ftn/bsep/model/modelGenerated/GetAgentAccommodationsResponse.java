
package com.ftn.bsep.model.modelGenerated;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/accommodation}Accommodation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accommodation"
})
@XmlRootElement(name = "GetAgentAccommodationsResponse", namespace = "http://www.ftn.uns.ac.rs/accommodation")
public class GetAgentAccommodationsResponse {

    @XmlElement(name = "Accommodation", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected List<Accommodation> accommodation;

    /**
     * Gets the value of the accommodation property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodation property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodation().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Accommodation }
     *
     *
     */
    public List<Accommodation> getAccommodation() {
        if (accommodation == null) {
            accommodation = new ArrayList<Accommodation>();
        }
        return this.accommodation;
    }

}
