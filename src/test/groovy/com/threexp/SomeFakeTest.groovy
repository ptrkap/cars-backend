package com.threexp

import spock.lang.Specification

class SomeFakeTest extends Specification{

    def "should do nothing"() {
        given:
        int a = 1

        when:
        a++;

        then:
        a == 2;
    }
}
