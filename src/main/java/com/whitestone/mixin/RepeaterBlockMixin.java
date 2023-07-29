package com.whitestone.mixin;

import net.minecraft.block.RepeaterBlock;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;

import static com.whitestone.Whitestone.MEME_PERCENT;

@Mixin(RepeaterBlock.class)
public class RepeaterBlockMixin {

    public String getTranslationKey() {
        String translationKey = "block.minecraft.repeater";
        if (Random.create().nextBetween(0, MEME_PERCENT) == 0) {
            translationKey += ".meme";
        }
        return translationKey;
    }

}
