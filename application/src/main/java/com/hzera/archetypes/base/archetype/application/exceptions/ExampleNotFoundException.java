package com.hzera.archetypes.base.archetype.application.exceptions;

import com.hzera.archetypes.base.archetype.common.domain.HZeraBusinessException;

public class ExampleNotFoundException extends HZeraBusinessException {

    public ExampleNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }
}
