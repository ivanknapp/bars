package ru.knappia.bars.utils;

import ru.knappia.bars.camel.model.bar.PublicPhone;
import ru.knappia.bars.camel.model.cafe.Cafe;
import ru.knappia.bars.repository.LegalEntity;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CafeMapper implements Function<Object, Object> {

    @Override
    public Object apply(Object object) {
        if (object instanceof Cafe) {
            final Cafe cafe = (Cafe) object;
            final LegalEntity entity = new LegalEntity();

            entity.setType(cafe.getTypeString());
            entity.setId(cafe.getGlobalId());
            entity.setName(cafe.getName());
            entity.setAddress(cafe.getAddress());
            entity.setAdmArea(cafe.getAdmArea());
            entity.setDistrict(cafe.getDistrict());
            entity.setPublicPhone(cafe.getPublicPhone().stream().map(PublicPhone::getPublicPhone).collect(Collectors.joining("; ")));
            entity.setSitCount(cafe.getSeatsCount() );

            entity.setLatitudeWGS84(cafe.getLatitudeWGS84());
            entity.setLongitudeWGS84(cafe.getLongitudeWGS84());

            return entity;
        }
        return new IllegalAccessException("Object must be instance of Cafe.class");
    }
}
