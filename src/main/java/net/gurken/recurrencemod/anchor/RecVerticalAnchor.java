package net.gurken.recurrencemod.anchor;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import java.util.function.Function;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.WorldGenerationContext;

import java.util.function.Function;

public interface RecVerticalAnchor {
    //This is a copy of Mojang's vertical anchor interface. It will be altered or removed in future updates
    Codec<RecVerticalAnchor> CODEC = ExtraCodecs.xor(RecVerticalAnchor.Absolute.CODEC, ExtraCodecs.xor(RecVerticalAnchor.AboveBottom.CODEC, RecVerticalAnchor.BelowTop.CODEC)).xmap(RecVerticalAnchor::merge, RecVerticalAnchor::split);
    RecVerticalAnchor BOTTOM = aboveBottom(0);
    RecVerticalAnchor TOP = belowTop(0);

    static RecVerticalAnchor absolute(int pValue) {
        return new RecVerticalAnchor.Absolute(pValue);
    }

    static RecVerticalAnchor aboveBottom(int pValue) {
        return new RecVerticalAnchor.AboveBottom(pValue);
    }

    static RecVerticalAnchor belowTop(int pValue) {
        return new RecVerticalAnchor.BelowTop(pValue);
    }

    static RecVerticalAnchor bottom() {
        return BOTTOM;
    }

    static RecVerticalAnchor top() {
        return TOP;
    }

    private static RecVerticalAnchor merge(Either<RecVerticalAnchor.Absolute, Either<RecVerticalAnchor.AboveBottom, RecVerticalAnchor.BelowTop>> p_158925_) {
        return p_158925_.map(Function.identity(), (p_209698_) -> {
            return p_209698_.map(Function.identity(), Function.identity());
        });
    }

    private static Either<RecVerticalAnchor.Absolute, Either<RecVerticalAnchor.AboveBottom, RecVerticalAnchor.BelowTop>> split(RecVerticalAnchor p_158927_) {
        return p_158927_ instanceof RecVerticalAnchor.Absolute ? Either.left((RecVerticalAnchor.Absolute)p_158927_) : Either.right(p_158927_ instanceof RecVerticalAnchor.AboveBottom ? Either.left((RecVerticalAnchor.AboveBottom)p_158927_) : Either.right((RecVerticalAnchor.BelowTop)p_158927_));
    }

    int resolveY(WorldGenerationContext pContext);

    public static record AboveBottom(int offset) implements RecVerticalAnchor {
        public static final Codec<RecVerticalAnchor.AboveBottom> CODEC = Codec.intRange(DimensionType.MIN_Y, DimensionType.MAX_Y).fieldOf("above_bottom").xmap(RecVerticalAnchor.AboveBottom::new, RecVerticalAnchor.AboveBottom::offset).codec();

        public int resolveY(WorldGenerationContext p_158942_) {
            return p_158942_.getMinGenY() + this.offset;
        }

        public String toString() {
            return this.offset + " above bottom";
        }
    }

    public static record Absolute(int y) implements RecVerticalAnchor {
        public static final Codec<RecVerticalAnchor.Absolute> CODEC = Codec.intRange(DimensionType.MIN_Y, DimensionType.MAX_Y).fieldOf("absolute").xmap(RecVerticalAnchor.Absolute::new, RecVerticalAnchor.Absolute::y).codec();

        public int resolveY(WorldGenerationContext p_158949_) {
            return this.y;
        }

        public String toString() {
            return this.y + " absolute";
        }
    }

    public static record BelowTop(int offset) implements RecVerticalAnchor {
        public static final Codec<RecVerticalAnchor.BelowTop> CODEC = Codec.intRange(DimensionType.MIN_Y, DimensionType.MAX_Y).fieldOf("below_top").xmap(RecVerticalAnchor.BelowTop::new, RecVerticalAnchor.BelowTop::offset).codec();

        public int resolveY(WorldGenerationContext p_158956_) {
            return p_158956_.getGenDepth() - 1 + p_158956_.getMinGenY() - this.offset;
        }

        public String toString() {
            return this.offset + " below top";
        }
    }
}
