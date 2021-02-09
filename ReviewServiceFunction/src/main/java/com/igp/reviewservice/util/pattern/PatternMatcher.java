package com.igp.reviewservice.util.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * An extremely btec version of scala's pattern matching. I wanted to use scala itself but AWS wouldn't let me :(
 */
@SuppressWarnings("unchecked") // warning - this isn't safe! honestly i cba to fix it bc type erasures a bitch - please dont fuck it up kthanks
public class PatternMatcher<T, R> {

    private final List<Case<T, R>> cases;

    private Case<T, R> defaultCase;

    public PatternMatcher() {
        this.cases = new ArrayList<>();
    }

    public PatternMatcher<T, R> defineCase(T input, R output, Guard... guards) {
        return defineCase((Case<T, R>) Case.constant(input).then(output).withGuards(guards));
    }

    public PatternMatcher<T, R> defineCase(Predicate<T> matcher, R output, Guard... guards) {
        return defineCase((Case<T, R>) Case.of(matcher).then(output).withGuards(guards));
    }

    public PatternMatcher<T, R> defineCase(Case<T, R> _case) {
        cases.add(_case);
        return this;
    }

    public PatternMatcher<T, R> defaultCase(R output) {
        this.defaultCase = Case.defaultCase(output);
        return this;
    }

    public R match(T input) {
        Objects.requireNonNull(defaultCase, "Default case can't be null");

        return cases.stream()
                .filter(c -> c.checkCaseMatches(input))
                .findFirst()
                .orElse(defaultCase).getOutput();
    }
}
