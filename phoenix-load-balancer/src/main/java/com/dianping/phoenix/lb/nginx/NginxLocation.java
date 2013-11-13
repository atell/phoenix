/**
 * Project: phoenix-load-balancer
 * 
 * File Created at Oct 30, 2013
 * 
 */
package com.dianping.phoenix.lb.nginx;

import java.util.ArrayList;
import java.util.List;

import com.dianping.phoenix.lb.model.configure.entity.Directive;

/**
 * @author Leo Liang
 * 
 */
public class NginxLocation {
    public static enum MatchType {
        EXACT, PREFIX, REGEX_CASE_INSENSITIVE, REGEX_CASE_SENSITIVE, COMMON;
    }

    private MatchType       matchType;
    private String          pattern;
    private String          domain;
    private List<Directive> directives = new ArrayList<Directive>();

    /**
     * @return the matchType
     */
    public MatchType getMatchType() {
        return matchType;
    }

    /**
     * @param matchType
     *            the matchType to set
     */
    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern
     *            the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return the directives
     */
    public List<Directive> getDirectives() {
        return directives;
    }

    public void addDirective(Directive directive) {
        this.directives.add(directive);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
