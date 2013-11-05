package grails.issues

class Blog {

    String title

    static hasMany = [entries:BlogEntry]

    static constraints = {
        title nullable: false
    }
}
