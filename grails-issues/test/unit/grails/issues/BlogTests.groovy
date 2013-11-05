package grails.issues

import grails.test.mixin.TestFor

/**
 * @author Klaus Lehner, Catalysts GmbH
 */
@TestFor(Blog)
class BlogTests {

    /**
     * This test fails in Grails 2.3.1 due to http://jira.grails.org/browse/GRAILS-10727 (entries is null)
     */
    void testCreateBlog() {
        def blog = new Blog(title: "My Blog").save()
        assert blog.entries != null
        assert blog.entries.empty
    }
}
