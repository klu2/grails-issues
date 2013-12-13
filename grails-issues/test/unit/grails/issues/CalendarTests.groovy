package grails.issues

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Calendar)
class CalendarTests {

    /**
     * This test case fails in Grails 2.3.1 due to the existence of Calendar.getWorkdays(). If you remove
     * this getter from the domain class, then surprisingly also databinding via constructor works.
     *
     * @see http://jira.grails.org/browse/GRAILS-10728
     */
    void testInitiateWithConstructor() {
        def cal = new Calendar(workdays: [java.util.Calendar.MONDAY, java.util.Calendar.TUESDAY]).save(failOnError: true)
        assert cal != null
    }

    void testInitiateWithSetter() {
        def cal = new Calendar()
        cal.workdays = [java.util.Calendar.MONDAY, java.util.Calendar.TUESDAY]
        cal = cal.save()
        assert cal != null
    }

}
