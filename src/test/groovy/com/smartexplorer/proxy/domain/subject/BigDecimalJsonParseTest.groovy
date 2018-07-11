package com.smartexplorer.proxy.domain.subject

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

/**
 * @Author Karol Meksuła
 * 11-07-2018
 * */

class BigDecimalJsonParseTest extends Specification {

    def 'deserialize BigDecimal test'() {
        setup:
        def info = new SpotInformation()
        info.discountedTicketPrice = new BigDecimal(19.50)
        info.normalTicketPrice = new BigDecimal(24.00)

        expect:
        print(new ObjectMapper().writeValueAsString(info))
    }

}
