package com.acikek.speakcoherently.item;

import com.acikek.speakcoherently.SpeakCoherently;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {

	public static final Brazil BRAZIL = new Brazil(defaultSettings());

	public static QuiltItemSettings defaultSettings() {
		return new QuiltItemSettings().group(SpeakCoherently.ITEM_GROUP);
	}

	public static Map<String, Item> ITEMS = new LinkedHashMap<>();

	static {
		ITEMS.put("brazil", BRAZIL);
	}

	public static void register() {
		for (Map.Entry<String, Item> item : ITEMS.entrySet()) {
			Registry.register(Registry.ITEM, SpeakCoherently.id(item.getKey()), item.getValue());
		}
	}
}
