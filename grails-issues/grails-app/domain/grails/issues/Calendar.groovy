package grails.issues


import org.springframework.util.StringUtils

class Calendar {

    static constraints = {
        _workdaysAsString blank: false, nullable: false
    }

    String _workdaysAsString
    private transient Set<Integer> _workdays

    Collection<Integer> getWorkdays() {
        checkWorkdaysInitialized()
        return Collections.unmodifiableSet(_workdays)
    }

    void setWorkdays(Collection<Integer> workdays) {
        _workdays = new HashSet<Integer>(workdays)
        updateWorkdays()
    }

    private void checkWorkdaysInitialized() {
        if (_workdays == null) {
            _workdays = []
            for (String s : _workdaysAsString?.split(',')) {
                if (StringUtils.hasText(s)) {
                    _workdays.add(Integer.valueOf(s))
                }
            }
        }
    }

    private void updateWorkdays() {
        _workdaysAsString = StringUtils.collectionToCommaDelimitedString(_workdays.sort())
    }
}