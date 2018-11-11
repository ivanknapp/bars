package ru.knappia.bars.utils;

import ru.knappia.bars.camel.model.bar.Bar;
import ru.knappia.bars.camel.model.bar.PublicPhone;
import ru.knappia.bars.repository.LegalEntity;

import java.util.function.Function;
import java.util.stream.Collectors;

public class BarMapper implements Function<Object, Object> {

    @Override
    public Object apply(Object object) {
        if (object instanceof Bar) {
            final Bar bar = (Bar) object;
            final LegalEntity entity = new LegalEntity();

            entity.setType(bar.getTypeObject());
            entity.setId(bar.getGlobalId());
            entity.setName(bar.getName());
            entity.setAddress(bar.getAddress());
            entity.setAdmArea(bar.getAdmArea());
            entity.setDistrict(bar.getDistrict());
            entity.setPublicPhone(bar.getPublicPhone().stream().map(PublicPhone::getPublicPhone).collect(Collectors.joining("; ")));
            entity.setSitCount(bar.getSeatsCount() );
            entity.setLatitudeWGS84(bar.getLatitudeWGS84());
            entity.setLongitudeWGS84(bar.getLongitudeWGS84());

            return entity;
        }
        return new IllegalAccessException("Object must be instance of Bar.class");
    }
}
