package grails.issues

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Blog)
class BlogSpec extends Specification {

    void "testCreateBlogCheckEntries"() {
        def blog = new Blog(title: "My Blog").save()
        assert blog.entries != null
        assert blog.entries.empty
    }
}
