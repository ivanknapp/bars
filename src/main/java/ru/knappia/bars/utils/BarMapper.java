package ru.knappia.bars.utils;

import ru.knappia.bars.camel.model.Bar;
import ru.knappia.bars.camel.model.PublicPhone;
import ru.knappia.bars.repository.BarEntity;

import java.util.function.Function;
import java.util.stream.Collectors;

public class BarMapper implements Function<Object, Object> {

    @Override
    public Object apply(Object object) {
        if (object instanceof Bar) {
            final Bar bar = (Bar) object;
            final BarEntity barEntity = new BarEntity();

            barEntity.setId(bar.getGlobalId());
            barEntity.setName(bar.getName());
            barEntity.setAddress(bar.getAddress());
            barEntity.setAdmArea(bar.getAdmArea());
            barEntity.setDistrict(bar.getDistrict());
            barEntity.setPublicPhone(bar.getPublicPhone().stream().map(PublicPhone::getPublicPhone).collect(Collectors.joining("; ")));
            barEntity.setLatitudeWGS84(bar.getLatitudeWGS84());
            barEntity.setLongitudeWGS84(bar.getLongitudeWGS84());

            return barEntity;
        }
        return new IllegalAccessException("Object must be instance of Bar.class");
    }
}
