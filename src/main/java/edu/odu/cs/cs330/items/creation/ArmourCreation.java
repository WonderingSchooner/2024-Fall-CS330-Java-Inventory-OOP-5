package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Tool;
import edu.odu.cs.cs330.items.Armour;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ArmourCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ArmourCreation construct()
    {
        return new ArmourCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Return a **Default** Armour
        return new Armour();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // Replace the return value;
        return 7;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        int dur = Integer.parseInt(tokens[2]);
        int def = Integer.parseInt(tokens[3]);
        int lvl = Integer.parseInt(tokens[5]);
        return new Armour(
            tokens[0], 
            dur, 
            def, 
            tokens[1], 
            tokens[4], 
            lvl, 
            tokens[6]
        );
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal",
        "PMD.OnlyOneReturn"
    })
    @Override
    public Item fromExisting(final Item original)
    {
        if (!(original instanceof Armour)) {
            return null;
        }

        Armour theOriginal = (Armour) original;

        return new Armour(
            theOriginal.getName(),
            theOriginal.getDurability(),
            theOriginal.getDefense(),
            theOriginal.getMaterial(),
            theOriginal.getModifier(),
            theOriginal.getModifierLevel(),
            theOriginal.getElement()
        );
    }
}
