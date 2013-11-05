package grails.issues



import spock.lang.*

/**
 *
 */
class BlogIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "testCreateBlogCheckEntries"() {
        def blog = new Blog(title: "My Blog").save()
        assert blog.entries != null
        assert blog.entries.empty
    }
}
