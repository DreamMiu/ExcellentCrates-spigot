package su.nightexpress.excellentcrates.crate.effect.impl;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import su.nexmedia.engine.api.particle.SimpleParticle;
import su.nightexpress.excellentcrates.crate.effect.CrateEffect;

public class CrateVortexEffect extends CrateEffect {

    private static final int    STRANDS   = 2;
    private static final int    PARTICLES = 170 / 5;
    private static final float  RADIUS    = 1.5F;
    private static final float  CURVE     = 2.0F;
    private static final double ROTATION  = 0.7853981633974483D;

    public CrateVortexEffect() {
        super(1L, PARTICLES);
    }

    @Override
    public void doStep(@NotNull Location loc, @NotNull SimpleParticle particle, int step) {
        for (int boost = 0; boost < 3; boost++) {
            for (int strand = 1; strand <= STRANDS; ++strand) {
                float progress = step / (float) PARTICLES;
                double point = CURVE * progress * 2.0f * Math.PI / STRANDS + 6.283185307179586 * strand / STRANDS + ROTATION;
                double addX = Math.cos(point) * progress * RADIUS;
                double addZ = Math.sin(point) * progress * RADIUS;
                double addY = 3.5D - 0.02 * 5 * step;
                Location location = loc.clone().add(addX, addY, addZ);
                particle.play(location, 0.1f, 0.0f, 1);
            }
        }
    }
}
