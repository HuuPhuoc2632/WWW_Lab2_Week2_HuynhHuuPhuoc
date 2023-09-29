package vn.edu.iuh.fit.huynhhuuphuoc_week2.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.huynhhuuphuoc_week2.enums.EmployeeStatus;

import java.util.stream.Stream;

@Converter(autoApply = true )
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {


    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if(attribute==null){
            return null;
        }
        return attribute.getValue();
    }

    //Chuyển  đổi CSDL thành kiểu Enum
    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if(dbData==null){
            return null;
        }
        return Stream.of(EmployeeStatus.values())
                .filter(c-> c.getValue() ==dbData)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
