package com.hh.export.utils;

import java.time.Instant;
import java.util.Date;

public interface AppUtils {

    static Date getInstant() {
        return Date.from(Instant.now());
    }

}
