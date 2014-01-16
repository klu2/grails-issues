package grails.issues

import grails.validation.Validateable

@Validateable
class UpdateBlogCommand {
    Long id
    Long version

    String title
}
