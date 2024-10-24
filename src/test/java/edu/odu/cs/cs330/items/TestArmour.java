package edu.odu.cs.cs330.items;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * 1 - Does this piece of code perform the operations
 *     it was designed to perform?
 *
 * 2 - Does this piece of code do something it was not
 *     designed to perform?
 *
 * 1 Test per mutator
 */
@SuppressWarnings({
    "PMD.AtLeastOneConstructor",
    "PMD.AvoidDuplicateLiterals",
    "PMD.BeanMembersShouldSerialize",
    "PMD.JUnitAssertionsShouldIncludeMessage",
    "PMD.JUnitTestContainsTooManyAsserts",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LawOfDemeter"
})
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestArmour
{
    private Armour fancyArmour;

    @BeforeEach
    public void setUp()
    {
        fancyArmour = new Armour(
            "Fancy",
            9001,
            62,
            "Vibranium",
            "ProcrastinationReduction",
            999_999,
            "H20"
        );
    }

    @Test
    public void testDefaultConstructor()
    {
        Armour genericArmour = new Armour();
        Item  genericRef = (Item) genericArmour;

        assertFalse(genericArmour.isStackable());
        assertFalse(genericRef.isStackable());

        // I should really complete this unit test with calls to each of the
        // accessors. However, I will forgo the remaining checks for this test
    }

    @Test
    public void testToString()
    {
        String expected = String.join(
            System.lineSeparator(),
            "  Nme: Fancy",
            "  Dur: 9001",
            "  Def: 62",
            "  Mtl: Vibranium",
            "  Mdr: ProcrastinationReduction (Lvl 999999)",
            "  Emt: H20",
            ""
        );

        assertThat(fancyArmour.toString(), equalTo(expected));
    }

    @Test
    public void testEqualsAndHashCode()
    {
        Armour generic = new Armour();

        assertThat(fancyArmour, not(equalTo(generic)));

        Armour imitation = new Armour(
            "Fancy",
            12,
            62,
            "Vibranium",
            "ProcrastinationReduction",
            999_999,
            "H20"
        );

        assertThat(fancyArmour, is(equalTo(imitation)));
        assertThat(fancyArmour.hashCode(), equalTo(imitation.hashCode()));

        imitation = new Armour(
            "Fancy",
            9001,
            1234,
            "Vibranium",
            "ProcrastinationReduction",
            999_999,
            "H20"
        );
        assertThat(fancyArmour, is(not(equalTo(imitation))));
        assertThat(fancyArmour.hashCode(), not(equalTo(imitation.hashCode())));

        imitation = new Armour(
            "Fancy",
            9001,
            62,
            "Vibranium",
            "ProcrastinationReduction",
            8888,
            "H20"
        );
        assertThat(fancyArmour, is(not(equalTo(imitation))));
        assertThat(fancyArmour.hashCode(), not(equalTo(imitation.hashCode())));

        imitation = new Armour(
            "More Fancy!",
            9001,
            62,
            "Vibranium",
            "ProcrastinationReduction",
            999_999,
            "H20"
        );
        assertThat(fancyArmour, is(not(equalTo(imitation))));
        assertThat(fancyArmour.hashCode(), not(equalTo(imitation.hashCode())));

        imitation = new Armour(
            "Fancy",
            9001,
            62,
            "Nacho Cheese Doritos",
            "ProcrastinationReduction",
            999_999,
            "H20"
        );
        assertThat(fancyArmour, is(not(equalTo(imitation))));
        assertThat(fancyArmour.hashCode(), not(equalTo(imitation.hashCode())));

        imitation = new Armour(
            "Fancy",
            9001,
            62,
            "Vibranium",
            "Eat more green vegetables",
            999_999,
            "H20"
        );
        assertThat(fancyArmour, is(not(equalTo(imitation))));
        assertThat(fancyArmour.hashCode(), not(equalTo(imitation.hashCode())));

        imitation = new Armour(
            "Fancy",
            9001,
            62,
            "Vibranium",
            "ProcrastinationReduction",
            999_999,
            "Aluminum"
        );
        assertThat(fancyArmour, is(not(equalTo(imitation))));
        assertThat(fancyArmour.hashCode(), not(equalTo(imitation.hashCode())));

        // Test Armour vs non-Armour object
        assertThat(imitation, not(equalTo("")));
    }
}

