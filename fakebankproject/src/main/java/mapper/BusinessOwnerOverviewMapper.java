package mapper;

import dto.BusinessOwnerDTO;
import model.BusinessOwner;

public class BusinessOwnerOverviewMapper {
    public static BusinessOwnerDTO toDTO(BusinessOwner businessOwner) {
        if (businessOwner == null) {
            return null;
        }

        BusinessOwnerDTO dto = new BusinessOwnerDTO();
        dto.setCompanyName(businessOwner.getCompanyName());
        dto.setTaxId(businessOwner.getTaxID());
        dto.setEmail(businessOwner.getCompanyEmail());
        dto.setPhoneNumber(businessOwner.getCompanyPhoneNumber());
        return dto;
    }
}
