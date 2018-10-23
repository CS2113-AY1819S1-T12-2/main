package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.medhistory.MedHistory;

/**
 * Tests that a {@code Person}'s {@code Last Visited Country} matches any of the keyword given.
 */
public class CountryContainsKeywordsPredicate implements Predicate<MedHistory> {
    private final List<String> keywords;

    public CountryContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(MedHistory medHistory) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(medHistory.getPrevCountry().value, keyword));
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CountryContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((CountryContainsKeywordsPredicate) other).keywords)); // state check
    }

}
