package com.acikek.speakcoherently.item;

import com.acikek.speakcoherently.effect.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModPotions {

	public static final Potion SILENCE_POTION = createPotion(ModStatusEffects.SILENCE, 2400, 0);
	public static final Potion LONG_SILENCE_POTION = createPotion(ModStatusEffects.SILENCE, 4800, 0);

	public static Potion createPotion(StatusEffect effect, int duration, int level) {
		return new Potion(new StatusEffectInstance(effect, duration, level, false, true, true));
	}

	public static Map<String, Potion> POTIONS = new LinkedHashMap<>();

	static {
		POTIONS.put("silence_potion", SILENCE_POTION);
		POTIONS.put("long_silence_potion", LONG_SILENCE_POTION);
	}

	public static void register() {
		for (Map.Entry<String, Potion> potion : POTIONS.entrySet()) {
			Registry.register(Registry.POTION, potion.getKey(), potion.getValue());
		}
	}

	public static Item[] BASES = new Item[] {
			Items.POTION, Items.SPLASH_POTION, Items.LINGERING_POTION, Items.TIPPED_ARROW
	};

	public static void appendStacks(List<ItemStack> stacks) {
		for (Potion potion : POTIONS.values()) {
			for (Item item : BASES) {
				stacks.add(PotionUtil.setPotion(item.getDefaultStack(), potion));
			}
		}
	}
}
