package prompt;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife.
         Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband
         and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (person.man == this.man || this.spouse == person) return false;

        this.spouse.divorce();
        this.divorce();
        person.spouse.divorce(); // два экземпляра одного класса полностью друг другу открыты
        // (private защитит только от других классов)
        person.divorce();

        this.spouse = person;
        person.spouse = this;
        return true;
    }

    /**
     * Sets spouse = null if spouse is not null
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (this.spouse != null){
            this.spouse = null;
            return true;
        }

        return false;
    }
}

/*
     * Рассмотрим часто используемые теги Javadoc:

     @author идентифицирует автора исходного кода.
     @deprecated идентифицирует исходный код субъекта (например, метод), который больше не будет использоваться.
     @param определяет один из параметров метода.
     @see - ссылка.
     @since идентифицирует версию программного обеспечения.
     @return определяет тип значения, возвращаемого методом.
     @throws – выбрасываемые методом исключения.


     Хотя комментарии Javadoc игнорируются компилятором, но обрабатываются javadoc , который собирает их в HTML на основе документации. Например, следующая команда создает документацию для гипотетического Checkers класса:

     javadoc Checkers
*/