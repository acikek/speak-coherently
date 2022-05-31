package com.acikek.speakcoherently.effect;

import com.acikek.speakcoherently.SpeakCoherently;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {

	public static final StatusEffect SILENCE = new StatusEffect(StatusEffectType.HARMFUL, 0) {};

	public static void register() {
		Registry.register(Registry.STATUS_EFFECT, SpeakCoherently.id("silence"), SILENCE);
	}
}
