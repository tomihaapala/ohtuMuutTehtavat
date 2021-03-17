/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author Tomi
 */
public class QueryBuilder {

    Matcher matchers;

    public QueryBuilder() {
        matchers = new All();
    }

    public Matcher build() {
        return matchers;
    }

    public QueryBuilder playsIn(String team) {
        this.matchers = new And(new PlaysIn(team),this.matchers);
        return this;
    }

    public QueryBuilder hasAtLeast(int luku, String mita) {
        this.matchers = new And(new HasAtLeast(luku, mita),this.matchers);
        return this;
    }
        public QueryBuilder hasFewerThan(int luku, String mita) {
        this.matchers = new And(new HasFewerThan(luku, mita), this.matchers);
        return this;
    }
        public QueryBuilder oneOf(Matcher ...matcherss) {
        this.matchers = new Or(matcherss);
        return this;
    }
}
